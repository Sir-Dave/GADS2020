package com.sirdave.alcleaderboard.models

class Skills(name: String?, badgeUrl: String?, score: String?, country: String?) {
    var name : String? = null
    var badgeUrl: String? = null
    var score: String? = null
    var country: String? = null

    init {
        this.name = name
        this.badgeUrl = badgeUrl
        this.score = score
        this.country = country
    }
}