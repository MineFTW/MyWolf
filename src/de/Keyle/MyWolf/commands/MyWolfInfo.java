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

package de.Keyle.MyWolf.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyWolfInfo implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
    		Player player = (Player) sender;
    		player.sendMessage("MyWolf - Help - - - - - - - - - - - - - - - - -");
			player.sendMessage("Set wolf name:            /wolfname <newwolfname>");
			player.sendMessage("Release your wolf:    /wolfrelease <wolfname>");
			player.sendMessage("Stop wolf attacking:  /wolfstop  (alias: /ws)");
			player.sendMessage("Call your wolf:	          /wolfcall  (alias: /wc)");
			//player.sendMessage("Compass tagets wolf:	          /wolf compass [stop]");
        }
		return true;
    }
}
