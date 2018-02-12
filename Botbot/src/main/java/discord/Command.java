/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Discord;

import Game.Heroes;
import Game.Starcraft;
import Game.WoW;

public class Command
{
	public String onHelp ()
	{
		return "Bientot je t'aiderais";
	}

	public String onWoWWeek ()
	{
		return (new WoW().getKeystoneInfo());
	}

	public String onWoWPlayer (String message)
	{
		if (message.equals("botbot wow"))
			return (new WoW ().getPlayerInfo("eu", "outland", "Eliaesteya"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return "La requête doit être du format suivant 'botbot wow joueur serveur région'";

			return (new WoW ().getPlayerInfo(args[4], args[3], args[2]));
		}
	}

	public String onHeroesPlayer (String message)
	{
		if (message.equals("botbot heroes"))
			return (new Heroes ().getPlayerInfo("us", "UnicornMastr", "11956"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return "La requête doit être du format suivant 'botbot heroes joueur id région'";

			return (new Heroes ().getPlayerInfo(args[4], args[2], args[3]));
		}
	}

	public String onStarcraftPlayer (String message)
	{
		if (message.equals("botbot sc2"))
			return (new Starcraft ().getPlayerInfo("us", "4647037", "SushiGreGs"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return "La requête doit être du format suivant 'botbot sc2 joueur id région'";

			return (new Starcraft ().getPlayerInfo(args[4], args[3], args[2]));
		}
	}
}