package com.kwuasimoto.kotlinspringresftulapiexample.transformer

import com.kwuasimoto.kotlinspringresftulapiexample.data.Person
import com.kwuasimoto.kotlinspringresftulapiexample.dto.AddPersonRequest
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