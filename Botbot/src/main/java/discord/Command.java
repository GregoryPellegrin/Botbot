package discord;

import java.awt.Color;
import game.Heroes;
import game.WoW;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

public class Command
{
	public Message onHelp ()
	{
		return onHelp("Help");
	}

	public String onWoWWeek ()
	{
		return (new WoW ().getKeystoneInfo());
	}

	public Message onWoWPlayer (String message)
	{
		if (message.equals("botbot wow"))
			return (new WoW ().getPlayerInfo("eu", "outland", "Eliaesteya"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return onHelp("Commande incorrecte");

			return (new WoW ().getPlayerInfo(args[4], args[3], args[2]));
		}
	}

	public Message onHeroesPlayer (String message)
	{
		if (message.equals("botbot heroes"))
			return (new Heroes ().getPlayerInfo("us", "UnicornMastr", "11956"));
		else
		{
			String [] args = message.split(" ");

			if (args.length != 5)
				return onHelp("Commande incorrecte");

			return (new Heroes ().getPlayerInfo(args[4], args[2], args[3]));
		}
	}
	
	private Message onHelp (String authorMessage)
	{
		MessageBuilder messageBuilder = new MessageBuilder ().append("").setEmbed(new EmbedBuilder ()
		.setColor(Color.WHITE)
		.setAuthor("Botbot - "+ authorMessage, null, "https://cdn2.iconfinder.com/data/icons/picons-essentials/71/help-512.png")
		.setTitle("Voici les commandes disponibles")
		.addField("Obtenir les affixes des donjons mythiques + de la semaine", 
		          "botbot wow week",
		          false)
		.addField("Obtenir les informations d'un personnage World of Warcraft", 
                  "botbot wow joueur serveur région",
                  false)
		.addField("Obtenir les informations d'un joueur Heroes of the Storm", 
                  "botbot heroes joueur id région",
                  false)
		.build());
		
		return messageBuilder.build();
	}
}