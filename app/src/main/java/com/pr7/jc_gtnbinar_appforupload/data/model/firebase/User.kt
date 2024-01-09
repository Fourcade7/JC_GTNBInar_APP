package com.pr7.jc_gtnbinar_appforupload.data.model.firebase



import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User constructor(
    var key:String?="",
    var uid:String?="",
    var name:String?="",
    var surname:String?="",
    var gmail:String?="",
    var password:String?="",
):Parcelable