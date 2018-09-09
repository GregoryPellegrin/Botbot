package discord;

import game.Heroes;
import game.Mythic;
import game.WoW;
import net.dv8tion.jda.core.entities.Message;

public class DiscordCommand
{
	public Message onHelp ()
	{
		return new DiscordMessage ().getHelp("Help");
	}

	public Message onWoWWeek ()
	{
		return new DiscordMessage ().getWoWMythic(new Mythic ());
	}

	public Message onWoWPlayer (String message)
	{
		if (message.equals("botbot wow"))
			return new DiscordMessage ().getWoW(new WoW ("eu", "outland", "Eliaesteya"), "Eliaesteya");
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return new DiscordMessage ().getHelp("Commande incorrecte");

			return new DiscordMessage ().getWoW(new WoW (args[4], args[3], args[2]), args[2]);
		}
	}

	public Message onHeroesPlayer (String message)
	{
		if (message.equals("botbot heroes"))
			return new DiscordMessage ().getHeroes(new Heroes ("UnicornMastr", "11956", 1), "UnicornMastr");
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return new DiscordMessage ().getHelp("Commande incorrecte");
			
			int regionId = 1;

			if (args[4].equals("us"))
				regionId = 1;
			else if (args[4].equals("eu"))
				regionId = 2;
			else if (args[4].equals("kr"))
				regionId = 3;
			else if (args[4].equals("cn"))
				regionId = 5;
			else
				return new DiscordMessage ().getHelp("Commande incorrecte");

			return new DiscordMessage ().getHeroes(new Heroes (args[2], args[3], regionId), args[2]);
		}
	}
}