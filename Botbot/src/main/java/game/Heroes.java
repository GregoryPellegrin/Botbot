package game;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Heroes
{
	public String getPlayerInfo (String regionName, String playerName, String playerId)
	{
		int idRegion;

		if (regionName.equals("us"))
			idRegion = 1;
		else if (regionName.equals("eu"))
			idRegion = 2;
		else if (regionName.equals("kr"))
			idRegion = 3;
		else if (regionName.equals("cn"))
			idRegion = 5;
		else
			return "Les régions possibles sont us (Amérique), eu (Europe), kr (Corée), cn (Chine)";

		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://api.hotslogs.com/Public/Players/" + idRegion + "/" + playerName + "_" + playerId));
			json.Heroes heroes = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.Heroes.class);
			
			return heroes.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
}