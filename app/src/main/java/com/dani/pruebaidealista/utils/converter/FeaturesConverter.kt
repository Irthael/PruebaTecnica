package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.Features
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FeaturesConverter {

    @TypeConverter
    fun urlItemToString(item: Features): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): Features? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<Features>() {}.type)
    }
}
