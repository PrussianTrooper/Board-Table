package com.prussian_trooper.tabledenunsionskotlin.learn_project.city

import org.json.JSONObject

object CityHelper {
    val jsonObject = JSONObject(jsonFile)
    val countryNames = jsonObject.names()

}