/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Json;

import java.util.List;

public class Starcraft
{
	private Double id;
    private int realm;
    private String displayName;
    private String clanName;
    private String clanTag;
    private String profilePath;
    private Portrait portrait;
	private Career career;
	private SwarmLevels swarmLevels;
	private Campaign campaign;
	private Season season;
	private Rewards rewards;
	private Achievements achievements;
	
	private class Portrait
	{
        private int x;
        private int y;
        private int w;
        private int h;
        private int offset;
        private String url;
    }
	
    private class Career
	{
        private String primaryRace;
        private int terranWins;
        private int protossWins;
        private int zergWins;
        private String highest1v1Rank;
        private String highestTeamRank;
        private int seasonTotalGames;
        private int careerTotalGames;
    }
	
    private class SwarmLevels
	{
        private int level;
		private Terran terran;
		private Zerg zerg;
		private Protoss protoss;
		
        private class Terran
		{
			private int level;
			private Double totalLevelXP;
            private Double currentLevelXP;
        }
		
        private class Zerg
		{
			private int level;
			private Double totalLevelXP;
            private Double currentLevelXP;
        }
		
        private class Protoss
		{
			private int level;
			private Double totalLevelXP;
            private Double currentLevelXP;
        }
    }
	
    private class Campaign
	{
        private String wol;
        private String hots;
    }
	
    private class Season
	{
        private int seasonId;
        private int seasonNumber;
        private int seasonYear;
        private int totalGamesThisSeason;
    }
	
    private class Rewards
	{
		private List <Double> selected;
		private List <Double> earned;
	}
	
	private class Achievements
	{
		private Points points;
		private Achievement achievements;
		
		private class Points
		{
			private Double totalPoints;
			private CategoryPoints categoryPoints;
			
			private class CategoryPoints
			{
				private int p4330138;
				private int p4386911;
				private int p4364473;
				private int p4325379;
				private int p4325410;
				private int p4325377;
			}
		}
		
		private class Achievement
		{
			private Double achievementId;
			private Double completionDate;
		}
	}
	
	@Override
	public String toString ()
	{
		return "Nom : " + this.displayName;
	}
}