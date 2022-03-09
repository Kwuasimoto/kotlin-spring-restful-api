package com.kwuasimoto.kotlinspringresftulapiexample.service

import com.kwuasimoto.kotlinspringresftulapiexample.dao.PersonDAO
import com.kwuasimoto.kotlinspringresftulapiexample.data.Person
import com.kwuasimoto.kotlinspringresftulapiexample.dto.AddPersonRequest
import com.kwuasimoto.kotlinspringresftulapiexample.dto.PersonResponse
import com.kwuasimoto.kotlinspringresftulapiexample.dto.UpdatePersonRequest
import com.kwuasimoto.kotlinspringresftulapiexample.transformer.AddPersonRequestTransformer
import com.kwuasimoto.kotlinspringresftulapiexample.transformer.toPersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonManagementServiceImpl(
    private val personDAO: PersonDAO,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? =
        this.findPersonById(id).get().toPersonResponse()

    override fun findAll(pageable: Pageable): Page<PersonResponse> =
        this.personDAO.findAll(pageable).map(Person::toPersonResponse)

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