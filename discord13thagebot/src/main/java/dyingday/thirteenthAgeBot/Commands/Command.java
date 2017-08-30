package dyingday.thirteenthAgeBot.Commands;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

public abstract class Command extends ListenerAdapter
{
    public abstract void onCommand(MessageReceivedEvent event, String[] args);
    public abstract List<String> getAliases();
    public abstract String getDescription();
    public abstract String getName();
    public abstract List<String> getUsage();
    public abstract String getExample();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        /*if(event.getAuthor().isBot() && !respondToBots())
        {
            return;
        }*/
        if(containsCommand(event.getMessage()))
        {
            onCommand(event, commandArgs(event.getMessage()));
        }

    }

    protected boolean containsCommand(Message message)
    {
        return getAliases().contains(commandArgs(message)[0]);
    }

    protected String[] commandArgs(Message message)
    {
        return commandArgs(message.getContent());
    }

    protected String[] commandArgs(String string)
    {
        return string.split(" ");
    }

    protected Message sendMessage(MessageReceivedEvent event, Message message)
    {
        if(event.isFromType(ChannelType.PRIVATE))
        {
            return event.getPrivateChannel().sendMessage(message).complete();
        }
        else
        {
            return event.getTextChannel().sendMessage(message).complete();
        }
    }

    protected Message sendMessage(MessageReceivedEvent event, String message)
    {
        return sendMessage(event, new MessageBuilder().append(message).build());
    }

    protected boolean respondToBots()
    {
        return false;
    }
}
