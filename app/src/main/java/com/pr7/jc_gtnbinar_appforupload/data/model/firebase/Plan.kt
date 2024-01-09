package com.pr7.jc_gtnbinar_appforupload.data.model.firebase


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Plan constructor(
    var key:String ?="",
    var name:String?="",
    var price:String?="",
):Parcelable