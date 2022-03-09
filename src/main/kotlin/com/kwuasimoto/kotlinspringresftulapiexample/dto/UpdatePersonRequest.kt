package com.kwausimoto.kotlinspringrestfulapiexample.dto

data class UpdatePersonRequest(
    val id: Long,
    val name: String,
    val lastName: String? = null
)
