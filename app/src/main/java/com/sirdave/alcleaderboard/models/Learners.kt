package com.sirdave.alcleaderboard.models

class Learners(name: String?, image: String?, hours: String?, country: String?){
    var name : String? = null
    var image: String? = null
    var hours: String? = null
    var country: String? = null

    init {
        this.name = name
        this.image = image
        this.hours = hours
        this.country = country
    }
}