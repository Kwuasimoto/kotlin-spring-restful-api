package com.kwuasimoto.kotlinspringresftulapiexample.resource

import com.kwuasimoto.kotlinspringresftulapiexample.dto.AddPersonRequest
import com.kwuasimoto.kotlinspringresftulapiexample.dto.PersonResponse
import com.kwuasimoto.kotlinspringresftulapiexample.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface PersonResource {

    fun findById(id: Long): ResponseEntity<PersonResponse?>
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse?>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse?>
    fun deleteById(id: Long): ResponseEntity<Unit>

}