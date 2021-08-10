package com.task.materialassetskotlin.model

import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table
data class Employee(
    @Id @GeneratedValue @Type(type = "uuid-char")
    private var id: UUID? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    @javax.persistence.OneToMany(targetEntity = Asset::class, cascade = [CascadeType.ALL])
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    var assets: List<Asset>? = null
)