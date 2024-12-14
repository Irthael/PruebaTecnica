package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.Images
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImagesConverter {

    @TypeConverter
    fun multimediaListToString(list: List<Images>): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun stringToMultimediaList(stringList: String?): List<Images>? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<List<Images>>() {}.type)
    }
}
