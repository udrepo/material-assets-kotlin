package com.task.materialassetskotlin.model

import org.hibernate.annotations.Type
import org.springframework.data.annotation.Id
import java.util.*
import javax.persistence.*


@Entity
@Table
data class Asset(
    @javax.persistence.Id @GeneratedValue @Type(type = "uuid-char")
    var id: UUID? = null,
    var name: String?=null,
    var price: Double? = null,
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="employee_id", referencedColumnName="id")
    var employee: Employee
)
