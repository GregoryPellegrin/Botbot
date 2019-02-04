package discord;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Discord extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try
		{
			JDA jda = new JDABuilder(AccountType.BOT).setToken(key.ApiKey.DISCORD_TOKEN).buildAsync();

			jda.addEventListener(new DiscordListener());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}