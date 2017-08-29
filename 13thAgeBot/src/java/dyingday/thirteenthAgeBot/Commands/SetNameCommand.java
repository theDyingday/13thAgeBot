package dyingday.thirteenthAgeBot.Commands;

import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class SetNameCommand extends Command
{

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        if(event.getAuthor().getName().equals("Dyingday"))
        {
            StringBuilder msg = new StringBuilder();
            for(int i=1; i<args.length;i++)
            {
                msg.append(args[i] + " ");
            }
            Main.api.getSelfUser().getManager().setName(String.valueOf(msg)).queue();
        }
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("/name");
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
