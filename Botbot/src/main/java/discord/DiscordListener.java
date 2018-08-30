package discord;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class DiscordListener implements EventListener
{
	DiscordCommand command;
	
	public DiscordListener ()
	{
		this.command = new DiscordCommand ();
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
					messageOut.sendMessage(command.onWoWWeek()).complete();
				else if (messageIn.contains("botbot wow"))
					messageOutOld.sendMessage(command.onWoWPlayer(messageIn)).complete();
				else if (messageIn.contains("botbot heroes"))
					messageOut.sendMessage(command.onHeroesPlayer(messageIn)).complete();
				else if (messageIn.contains("botbot"))
					messageOut.sendMessage(command.onHelp()).complete();
			}
	}
}