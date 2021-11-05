/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  al
 */
package de.richtigeralex.party

import com.google.gson.GsonBuilder
import net.md_5.bungee.api.plugin.Plugin
import java.io.File
import java.io.IOException
import java.io.InputStream

class PartySystem : Plugin() {

    companion object {
        lateinit var COMMON_STRINGS: CommonStrings
    }

    override fun onEnable() {
        try {
            val inputStream: InputStream = File("$dataFolder/config.json").inputStream()
            val json = inputStream.bufferedReader().use { it.readText() }
            val gson = GsonBuilder().create()
            COMMON_STRINGS = gson.fromJson(json.replace('&', '§'), CommonStrings::class.java)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}