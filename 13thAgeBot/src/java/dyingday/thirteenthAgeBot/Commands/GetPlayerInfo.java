package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import dyingday.thirteenthAgeBot.RegisterPlayersExcelFiles.Seakul;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class GetPlayerInfo extends Command
{

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args) {
        if(args[1] == "Seakul")
        {
            EmbedBuilder msg = Main.getEmbedder(false, java.awt.Color.RED);
            msg.addField("Health", String.valueOf(Seakul.hp), true);
            msg.addField("Recoveries", String.valueOf(Seakul.recoveries), true);
            event.getChannel().sendMessage(msg.build()).queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/info");
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
