package com.kwausimoto.kotlinspringrestfulapiexample.dao

import com.kwausimoto.kotlinspringrestfulapiexample.data.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDAO: JpaRepository<Person, Long>