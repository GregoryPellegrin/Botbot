package json;

import java.util.List;

public class WoW
{
	private Double lastModified;
    private String name;
    private String realm;
    private String battlegroup;
    private int classs;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;
    private String thumbnail;
    private String calcClass;
    private int faction;
	private Statistics statistics;
	private Mounts mounts;
	private Pvp pvp;
	private Double totalHonorableKills;
	
	private class Statistics
	{
		private int id;
		private String name;
		private List <SubCategories> subCategories;
		
		private class SubCategories
		{
			private int id;
			private String name;
			private List <Statistic> statistics;
			private List <SubCategorie> subCategories;

			private class Statistic
			{
				private int id;
				private String name;
				private Double quantity;
				private Double lastUpdated;
				private boolean money;
			}
			
			private class SubCategorie
			{
				private int id;
				private String name;
				private List <Statistic> statistics;
			}
		}
	}
	
	private class Mounts
	{
		private int numCollected;
		private int numNotCollected;
		private List <Collected> collected;
		
		private class Collected
		{
			private String name;
            private double spellId;
            private double creatureId;
            private double itemId;
            private int qualityId;
            private String icon;
            private boolean isGround;
            private boolean isFlying;
            private boolean isAquatic;
            private boolean isJumping;
		}
	}
	
	private class Pvp
	{
		private Brackets brackets;
		
		private class Brackets
		{
			private ARENA_BRACKET ARENA_BRACKET_2v2;
			private ARENA_BRACKET ARENA_BRACKET_3v3;
			private ARENA_BRACKET ARENA_BRACKET_RBG;
			private ARENA_BRACKET ARENA_BRACKET_2v2_SKIRMISH;
			private ARENA_BRACKET UNKNOWN;
			
			private class ARENA_BRACKET
			{
				private String slug;
                private int rating;
                private int weeklyPlayed;
                private int weeklyWon;
                private int weeklyLost;
                private int seasonPlayed;
                private int seasonWon;
                private int seasonLost;
			}
		}
	}
	
	private String getReputation ()
	{
		for (int i = 0; i < this.statistics.subCategories.get(0).subCategories.size(); i++)
			if (this.statistics.subCategories.get(0).subCategories.get(i).id == 147)
				for (int j = 0; j < this.statistics.subCategories.get(0).subCategories.get(i).statistics.size(); j++)
					if (this.statistics.subCategories.get(0).subCategories.get(i).statistics.get(j).id == 377)
						return String.valueOf(this.statistics.subCategories.get(0).subCategories.get(i).statistics.get(j).quantity.intValue());
		
		return "Erreur pour obtenir les réputations, le json a changé";
	}
	
	private String getDeath ()
	{
		for (int i = 0; i < this.statistics.subCategories.size(); i++)
			if (this.statistics.subCategories.get(i).id == 122)
				return String.valueOf(this.statistics.subCategories.get(i).statistics.get(0).quantity.intValue());
		
		return "Erreur pour obtenir les morts, le json a changé";
	}
	
	public String getAvatar ()
	{
		return ".worldofwarcraft.com/character/" + this.thumbnail;
	}
	
	@Override
	public String toString ()
	{
		return "Nom : " + this.name + "\n" +
			   "Royaume : " + this.realm + "\n" +
			   "Niveau : " + this.level + "\n" +
			   "Hauts faits : " + this.achievementPoints + "\n" +
			   "Victoires honorables : " + this.totalHonorableKills.intValue() + "\n" +
			   "Montures : " + this.mounts.numCollected + " / " + this.mounts.numNotCollected + "\n" +
			   "Réputations exaltées : " + this.getReputation() + "\n" +
			   "Nombre de morts : " + this.getDeath() + "\n" +
			   "RBG - Classement : " + this.pvp.brackets.ARENA_BRACKET_RBG.rating + " - Victoires : " + this.pvp.brackets.ARENA_BRACKET_RBG.seasonWon + " - Total : " + this.pvp.brackets.ARENA_BRACKET_RBG.seasonPlayed + "\n" +
			   "2v2 - Classement : " + this.pvp.brackets.ARENA_BRACKET_2v2.rating + " - Victoires : " + this.pvp.brackets.ARENA_BRACKET_2v2.seasonWon + " - Total : " + this.pvp.brackets.ARENA_BRACKET_2v2.seasonPlayed + "\n" +
			   "3v3 - Classement : " + this.pvp.brackets.ARENA_BRACKET_3v3.rating + " - Victoires : " + this.pvp.brackets.ARENA_BRACKET_3v3.seasonWon + " - Total : " + this.pvp.brackets.ARENA_BRACKET_3v3.seasonPlayed + "\n";
	}
}