package com.example.nuevoproyecto.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostEntity (
val userId:Int,
val id:Int,
val title:String,
val body:String,
var read:Boolean=false,
var favorite:Boolean=false
        ):Parcelable

data class User(
val id:Int,
val name:String,
val username:String
)