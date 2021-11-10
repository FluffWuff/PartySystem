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

import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command

class PartyCommand(val partyManager: PartyManager, name: String?) : Command(name) {

    override fun execute(sender: CommandSender?, args: Array<out String>?) {
        if(sender !is ProxiedPlayer) return
        if(args!!.isEmpty())
            sender.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.partyHelpMessage))
        else if(args.size == 1) {
            when(args[0]) {
                "create" -> {
                    partyManager.createParty(sender)
                    return
                }
                "warp" -> {
                    partyWarp(sender)
                }
                "jump" -> {
                    partyJump(sender)
                }
                "leave" -> {

                }
                "disband" -> {

                }
                "list" -> {

                }
                else -> sender.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.partyHelpMessage))
            }
        } else if(args.size == 2) {
            when(args[0]) {
                "invite" -> {

                }
                "promote" -> {

                }
                "demote" -> {

                }
                "kick" -> {

                }
                "transfer" -> {

                }
            }
        }

    }

    private fun partyWarp(player: ProxiedPlayer) {
        if(!partyManager.isPlayerInParty(player)) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notInAPartyMessage))
            return
        }
        val party = partyManager.getParty(player)!!
        if(player != party.partyLeader) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notPartyLeaderMessage))
            return
        }
        party.warpToPartyLeader()
    }

    private fun partyJump(player: ProxiedPlayer) {
        if(!partyManager.isPlayerInParty(player)) {
            player.sendMessage(TextComponent(PartySystem.COMMON_STRINGS.prefix + PartySystem.COMMON_STRINGS.notInAPartyMessage))
            return
        }
        val party = partyManager.getParty(player)!!
        party.jumpToPartyLeader(player)
    }

}