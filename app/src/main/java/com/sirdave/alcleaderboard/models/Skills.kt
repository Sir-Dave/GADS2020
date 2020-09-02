package com.sirdave.alcleaderboard.models

class Skills(name: String?, image: String?, score: String?, country: String?) {
    var name : String? = null
    var image: String? = null
    var score: String? = null
    var country: String? = null

    init {
        this.name = name
        this.image = image
        this.score = score
        this.country = country
    }
}