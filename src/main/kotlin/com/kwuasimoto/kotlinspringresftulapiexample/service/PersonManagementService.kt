package com.kwausimoto.kotlinspringrestfulapiexample.service

import com.kwausimoto.kotlinspringrestfulapiexample.dto.AddPersonRequest
import com.kwausimoto.kotlinspringrestfulapiexample.dto.PersonResponse
import com.kwausimoto.kotlinspringrestfulapiexample.dto.UpdatePersonRequest

interface PersonManagementService {

    fun findById(id: Long): PersonResponse?
    fun findAll(): List<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)

}