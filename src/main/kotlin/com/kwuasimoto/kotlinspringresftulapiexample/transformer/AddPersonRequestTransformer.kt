package com.kwausimoto.kotlinspringrestfulapiexample.transformer

import com.kwausimoto.kotlinspringrestfulapiexample.data.Person
import com.kwausimoto.kotlinspringrestfulapiexample.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer: Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
            name = source.name,
            lastName = source.lastName
        )
    }
}