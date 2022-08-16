package com.tuantran.finder.Model

import java.util.*

data class Users (var userId: Int,
                 var name: String,
                 var birthday : Date,
                 var profileImageUrl:List <Int>,
                 var sex : String,
                 var sexualOrientation : String,
                 var passions: List<String>)
