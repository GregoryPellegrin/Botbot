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
	
	private String getInfo (LeaderboardRanking leaderboardRankings)
	{
		return leaderboardRankings.GameMode + " - MMR : " + leaderboardRankings.CurrentMMR + " - Ligue : " + leaderboardRankings.LeagueID + " - Rang : " + leaderboardRankings.LeagueRank;
	}
	
	@Override
	public String toString ()
	{
		if (this.LeaderboardRankings.size() != 4)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		String quickMatch = "";
		String heroLeague = "";
		String teamLeague = "";
		String unrankedDraft = "";
		
		for (int i = 0; i < this.LeaderboardRankings.size(); i++)
		{
			if (this.LeaderboardRankings.get(i).GameMode.equals("QuickMatch"))
				quickMatch = getInfo(this.LeaderboardRankings.get(i));
			else if (this.LeaderboardRankings.get(i).GameMode.equals("HeroLeague"))
				heroLeague = getInfo(this.LeaderboardRankings.get(i));
			else if (this.LeaderboardRankings.get(i).GameMode.equals("TeamLeague"))
				teamLeague = getInfo(this.LeaderboardRankings.get(i));
			else if (this.LeaderboardRankings.get(i).GameMode.equals("UnrankedDraft"))
				unrankedDraft = getInfo(this.LeaderboardRankings.get(i));
		}
		
		return "Nom : " + this.Name + "\n" +
			   quickMatch + "\n" +
			   heroLeague + "\n" +
			   teamLeague + "\n" +
			   unrankedDraft;
	}
}