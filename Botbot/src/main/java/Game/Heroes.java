/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Game;

import Json.Test;
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
			String json = EntityUtils.toString(httpResponse.getEntity());
			Json.Heroes heroes = new Gson ().fromJson(json, Json.Heroes.class);
			Gson gson = new Gson ();
			Test test = new Test ();
			String userJson = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";  
			test = gson.fromJson(userJson, Test.class);
			
			System.out.println(test.age);
			System.out.println(test.name);
			System.out.println(json);

			return heroes.toString();
		}
		catch (IOException exception)
		{
			return exception.getMessage();
		}
	}
}