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

public class WoW
{
	public String getKeystoneInfo ()
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://eu.api.battle.net/data/wow/mythic-challenge-mode/?namespace=dynamic-eu&locale=fr_FR&access_token=" + ApiKey.ApiKey.BLIZZARD_TOKEN));
			Json.Mythic mythic = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), Json.Mythic.class);

			return mythic.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}

	/*
	 * name,realm,level,achievementPoints,totalHonorableKills,
	 * statistics(standing=7),
	 * mounts(numCollected),
	 * pvp(brackets(ARENA_BRACKET_RBG(rating,seasonWon,seasonLost),
	 *              ARENA_BRACKET_2v2(rating,seasonWon,seasonLost),
	 *              ARENA_BRACKET_3v3(rating,seasonWon,seasonLost))),
	 */
	public String getPlayerInfo (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/wow/character/" + serverName + "/" + playerName + "?fields=reputation%2Cpvp%2Cmounts&locale=fr_FR&apikey=" + ApiKey.ApiKey.BLIZZARD_API_KEY));
			//Json.WoW wow = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()), Json.WoW.class);

			return EntityUtils.toString(httpResponse.getEntity());
			//return wow.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
}