package ru.bulyg.forretech.mvp.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class ResponseInfo(
    @Expose
    @SerializedName("createdAt")
    val createdAt: Date,
    @Expose
    val text: String
)