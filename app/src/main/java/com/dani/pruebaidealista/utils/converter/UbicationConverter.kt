package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.Ubication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UbicationConverter {

    @TypeConverter
    fun urlItemToString(item: Ubication): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): Ubication? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<Ubication>() {}.type)
    }
}
