package com.capou.tp1.model

sealed class MyObjectForRecyclerView()

//creation du data pour le header
data class UserDataHeader(
    val header: String
) : MyObjectForRecyclerView()


//creation du data pour footer
data class UserDataFooter(
    val footer: String
) : MyObjectForRecyclerView()


data class UserData(
    val name:String,
    val firstname:String,
    val gender:String
):MyObjectForRecyclerView()
