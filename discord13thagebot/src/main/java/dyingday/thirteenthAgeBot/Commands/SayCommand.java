package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class SayCommand extends Command
{
    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        if(!event.getAuthor().getName().equals("Dyingday")) return;
        TextChannel channel = Main.api.getGuildById("345553425343315969").getTextChannelById("345553426106548224");
        MessageBuilder msg = new MessageBuilder();
        for(String string : args)
        {
            if(!string.equals(args[0]))
            {
                msg.append(string + " ");
            }
        }
        channel.sendMessage(msg.build()).queue();
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/say");
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
