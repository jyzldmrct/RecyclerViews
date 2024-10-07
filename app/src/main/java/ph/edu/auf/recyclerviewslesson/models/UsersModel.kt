package ph.edu.auf.recyclerviewslesson.models

data class UsersModel(
    var username:String,
    var age: Int,
    var email: String,
    var type: Int,
    var address: String = "",
    )

