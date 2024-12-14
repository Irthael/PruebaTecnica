package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.MoreCharacteristics
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MoreCharacteristicsConverter {

    @TypeConverter
    fun urlItemToString(item: MoreCharacteristics): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): MoreCharacteristics? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<MoreCharacteristics>() {}.type)
    }
}
