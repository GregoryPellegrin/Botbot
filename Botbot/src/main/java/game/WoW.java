package game;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class WoW
{
	private json.WoW wow;

	public WoW (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/wow/character/" + serverName + "/" + playerName + "?fields=statistics%2Cpvp%2Cmounts%2Citems%2Creputation&locale=fr_FR&apikey=" + key.ApiKey.BLIZZARD_API_KEY));

			this.wow = new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.WoW.class);
		} catch (IOException exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	public String getAvatar (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.battle.net/wow/character/" + serverName + "/" + playerName + "?locale=fr_FR&apikey=" + key.ApiKey.BLIZZARD_API_KEY));
			json.WoW wow = new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.WoW.class);

			return "http://render-" + regionName + wow.getAvatar();
		} catch (IOException exception)
		{
			return exception.getMessage();
		}
	}

	public String getLevel ()
	{
		return String.valueOf(this.wow.getLevel());
	}

	public String getAverageItemLevel ()
	{
		return String.valueOf(this.wow.getAverageItemLevel());
	}

	public String getRealm ()
	{
		return this.wow.getRealm();
	}

	public String getAchievementPoints ()
	{
		return this.wow.getAchievementPoints();
	}

	public String getMounts ()
	{
		return this.wow.getMounts();
	}

	public String getReputation ()
	{
		return this.wow.getReputation();
	}

	public String getRBG ()
	{
		return this.wow.getRBG();
	}

	public String get2v2 ()
	{
		return this.wow.get2v2();
	}

	public String get3v3 ()
	{
		return this.wow.get3v3();
	}
}