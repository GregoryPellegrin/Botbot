/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Json;

import java.util.List;

public class Heroes
{
	private int playerId;
	private String name;
	private List <LeaderboardRanking> leaderboardRankings;

	private class LeaderboardRanking
	{
		private String gameMode;
		private int leagueId;
		private int leagueRank;
		private int currentMMR;
	}
	
	@Override
	public String toString ()
	{
		return "Id : " + this.playerId + " Nom : " + this.name;
	}
}