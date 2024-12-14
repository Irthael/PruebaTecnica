package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun urlItemToString(item: Type): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): Type? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<Type>() {}.type)
    }
}