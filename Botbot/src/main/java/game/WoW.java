package game;

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
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://eu.api.battle.net/data/wow/mythic-challenge-mode/?namespace=dynamic-eu&locale=fr_FR&access_token=" + key.ApiKey.BLIZZARD_TOKEN));
			json.Mythic mythic = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.Mythic.class);

			return mythic.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
	
	public String getPlayerInfo (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/wow/character/" + serverName + "/" + playerName + "?fields=statistics%2Cpvp%2Cmounts&locale=fr_FR&apikey=" + key.ApiKey.BLIZZARD_API_KEY));
			json.WoW wow = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.WoW.class);

			return wow.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
	
	public String getAvatar (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/wow/character/" + serverName + "/" + playerName + "?locale=fr_FR&apikey=" + key.ApiKey.BLIZZARD_API_KEY));
			json.WoW wow = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.WoW.class);

			return "http://render-" + regionName + wow.getAvatar();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
}