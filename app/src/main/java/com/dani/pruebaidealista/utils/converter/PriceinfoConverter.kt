package com.dani.pruebaidealista.utils.converter

import androidx.room.TypeConverter
import com.dani.domain.PriceInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PriceinfoConverter {

    @TypeConverter
    fun urlItemToString(item: PriceInfo): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToUrlItem(stringList: String?): PriceInfo? {
        return if (stringList == null) null
        else Gson().fromJson(stringList, object : TypeToken<PriceInfo>() {}.type)
    }
}
