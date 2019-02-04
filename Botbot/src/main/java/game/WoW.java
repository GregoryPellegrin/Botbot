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
	private final static String LOGO_CHARACTER_1 = "http://render-";
	private final static String LOGO_CHARACTER_2 = ".worldofwarcraft.com/character/";

	private json.WoW wow;

	public WoW (String regionName, String serverName, String playerName)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://" + regionName + ".api.blizzard.com/wow/character/" + serverName + "/" + playerName + "?fields=statistics%2Cpvp%2Cmounts%2Citems%2Creputation&locale=fr_FR&access_token=" + key.ApiKey.BLIZZARD_TOKEN));

			this.wow = new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.WoW.class);
		} catch (IOException exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	public String getName ()
	{
		return this.wow.getName();
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

	public String getThumbnail (String regionName)
	{
		return LOGO_CHARACTER_1 + regionName + LOGO_CHARACTER_2 + this.wow.getThumbnail();
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