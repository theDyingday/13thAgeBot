package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UsageCommand extends Command
{
    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        if(event.getAuthor().getName().equals("Dyingday"))
        {
            EmbedBuilder msg = Main.getEmbedder(false, Color.RED);
            msg.addField("Roll Command", "Usage: /r [<multiplier>]d<diceValue>[+<increment>] \n" + "This command can take in multiple sets of dice \n" + "Example: /r 5d20+6 d4", true);
            msg.addField("Attack Roll Command", "Usage: /ar [multiplier]d<diceValue>[<+><increment>] \n" + "This command is the same as the normal roll command but adds the value of the escalation die on top \n" + "Example: /ar d20+6", false);
            msg.addField("Escalation Die", "Usage: /edice [<reset>|<diceValue>|<+>] \n" + "Examples: \n" + "/edice <- Prints the value of the Escalation Die\n" + "/edice reset <- Resets the Escalation Die to 0\n" + "/edice 3 <- Sets the value of the Escalation Die to 3\n" + "/edice + <- Increases the Escalation Die by 1\n" + "/edice +3 <- Adds 3 on to the Escalation Die\n/edice -2 <- Subtracts 2 from the Escalation Die", false);

            Main.api.getTextChannelById("346255099531624449").sendMessage(msg.build()).queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/usage");
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
