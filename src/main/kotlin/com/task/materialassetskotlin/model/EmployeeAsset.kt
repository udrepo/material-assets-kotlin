package com.task.materialassetskotlin.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
data class EmployeeAsset(
    private var id: UUID? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val sum: Double? = null,
    val count: Long? = null
)