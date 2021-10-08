package com.example.nuevoproyecto.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostEntity (
val userId:Int,
val id:Int,
val title:String,
val body:String
        ):Parcelable