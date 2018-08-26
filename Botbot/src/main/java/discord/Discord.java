package discord;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

@WebServlet (name = "Discord", urlPatterns = {""})
public class Discord extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try
		{
			JDA jda = (JDA) new JDABuilder(AccountType.BOT).setToken(key.ApiKey.DISCORD_TOKEN).buildAsync();

			jda.addEventListener(new Listener());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}