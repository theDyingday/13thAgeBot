package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RelationshipPointRollCommand extends Command
{
    Random rand = new Random();

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        int total5s = 0;
        int total6s = 0;
        EmbedBuilder msg = Main.getEmbedder(false, Color.yellow);
        for(int i = 1; i < args.length; i++)
        {
            String[] points;
            int roll;
            int value;
            String idol = "";
            if (args[i].contains("-"))
            {
                points = args[i].split("-");
                value = Integer.parseInt(points[0]);
                idol = points[1];
            }
            else
            {
                value = 1;
                idol = args[i];
            }
            for(int j = 1; j <= value; j++)
            {
                roll = rollRelationship();
                if(roll == 1)
                {
                    msg.appendDescription("You rolled a 6 for: **" + idol + "**\n");
                    total6s++;
                }
                else if(roll == 2)
                {
                    msg.appendDescription("You rolled a 5 for: **" + idol + "**\n");
                    total5s++;
                }
            }
        }
        if(total5s == 0 && total6s == 0)
        {
            msg.appendDescription("You rolled no 5s or 6s!");
        }
        msg.setTitle("Relationsip Roles!", null);
        event.getChannel().sendMessage(msg.build()).queue();
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/rp");
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

    private int rollRelationship()
    {
        int rand1 = rand.nextInt(6) + 1;
        if(rand1 == 6)
        {
            return 1;
        }
        else if(rand1 == 5)
        {
            return 2;
        }
        else return 0;
    }
}
