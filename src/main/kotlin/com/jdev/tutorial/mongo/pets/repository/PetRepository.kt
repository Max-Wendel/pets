package com.jdev.tutorial.mongo.pets.repository

import com.jdev.tutorial.mongo.pets.model.Pet
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PetRepository : MongoRepository<Pet,String>{
    fun findBy_id(_id: ObjectId):Pet

    fun deleteBy_id(_id: ObjectId)
}