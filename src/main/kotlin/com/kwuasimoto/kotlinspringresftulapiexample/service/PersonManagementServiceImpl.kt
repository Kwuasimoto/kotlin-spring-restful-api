package com.kwausimoto.kotlinspringrestfulapiexample.service

import com.kwausimoto.kotlinspringrestfulapiexample.dao.PersonDAO
import com.kwausimoto.kotlinspringrestfulapiexample.data.Person
import com.kwausimoto.kotlinspringrestfulapiexample.dto.AddPersonRequest
import com.kwausimoto.kotlinspringrestfulapiexample.dto.PersonResponse
import com.kwausimoto.kotlinspringrestfulapiexample.dto.UpdatePersonRequest
import com.kwausimoto.kotlinspringrestfulapiexample.transformer.AddPersonRequestTransformer
import com.kwausimoto.kotlinspringrestfulapiexample.transformer.toPersonResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonManagementServiceImpl(
    private val personDAO: PersonDAO,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? =
        this.findPersonById(id).get().toPersonResponse()

    override fun findAll(): List<PersonResponse> =
        this.personDAO.findAll().map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse =
        this.saveOrUpdate(addPersonRequestTransformer.transform(addPersonRequest))

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?:
            throw IllegalStateException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.get().apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteById(id: Long) = this.personDAO.deleteById(id)

    private fun findPersonById(id: Long): Optional<Person> = this.personDAO.findById(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDAO.save(person).toPersonResponse()
}