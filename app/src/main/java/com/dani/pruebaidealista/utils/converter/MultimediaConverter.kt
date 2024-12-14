package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.Multimedia
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MultimediaConverter {

    @TypeConverter
    fun urlItemToString(item: Multimedia): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): Multimedia? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<Multimedia>() {}.type)
    }
}
