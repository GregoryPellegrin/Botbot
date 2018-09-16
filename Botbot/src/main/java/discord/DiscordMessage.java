package discord;

import java.awt.Color;
import game.Heroes;
import game.Mythic;
import game.WoW;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

public class DiscordMessage
{
	private final static String LOGO_HELP = "https://cdn2.iconfinder.com/data/icons/picons-essentials/71/help-512.png";
	private final static String LOGO_HEROES = "https://eu.battle.net/forums/static/images/social-thumbs/heroes.png";
	private final static String LOGO_WOW_MYTHIC = "https://media.forgecdn.net/avatars/95/440/636277257230454950.png";
	private final static String LOGO_WOW = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqj4iw1CLGh9IUDTUfQvJ4ROLkmqpM-ApwOpBQ6-CQiKopr9Or";
	
	public Message getHelp (String helpTitle)
	{
		MessageBuilder messageBuilder = new MessageBuilder ().append("").setEmbed(new EmbedBuilder ()
		.setColor(Color.WHITE)
		.setAuthor(helpTitle, null, LOGO_HELP)
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
	
	public Message getHeroes (Heroes heroes, String player)
	{
		MessageBuilder messageBuilder = new MessageBuilder ().append("").setEmbed(new EmbedBuilder ()
		.setColor(Color.BLUE)
		.setAuthor("Heroes of the Storm - Informations du joueur", null, LOGO_HEROES)
		.setTitle(player)
		.addField("Partie Rapide",
		          heroes.getQuickMatchMMR(),
		          false)
		.addField("Ligue Héroïque",
		          heroes.getHeroLeagueMMR(),
                  false)
		.addField("Ligue Héroïque par équipe",
		          heroes.getTeamLeagueMMR(),
                  false)
		.addField("Partie Non Classé",
		          heroes.getUnrankedDraftMMR(),
                  false)
		.build());
		
		return messageBuilder.build();
	}
	
	public Message getWoWMythic (Mythic mythic)
	{
		MessageBuilder messageBuilder = new MessageBuilder ().append("").setEmbed(new EmbedBuilder ()
		.setColor(Color.MAGENTA)
		.setAuthor("World of Warcraft - Affixes Donjons Mythiques +", null, LOGO_WOW_MYTHIC)
		.setTitle("Affixes de la semaine")
		.addField(mythic.getAffixeTitre1(), 
			      mythic.getAffixeDescription1(),
		          false)
		.addField(mythic.getAffixeTitre2(), 
	      		  mythic.getAffixeDescription2(),
	      		  false)
		.addField(mythic.getAffixeTitre3(), 
	      		  mythic.getAffixeDescription3(),
	      		  false)
		.build());
		
		return messageBuilder.build();
	}
	
	public Message getWoW (WoW wow, String character)
	{
		MessageBuilder messageBuilder = new MessageBuilder ().append("").setEmbed(new EmbedBuilder ()
		.setColor(Color.ORANGE)
		.setAuthor("World of Warcraft - Informations du personnage", null, LOGO_WOW)
		.setTitle(character + " (" + wow.getAverageItemLevel() + " - " + wow.getLevel() + ")" + " - " + wow.getRealm())
		.addField("Hauts faits",
				  wow.getAchievementPoints(),
		          false)
		.addField("Montures",
		  		  wow.getMounts(),
		  		  false)
		.addField("Reputations",
		  		  wow.getReputation(),
		  		  false)
		.addField("Champs de bataille",
		  		  wow.getRBG(),
		  		  false)
		.addField("2v2",
		  		  wow.get2v2(),
		  		  false)
		.addField("3v3",
		  		  wow.get3v3(),
		  		  false)
		.addField("Victoires honorables",
		  		  wow.getHonorableKills(),
		  		  false)
		.addField("Morts",
		  		  wow.getDeath(),
		  		  false)
		.build());
		
		return messageBuilder.build();
	}
}