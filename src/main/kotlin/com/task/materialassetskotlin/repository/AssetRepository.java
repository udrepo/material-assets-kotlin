package com.task.materialassetskotlin.repository;

import com.task.materialassetskotlin.model.Asset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset, UUID> {

    Page<Asset> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Asset WHERE name = ?1", nativeQuery = true)
    Asset findByNameQuery(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE from asset\n" +
            "where id = ?1",
            nativeQuery = true)
    void deleteAssetById(String id);
}



