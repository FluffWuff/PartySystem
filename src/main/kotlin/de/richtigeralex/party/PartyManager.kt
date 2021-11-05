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

import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer

interface PartyManager {

    val parties: MutableList<Party>

    fun createParty(player: ProxiedPlayer): Party

    fun deleteParty(player: ProxiedPlayer)

    fun transferParty(oldLeaderPlayer: ProxiedPlayer, newLeaderPlayer: ProxiedPlayer): Party

    fun getParty(player: ProxiedPlayer): Party?

}

class DefaultPartyManager : PartyManager {

    override val parties: MutableList<Party> = mutableListOf()

    override fun createParty(player: ProxiedPlayer): Party {
        if(getParty(player) != null) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.alreadyInPartyMessage))
            return getParty(player)!!
        }
        val party = Party(player)
        parties += party
        return party
    }

    override fun deleteParty(player: ProxiedPlayer) {
        val party = getParty(player)
        if(party == null) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notInAPartyMessage))
            return
        }
        if(party.partyLeader != player) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notPartyLeaderMessage))
            return
        }

    }

    override fun transferParty(oldLeaderPlayer: ProxiedPlayer, newLeaderPlayer: ProxiedPlayer): Party {
        TODO("Not yet implemented")
    }

    override fun getParty(player: ProxiedPlayer): Party? {
        TODO("Not yet implemented")
    }
}
