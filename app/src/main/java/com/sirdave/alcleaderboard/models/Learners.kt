package com.sirdave.alcleaderboard.models

class Learners(name: String?, badgeUrl: String?, hours: String?, country: String?){
    var name : String? = null
    var badgeUrl: String? = null
    var hours: String? = null
    var country: String? = null

    init {
        this.name = name
        this.badgeUrl = badgeUrl
        this.hours = hours
        this.country = country
    }
}