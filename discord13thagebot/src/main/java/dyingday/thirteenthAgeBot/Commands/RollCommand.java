package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RollCommand extends Command
{
    Random rand = new Random();

    int finalValue = 0;
    int rollValue;

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        EmbedBuilder msg = Main.getEmbedder(false, Color.green);

        String roll;
        String[] array = new String[2];

        if(args.length >= 2)
        {
            for(int i = 1; i < args.length; i++)
            {
                roll = args[i];
                if(roll.startsWith("d"))
                {
                    roll = roll.replace("d", "");
                    if (roll.contains("+"))
                    {
                        msg = addRoll(Integer.parseInt(roll.substring(0, roll.indexOf("+"))), 1, Integer.parseInt(roll.substring(roll.indexOf("+") + 1, roll.length())), msg);
                    }
                    else
                    {
                        msg = addRoll(Integer.parseInt(roll), 1, 0, msg);
                    }
                }
                else
                {
                    if (roll.contains("+"))
                    {
                        msg = addRoll(Integer.parseInt(roll.substring(roll.indexOf("d") + 1, roll.indexOf("+"))), Integer.parseInt(roll.substring(0, roll.indexOf("d"))), Integer.parseInt(roll.substring(roll.indexOf("+") + 1, roll.length())), msg);
                    }
                    else
                    {
                        msg = addRoll(Integer.parseInt(roll.substring(roll.indexOf("d") + 1, roll.length())), Integer.parseInt(roll.substring(0, roll.indexOf("d"))), 0, msg);
                    }
                }
            }
            if(args[0].equals("/ar"))
            {
                finalValue = finalValue + Main.esc;
            }
            if(!args[1].startsWith("d") || args[1].contains("+") || args.length > 2 || args[0].equals("/ar"))
            {
                msg.setTitle("**Total:** " + finalValue, null);
            }
            event.getChannel().sendMessage(msg.build()).queue();
        }
        finalValue = 0;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/ar", "/r");
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

    private EmbedBuilder addRoll(int rollSize, int multiplier, int add, EmbedBuilder msg)
    {
        for(int i = 0; i < multiplier; i++)
        {
            rollValue = rand.nextInt(rollSize) + 1;
            msg.appendDescription("**Natural:** " + rollValue + "   (d" + rollSize + ")\n");
            finalValue = finalValue + rollValue;
        }
        finalValue = finalValue + add;
        return msg;
    }
}
