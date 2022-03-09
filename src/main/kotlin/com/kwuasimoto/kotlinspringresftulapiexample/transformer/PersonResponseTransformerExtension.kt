package com.kwausimoto.kotlinspringrestfulapiexample.transformer

import com.kwausimoto.kotlinspringrestfulapiexample.data.Person
import com.kwausimoto.kotlinspringrestfulapiexample.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}