package com.task.materialassetskotlin.repository;

import com.task.materialassetskotlin.model.Employee;
import com.task.materialassetskotlin.model.EmployeeAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface EmployeeRepository {

    Page<Employee> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Employee WHERE id = ?1", nativeQuery = true)
    Employee findById(String id);

    @Query(value = "SELECT employee.*\n" +
            "FROM employee INNER JOIN asset\n" +
            "ON employee.id = asset.employee_id\n" +
            "group by employee.id",
            nativeQuery = true)
    List<Employee> findAllByAssetsContains();

    @Query("select new com.task.materialassetskotlin.model.EmployeeAsset(e .id, e .firstName, e .lastName, sum(a.price), count(a .price)) FROM Employee e left join e.assets a group by e.id")
    Page<EmployeeAsset> getEmployeeAssets(Pageable pageable);

    @Query(value = "SELECT employee.id, employee.first_name, sum(asset.price), count(asset.price)\n" +
            "FROM employee LEFT JOIN asset\n" +
            "ON employee.id = asset.employee_id\n" +
            "WHERE employee.id = ?1 group by employee.id",
            nativeQuery = true)
    List<Object> getEmployeeAssetsById(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE from asset using employee\n" +
            "where employee.id = asset.employee_id\n" +
            "and asset.employee_id = ?1",
            nativeQuery = true)
    void deleteEmployeeById(String id);


    @Modifying
    @Query(value = "update asset\n" +
            "set name = 'flower2', price=18000\n" +
            "where id = '633f2047-306e-4006-9a9e-5ed5d382a2f6'\n",
            nativeQuery = true)
    void updateAsset();
}
