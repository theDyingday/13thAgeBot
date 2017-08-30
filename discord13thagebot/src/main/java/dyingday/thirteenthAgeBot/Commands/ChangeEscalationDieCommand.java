package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static dyingday.thirteenthAgeBot.Main.esc;

public class ChangeEscalationDieCommand extends Command
{

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        EmbedBuilder msg = Main.getEmbedder(false, Color.blue);
        TextChannel channel = Main.api.getTextChannelById("345553426106548224");
        String message = null;
        if(args.length < 2)
        {
            message = "The escalation die is: " + esc;
        }
        else
        {
            try
            {
                if(args[1].contains("-"))
                {
                    args[1] = args[1].replace("-", "");
                    if(args[1].equals(""))
                    {
                        esc--;
                    }
                    else
                    {
                        esc = esc - Integer.parseInt(args[1]);
                    }
                }
                else if(args[1].contains("+"))
                {
                    args[1] = args[1].replace("+", "");
                    if(args[1].equals(""))
                    {
                        esc++;
                    }
                    else
                    {
                        esc = esc + Integer.parseInt(args[1]);
                    }
                }
                else
                {
                    esc = Integer.parseInt(args[1]);
                }
                if(esc > 6)
                {
                    esc = 6;
                }
                else if(esc < 0)
                {
                    esc = 0;
                }
                message = "The escalation die is: " + esc;
            }
            catch (Exception e)
            {
                if(args[1].equals("reset"))
                {
                    Main.esc = 0;
                    message = "Escalation die has been reset to 0";
                }
            }
        }
        event.getChannel().sendMessage(msg.appendDescription(message).build()).queue();
        if(!(channel == event.getTextChannel()))
        {
            channel.sendMessage(msg.build()).queue();
        }


    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/edice");
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
