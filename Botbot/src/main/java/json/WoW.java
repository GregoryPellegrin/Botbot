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
	private Items items;
    private List <Reputation> reputation;
	private Statistics statistics;
	private Mounts mounts;
	private Pvp pvp;
	private Double totalHonorableKills;
	
	private class Items
	{
		private int averageItemLevel;
		private int averageItemLevelEquipped;
		private ItemEquiped head;
		private ItemEquiped neck;
		private ItemEquiped shoulder;
		private ItemEquiped back;
		private ItemEquiped chest;
		private ItemEquiped wrist;
		private ItemEquiped hands;
		private ItemEquiped waist;
		private ItemEquiped legs;
		private ItemEquiped feet;
		private ItemEquipedFinger finger1;
		private ItemEquipedFinger finger2;
		private ItemEquiped trinket1;
		private ItemEquiped trinket2;
		private ItemEquipedWeapon mainHand;
		
		private class ItemEquiped
		{
			private Double id;
			private String name;
			private String icon;
			private int quality;
			private int itemLevel;
			private TooltipParams tooltipParams;
			private List <Stats> stats;
			private int armor;
			private String context;
			private List <Integer> bonusLists;
			private int artifactId;
			private Double displayInfoId;
			private int artifactAppearanceId;
			private List <Integer> artifactTraits;
			private List <Integer> relics;
			private TooltipParams appearance;
			private TooltipParams azeriteItem;
			private TooltipParams azeriteEmpoweredItem;
			
			private class TooltipParams
			{
				private Double transmogItem;
				private int timewalkerLevel;
				private int azeritePower0;
				private int azeritePower1;
				private int azeritePower2;
				private int azeritePower3;
				private int azeritePowerLevel;
			}
			
			private class Stats
			{
				private int stat;
				private int amount;
			}
			
			private class Appearance
			{
				private Double itemId;
				private int itemAppearanceModId;
				private int transmogItemAppearanceModId;
			}
			
			private class AzeriteItem
			{
				private int azeriteLevel;
				private Double azeriteExperience;
				private Double azeriteExperienceRemaining;
			}
			
			private class AzeriteEmpoweredItem
			{
				private List <AzeritePowers> azeritePowers;
				
				private class AzeritePowers
				{
					private int id;
					private int tier;
					private Double spellId;
					private int bonusListId;
				}
			}
		}
		
		private class ItemEquipedFinger
		{
			private Double id;
			private String name;
			private String icon;
			private int quality;
			private int itemLevel;
			private TooltipParams tooltipParams;
			private List <Stats> stats;
			private int armor;
			private String context;
			private List <Integer> bonusLists;
			private int artifactId;
			private Double displayInfoId;
			private int artifactAppearanceId;
			private List <Integer> artifactTraits;
			private List <Integer> relics;
			private TooltipParams appearance;
			private TooltipParams azeriteItem;
			private TooltipParams azeriteEmpoweredItem;
			
			private class TooltipParams
			{
				private Double transmogItem;
				private int timewalkerLevel;
				private int azeritePower0;
				private int azeritePower1;
				private int azeritePower2;
				private int azeritePower3;
				private int azeritePowerLevel;
			}
			
			private class Stats
			{
				private int stat;
				private int amount;
			}
			
			private class Appearance
			{
				private Double enchantDisplayInfoId;
			}
			
			private class AzeriteItem
			{
				private int azeriteLevel;
				private Double azeriteExperience;
				private Double azeriteExperienceRemaining;
			}
			
			private class AzeriteEmpoweredItem
			{
				private List <AzeritePowers> azeritePowers;
				
				private class AzeritePowers
				{
					private int id;
					private int tier;
					private Double spellId;
					private int bonusListId;
				}
			}
		}
		
		private class ItemEquipedWeapon
		{
			private Double id;
			private String name;
			private String icon;
			private int quality;
			private int itemLevel;
			private TooltipParams tooltipParams;
			private List <Stats> stats;
			private int armor;
			private WeaponInfo weaponInfo;
			private String context;
			private List <Integer> bonusLists;
			private Double displayInfoId;
			private int artifactId;
			private int artifactAppearanceId;
			private List <Integer> artifactTraits;
			private List <Integer> relics;
			private TooltipParams appearance;
			private TooltipParams azeriteItem;
			private TooltipParams azeriteEmpoweredItem;
			
			private class TooltipParams
			{
				private Double transmogItem;
				private int timewalkerLevel;
				private int azeritePower0;
				private int azeritePower1;
				private int azeritePower2;
				private int azeritePower3;
				private int azeritePowerLevel;
			}
			
			private class Stats
			{
				private int stat;
				private int amount;
			}
			
			private class WeaponInfo
			{
				private Damage damage;
				private Double weaponSpeed;
				private Double dps;
				
				private class Damage
				{
					private int min;
					private int max;
					private Double exactMin;
					private Double exactMax;
				}
			}
			
			private class Appearance
			{
				private Double itemId;
				private int itemAppearanceModId;
				private int transmogItemAppearanceModId;
			}
			
			private class AzeriteItem
			{
				private int azeriteLevel;
				private Double azeriteExperience;
				private Double azeriteExperienceRemaining;
			}
			
			private class AzeriteEmpoweredItem
			{
				private List <AzeritePowers> azeritePowers;
				
				private class AzeritePowers
				{
					private int id;
					private int tier;
					private Double spellId;
					private int bonusListId;
				}
			}
		}
	}
	
	private class Reputation
	{
		private Double id;
		private String name;
		private int standing;
		private Double value;
		private Double max;
	}
	
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
	
	public int getLevel ()
	{
		return this.level;
	}
	
	public int getAverageItemLevel ()
	{
		return this.items.averageItemLevel;
	}
	
	public String getRealm ()
	{
		return this.realm;
	}
	
	public int getItemLevel ()
	{
		return this.level;
	}
	
	public String getAchievementPoints ()
	{
		return this.achievementPoints + " / 30735";
	}
	
	public String getMounts ()
	{
		return this.mounts.numCollected + " / " + (this.mounts.numCollected + this.mounts.numNotCollected);
	}
	
	public String getReputation ()
	{
		int exaltedReputations = 0;
		int totalReputations = this.reputation.size();
		
		for (int i = 0; i < this.reputation.size(); i++)
			if (this.reputation.get(i).standing == 7)
				exaltedReputations = exaltedReputations + 1;
			
		return exaltedReputations + " / " + totalReputations;
	}
	
	public String getRBG ()
	{
		return this.pvp.brackets.ARENA_BRACKET_RBG.rating + " - " + this.pvp.brackets.ARENA_BRACKET_RBG.seasonWon + " / " + this.pvp.brackets.ARENA_BRACKET_RBG.seasonPlayed;
	}
	
	public String get2v2 ()
	{
		return this.pvp.brackets.ARENA_BRACKET_2v2.rating + " - " + this.pvp.brackets.ARENA_BRACKET_2v2.seasonWon + " / " + this.pvp.brackets.ARENA_BRACKET_2v2.seasonPlayed;
	}
	
	public String get3v3 ()
	{
		return this.pvp.brackets.ARENA_BRACKET_3v3.rating + " - " + this.pvp.brackets.ARENA_BRACKET_3v3.seasonWon + " / " + this.pvp.brackets.ARENA_BRACKET_3v3.seasonPlayed;
	}
	
	public int getHonorableKills ()
	{
		return this.totalHonorableKills.intValue();
	}
	
	public String getDeath ()
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
}