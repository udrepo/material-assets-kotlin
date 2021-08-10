package com.task.materialassetskotlin.controller

import com.task.materialassetskotlin.model.Employee
import com.task.materialassetskotlin.repository.EmployeeRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/employee")
class EmployeeController (){

    constructor(employeeRepository: EmployeeRepository?) : this() {
        this.employeeRepository = employeeRepository
    }

    private var employeeRepository: EmployeeRepository? = null


    @GetMapping
    fun getEmployee(pageable: Pageable): Page<Employee>? = employeeRepository?.findAll(pageable)

}