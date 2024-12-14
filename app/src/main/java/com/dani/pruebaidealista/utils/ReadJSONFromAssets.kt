package com.dani.pruebaidealista.utils

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

fun ReadJSONFromAssets(file: InputStream): String {
    try {
        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        val jsonString = stringBuilder.toString()
        return jsonString
    } catch (e: Exception) {
        e.printStackTrace()
        return ""
    }
}
