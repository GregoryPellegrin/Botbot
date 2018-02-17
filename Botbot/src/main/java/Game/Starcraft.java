/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Game;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Starcraft
{
	/*
	 * career(terranWins,protossWins,zergWins,highest1v1Rank)
	 * swarmLevels(level,terran(level),zerg(level),protoss(level))
	 * campaign(wol,hots)
	 * achievements(points(totalPoints))
	 */
	public String getPlayerInfo (String regionName, String profilId, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/sc2/profile/" + profilId + "/1/" + playerName + "/?locale=en_US&apikey=tvx58hgpjg753jymgamk4q7pysrbrs5c"));
			Json.Starcraft starcraft = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), Json.Starcraft.class);
			
			return starcraft.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
}