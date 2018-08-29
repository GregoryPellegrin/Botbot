package discord;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class Listener implements EventListener
{
	Command command;
	
	public Listener ()
	{
		this.command = new Command ();
	}

	@Override
	public void onEvent (Event event)
	{
		if (event instanceof MessageReceivedEvent)
			onMessage((MessageReceivedEvent) event);
	}
	
	private void onMessage (MessageReceivedEvent event)
	{
		if (! event.getAuthor().equals(event.getJDA().getSelfUser()))
			if (event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE))
			{
				String messageIn = event.getMessage().getContentDisplay();
				MessageChannel messageOut = event.getMessage().getChannel();
				TextChannel messageOutOld = event.getTextChannel();
				
				if (messageIn.equals("botbot wow week"))
					messageOutOld.sendMessage(command.onWoWWeek()).complete();
				else if (messageIn.contains("botbot wow"))
					messageOutOld.sendMessage(command.onWoWPlayer(messageIn)).complete();
				else if (messageIn.contains("botbot heroes"))
					messageOutOld.sendMessage(command.onHeroesPlayer(messageIn)).complete();
				else if (messageIn.contains("botbot"))
					messageOut.sendMessage(command.onHelp()).complete();
			}
	}
}