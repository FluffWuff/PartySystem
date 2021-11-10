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

import net.md_5.bungee.api.event.ServerSwitchEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler

class PartyListener(private val partyManager: PartyManager) : Listener {

    @EventHandler
    fun handleServerSwitch(event: ServerSwitchEvent) {
        val party = partyManager.getParty(event.player) ?: return
        if(event.player != party.partyLeader) return
        if(PartySystem.COMMON_STRINGS.excludedServerList.contains(event.player.server.info.name)) return
        party.warpToPartyLeader()
    }

}