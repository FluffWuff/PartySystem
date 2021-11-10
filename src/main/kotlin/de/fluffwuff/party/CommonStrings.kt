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
package de.fluffwuff.party

//find & rename class name
data class CommonStrings(
    val prefix: String,
    val warpMessage: String,
    val jumpMessage: String,
    val jumpDisabledMessage: String,
    val chatDisabledMessage: String,
    val alreadyInPartyMessage: String,
    val notInAPartyMessage: String,
    val otherPlayerNotInAPartyMessage: String,
    val notPartyLeaderMessage: String,
    val playerNotInYourPartyMessage: String,
    val partyHelpMessage: String,
    val excludedServerList: MutableList<String>,
    val createdPartyMessage: String,
    val notAvailableAsPartyLeaderMessage: String
)
