package com.kwuasimoto.kotlinspringresftulapiexample.dao

import com.kwuasimoto.kotlinspringresftulapiexample.data.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDAO: JpaRepository<Person, Long>