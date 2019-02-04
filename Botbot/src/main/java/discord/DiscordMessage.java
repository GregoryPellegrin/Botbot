package discord;

import java.awt.Color;
import game.Heroes;
import game.WoW;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

public class DiscordMessage
{
	private final static String LOGO_HELP = "https://cdn2.iconfinder.com/data/icons/picons-essentials/71/help-512.png";
	private final static String LOGO_HEROES = "https://eu.battle.net/forums/static/images/social-thumbs/heroes.png";
	private final static String LOGO_WOW = "https://eu.battle.net/forums/static/images/social-thumbs/wow.png";

	public Message getHelp (String helpTitle)
	{
		//@formatter:off
		MessageBuilder messageBuilder = new MessageBuilder().append("").setEmbed(new EmbedBuilder()
			.setColor(Color.WHITE)
			.setAuthor(helpTitle, null, LOGO_HELP)
			.setTitle("Voici les commandes disponibles")
			.addField("Obtenir les informations d'un joueur Heroes of the Storm",
					  "botbot heroes joueur id région\n"
					+ "id : le numéro à côté du battletag\n"
					+ "région : eu, us",
			false)
			.addField("Obtenir les informations d'un personnage World of Warcraft",
					  "botbot wow joueur serveur région\n"
					+ "serveur : outland, archimonde, etc...\n"
					+ "région  : eu, us",
			 false)
			.build());
		//@formatter:on

		return messageBuilder.build();
	}

	public Message getHeroes (Heroes heroes, String player)
	{
		//@formatter:off
		MessageBuilder messageBuilder = new MessageBuilder().append("").setEmbed(new EmbedBuilder()
			.setColor(Color.BLUE)
			.setAuthor("Heroes of the Storm - Informations du joueur", null, LOGO_HEROES)
			.setTitle(player).addField("Partie Rapide", heroes.getQuickMatchMMR(), false)
			.addField("Ligue Héroïque", heroes.getHeroLeagueMMR(), false)
			.addField("Ligue Héroïque par équipe", heroes.getTeamLeagueMMR(), false)
			.addField("Partie Non Classé", heroes.getUnrankedDraftMMR(), false)
			.build());
		//@formatter:on

		return messageBuilder.build();
	}

	public Message getWoW (WoW wow, String character)
	{
		//@formatter:off
		MessageBuilder messageBuilder = new MessageBuilder().append("").setEmbed(new EmbedBuilder()
			.setColor(Color.ORANGE).setAuthor("World of Warcraft - Informations du personnage", null, LOGO_WOW)
			.setTitle(wow.getName() + " (" + wow.getAverageItemLevel() + " - " + wow.getLevel() + ")" + " - " + wow.getRealm())
			.addField("Hauts faits", wow.getAchievementPoints(), false)
			.addField("Montures", wow.getMounts(), false)
			.addField("Reputations", wow.getReputation(), false)
			.addField("2v2", wow.get2v2(), false)
			.addField("3v3", wow.get3v3(), false)
			.addField("RBG", wow.getRBG(), false)
			.build());
		//@formatter:on

		return messageBuilder.build();
	}
}