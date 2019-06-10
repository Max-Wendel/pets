package com.jdev.tutorial.mongo.pets

import com.jdev.tutorial.mongo.pets.model.Pet
import com.jdev.tutorial.mongo.pets.model.PetOutDTO
import com.jdev.tutorial.mongo.pets.repository.PetRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/pet")
class Controller {

    @Autowired
    lateinit var repository: PetRepository

    @GetMapping("/")
    @ResponseBody
    fun getAllPets():HttpEntity<*>{
        return HttpEntity(
                repository.findAll().map {
                    PetOutDTO(it)
                }
        )
    }

    @GetMapping("/get/")
    @ResponseBody
    fun getPetByID(
            @RequestParam(name = "id") id:ObjectId
    ):HttpEntity<*>{
        return HttpEntity(
                PetOutDTO(repository.findBy_id(id))
        )
    }

    @PutMapping("/update/")
    @ResponseBody
    fun updatePet(
            @RequestParam(name ="id") id:String,
            @RequestBody pet: Pet
    ):HttpEntity<*>{
        pet._id=ObjectId(id)
        repository.save(pet)
        return HttpEntity(HttpStatus.OK)
    }

    @PostMapping("/save/")
    @ResponseBody
    fun createPet(
            @RequestBody pet: Pet
    ): HttpEntity<*> {
        repository.save(pet)
        return HttpEntity(
                PetOutDTO(repository.findBy_id(pet._id))
        )
    }

    @DeleteMapping("/delete")
    @ResponseBody
    fun deletePet(
            @RequestParam(name ="id") id: ObjectId
    ):HttpEntity<*> {
        repository.deleteBy_id(id)
        return HttpEntity(HttpStatus.OK)
    }

}