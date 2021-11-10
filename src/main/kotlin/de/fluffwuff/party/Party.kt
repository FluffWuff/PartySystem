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

import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer

data class Party(var partyLeader: ProxiedPlayer, val partyMembers: MutableMap<ProxiedPlayer, PartyRank> = mutableMapOf(), val isChatEnabled: Boolean = true, val isJumpEnabled: Boolean = true) {

    fun warpToPartyLeader() {
        partyMembers.keys.forEach {
            if(it != partyLeader) it.connect(partyLeader.server!!.info)
            it.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.warpMessage))
        }
    }

    fun jumpToPartyLeader(player: ProxiedPlayer) {
        if(player == partyLeader) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notAvailableAsPartyLeaderMessage))
            return
        }
        if(!isJumpEnabled) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.jumpDisabledMessage))
            return
        }
        player.connect(partyLeader.server!!.info)
        player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.jumpMessage))
    }

    fun chatParty(player: ProxiedPlayer, message: String) {
        if(!isChatEnabled) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.chatDisabledMessage))
            return
        }
        partyMembers.keys.forEach {
            //TODO write party chat message structure
        }
    }

}

enum class PartyRank {
    LEADER, MOD, MEMBER
}