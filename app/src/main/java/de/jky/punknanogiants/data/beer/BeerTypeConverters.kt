package de.jky.punknanogiants.data.beer

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken


class RequestConverters {
    private val gson = Gson()
    private val typeTokenListOfStings = object : TypeToken<List<String?>?>() {}.type
    private val typeTokenListOfMash = object : TypeToken<List<MashTemp?>?>() {}.type
    private val typeTokenListOfMalt = object : TypeToken<List<Malt?>?>() {}.type

    @TypeConverter
    fun listStringToJsonStr(listMyModel: List<String>?): String? {
        return gson.toJson(listMyModel)
    }

    @TypeConverter
    fun jsonStrToListString(jsonStr: String?): List<String>? {
        return jsonStr?.let { gson.fromJson(jsonStr, typeTokenListOfStings) }
    }

    @TypeConverter
    fun listMashToJsonStr(listMash: List<MashTemp>?): String? {
        return gson.toJson(listMash)
    }

    @TypeConverter
    fun jsonMashToListString(jsonStr: String?): List<MashTemp>? {
        return jsonStr?.let { gson.fromJson(jsonStr, typeTokenListOfMash) }
    }

    @TypeConverter
    fun listMaltToJsonStr(listMalt: List<Malt>?): String? {
        return gson.toJson(listMalt)
    }

    @TypeConverter
    fun jsonMaltToListString(jsonStr: String?): List<Malt>? {
        return jsonStr?.let { gson.fromJson(jsonStr, typeTokenListOfMalt) }
    }

    @TypeConverter
    fun listHopToJsonStr(listHop: List<Hop>?): String? {
        return gson.toJson(listHop)
    }

    @TypeConverter
    fun jsonHopToListString(jsonStr: String?): List<Hop>? {
        return jsonStr?.let {
            gson.fromJson(jsonStr, typeTokenListOfStings)
        }
    }
}

