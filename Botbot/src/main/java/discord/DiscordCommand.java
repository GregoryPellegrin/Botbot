package discord;

import game.Heroes;
import game.Mythic;
import net.dv8tion.jda.core.entities.Message;

public class DiscordCommand
{
	public Message onHelp ()
	{
		return new DiscordMessage ().getHelp("Help");
	}

	public Message onWoWWeek ()
	{
		Mythic mythic = new Mythic ();
		
		return new DiscordMessage ().getWoWMythic(mythic);
	}

	public Message onWoWPlayer (String message)
	{
		/*if (message.equals("botbot wow"))
			return (new WoW ().getPlayerInfo("eu", "outland", "Eliaesteya"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return new DiscordMessage ().getHelp("Commande incorrecte");

			return (new WoW ().getPlayerInfo(args[4], args[3], args[2]));
		}*/

		return new DiscordMessage ().getHelp("Commande incorrecte");
	}

	public Message onHeroesPlayer (String message)
	{
		if (message.equals("botbot heroes"))
		{
			Heroes heroes = new Heroes ("UnicornMastr", "11956", 1);
			
			return new DiscordMessage ().getHeroes(heroes, "UnicornMastr");
		}
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

			Heroes heroes = new Heroes (args[2], args[3], regionId);
			
			return new DiscordMessage ().getHeroes(heroes, args[2]);
		}
	}
}