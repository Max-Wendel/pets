package com.jdev.tutorial.mongo.pets.model

data class PetOutDTO(
        var id:String = "",
        var name:String = "",
        var species:String = "",
        var breed:String = ""
) {
    constructor(pet: Pet):this(
            id= pet._id.toHexString(),
            name=pet.name,
            species=pet.species,
            breed=pet.breed
    )
}