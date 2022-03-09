package com.kwuasimoto.kotlinspringresftulapiexample.service

import com.kwuasimoto.kotlinspringresftulapiexample.dto.AddPersonRequest
import com.kwuasimoto.kotlinspringresftulapiexample.dto.PersonResponse
import com.kwuasimoto.kotlinspringresftulapiexample.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonManagementService {

    fun findById(id: Long): PersonResponse?
    fun findAll(pageable: Pageable): Page<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)

}