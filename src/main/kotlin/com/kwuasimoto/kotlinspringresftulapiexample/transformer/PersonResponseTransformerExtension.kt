package com.kwuasimoto.kotlinspringresftulapiexample.transformer

import com.kwuasimoto.kotlinspringresftulapiexample.data.Person
import com.kwuasimoto.kotlinspringresftulapiexample.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}