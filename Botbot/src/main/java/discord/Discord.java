/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Discord;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Discord
{
	public static void main (String[] args)
	{
		try
		{
			JDA jda = (JDA) new JDABuilder(AccountType.BOT).setToken(ApiKey.ApiKey.DISCORD_TOKEN).buildAsync();
			
			jda.addEventListener(new Listener ());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}