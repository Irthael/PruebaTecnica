package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.EnergyCertification
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EnergyCertificationConverter {

    @TypeConverter
    fun urlItemToString(item: EnergyCertification): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): EnergyCertification? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<EnergyCertification>() {}.type)
    }
}
