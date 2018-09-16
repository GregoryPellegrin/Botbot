package game;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class Mythic
{
	private json.Mythic mythic;
	
	public Mythic ()
	{
		try
		{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpResponse httpResponse = httpClient.execute(new HttpGet("https://eu.api.battle.net/data/wow/mythic-challenge-mode/?namespace=dynamic-eu&locale=fr_FR&access_token=" + key.ApiKey.BLIZZARD_TOKEN));
			this.mythic = new Gson ().fromJson(EntityUtils.toString(httpResponse.getEntity()).replaceAll("null", "0"), json.Mythic.class);
		}
		catch (IOException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	public String getAffixeTitre1 ()
	{
		return this.mythic.getAffixeTitre(4);
	}
	
	public String getAffixeDescription1 ()
	{
		return this.mythic.getAffixeDescription(4);
	}
	
	public String getAffixeTitre2 ()
	{
		return this.mythic.getAffixeTitre(7);
	}
	
	public String getAffixeDescription2 ()
	{
		return this.mythic.getAffixeDescription(7);
	}
	
	public String getAffixeTitre3 ()
	{
		return this.mythic.getAffixeTitre(10);
	}
	
	public String getAffixeDescription3 ()
	{
		return this.mythic.getAffixeDescription(10);
	}
}
