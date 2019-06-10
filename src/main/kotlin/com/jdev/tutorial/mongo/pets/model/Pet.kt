package com.jdev.tutorial.mongo.pets.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Pet(
        @Id
        var _id:ObjectId = ObjectId.get(),
        var name:String = "",
        var species:String = "",
        var breed:String = ""
)