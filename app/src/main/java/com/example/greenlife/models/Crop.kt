package com.example.greenlife.models

class Crop {
    var name:String = ""
    var soiltype:String = ""
    var temperature:String = ""
    var rainfall:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, soiltype: String, temperature: String,rainfall: String,phone: String, imageUrl: String, id: String) {
        this.name = name
        this.soiltype = soiltype
        this.temperature = temperature
        this.rainfall = rainfall
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}