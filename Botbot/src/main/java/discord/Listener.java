/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Discord;

import net.dv8tion.jda.core.Permission;
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
				String message = event.getMessage().getContentDisplay();
				
				if (message.equals("botbot help"))
					event.getTextChannel().sendMessage(command.onHelp()).complete();
				else if (message.equals("botbot wow week"))
					event.getTextChannel().sendMessage(command.onWoWWeek()).complete();
				else if (message.contains("botbot wow"))
					event.getTextChannel().sendMessage(command.onWoWPlayer(message)).complete();
				else if (message.contains("botbot heroes"))
					event.getTextChannel().sendMessage(command.onHeroesPlayer(message)).complete();
				else if (message.contains("botbot sc2"))
					event.getTextChannel().sendMessage(command.onStarcraftPlayer(message)).complete();
			}
	}
}