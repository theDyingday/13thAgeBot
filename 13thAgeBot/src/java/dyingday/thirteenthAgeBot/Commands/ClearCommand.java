package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class ClearCommand extends Command
{

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        if(event.getAuthor().getId().equals("264777067411931137"))
        {
            TextChannel channel;
            if(args[1].equals("usage"))
            {
                channel = Main.api.getTextChannelById("346255099531624449");
            }
            else
            {
                channel = event.getTextChannel();
            }
            event.getMessage().delete().queue();
            MessageHistory msgHist = new MessageHistory(channel);
            for (int i = 0; i < Math.floor(msgHist.getRetrievedHistory().size() / 100) + 1; i++)
            {
                List<Message> msgs = msgHist.retrievePast(100).complete();
                event.getTextChannel().deleteMessages(msgs).queue();
            }
        }
        else
        {
            event.getChannel().sendMessage("You are not " + Main.api.getUserById("264777067411931137").getName() + " so you cannot run this command!").queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/clear");
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getUsage() {
        return null;
    }

    @Override
    public String getExample() {
        return null;
    }
}
