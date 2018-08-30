package json;

import java.util.List;

public class Heroes
{
	private int PlayerID;
	private String Name;
	private List <LeaderboardRanking> LeaderboardRankings;

	private class LeaderboardRanking
	{
		private String GameMode;
		private int LeagueID;
		private int LeagueRank;
		private int CurrentMMR;
	}
	
	public String getQuickMatchMMR ()
	{
		if (this.LeaderboardRankings.size() != 4)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		for (int i = 0; i < this.LeaderboardRankings.size(); i++)
			if (this.LeaderboardRankings.get(i).GameMode.equals("QuickMatch"))
				return String.valueOf(this.LeaderboardRankings.get(i).CurrentMMR);
				
		return "Erreur pour obtenir les statistiques, le Json a changé";
	}
	
	public String getHeroLeagueMMR ()
	{
		if (this.LeaderboardRankings.size() != 4)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		for (int i = 0; i < this.LeaderboardRankings.size(); i++)
			if (this.LeaderboardRankings.get(i).GameMode.equals("HeroLeague"))
				return String.valueOf(this.LeaderboardRankings.get(i).CurrentMMR);
				
		return "Erreur pour obtenir les statistiques, le Json a changé";
	}
	
	public String getTeamLeagueMMR ()
	{
		if (this.LeaderboardRankings.size() != 4)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		for (int i = 0; i < this.LeaderboardRankings.size(); i++)
			if (this.LeaderboardRankings.get(i).GameMode.equals("TeamLeague"))
				return String.valueOf(this.LeaderboardRankings.get(i).CurrentMMR);
				
		return "Erreur pour obtenir les statistiques, le Json a changé";
	}
	
	public String getUnrankedDraftMMR ()
	{
		if (this.LeaderboardRankings.size() != 4)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		for (int i = 0; i < this.LeaderboardRankings.size(); i++)
			if (this.LeaderboardRankings.get(i).GameMode.equals("UnrankedDraft"))
				return String.valueOf(this.LeaderboardRankings.get(i).CurrentMMR);
				
		return "Erreur pour obtenir les statistiques, le Json a changé";
	}
}