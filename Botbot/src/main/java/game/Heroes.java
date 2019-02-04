package game;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class Heroes
{
	private json.Heroes heroes;

	public Heroes (String playerName, String playerId, int regionId)
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://api.hotslogs.com/Public/Players/" + regionId + "/" + playerName + "_" + playerId));
			this.heroes = new Gson().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.Heroes.class);
		} catch (IOException exception)
		{
			System.out.println(exception.getMessage());
		}
	}

	public String getQuickMatchMMR ()
	{
		return this.heroes.getMMR("QuickMatch");
	}

	public String getHeroLeagueMMR ()
	{
		return this.heroes.getMMR("HeroLeague");
	}

	public String getTeamLeagueMMR ()
	{
		return this.heroes.getMMR("TeamLeague");
	}

	public String getUnrankedDraftMMR ()
	{
		return this.heroes.getMMR("UnrankedDraft");
	}
}