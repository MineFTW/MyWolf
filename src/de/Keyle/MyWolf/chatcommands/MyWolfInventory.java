/*
* Copyright (C) 2011 Keyle
*
* This file is part of MyWolf.
*
* MyWolf is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* MyWolf is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with MyWolf. If not, see <http://www.gnu.org/licenses/>.
*/

package de.Keyle.MyWolf.chatcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Keyle.MyWolf.ConfigBuffer;
import de.Keyle.MyWolf.util.MyWolfLanguage;
import de.Keyle.MyWolf.util.MyWolfUtil;

public class MyWolfInventory implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (ConfigBuffer.mWolves.containsKey(player.getName()))
			{
				if (ConfigBuffer.mWolves.get(player.getName()).isDead == true || ConfigBuffer.mWolves.get(player.getName()).isThere == false)
				{
					sender.sendMessage(MyWolfUtil.SetColors(MyWolfLanguage.getString("Msg_CallFirst")));
					return true;
				}
				if (MyWolfUtil.hasSkill(ConfigBuffer.mWolves.get(player.getName()).Abilities, "InventorySmall") || MyWolfUtil.hasSkill(ConfigBuffer.mWolves.get(player.getName()).Abilities, "InventoryLarge"))
				{
					ConfigBuffer.RegisteredSkills.get("Inventory").run(ConfigBuffer.mWolves.get(player.getName()), null);
				}
				else
				{
					sender.sendMessage("Your wolf don't have an Inventory");
				}
				return true;
			}
			else
			{
				sender.sendMessage(MyWolfUtil.SetColors(MyWolfLanguage.getString("Msg_DontHaveWolf")));
			}
		}
		return true;
	}
}