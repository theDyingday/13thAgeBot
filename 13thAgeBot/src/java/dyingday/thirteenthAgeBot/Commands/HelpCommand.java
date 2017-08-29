package dyingday.thirteenthAgeBot.Commands;

import com.sun.deploy.util.StringUtils;
import dyingday.thirteenthAgeBot.Main;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class HelpCommand extends Command
{
    private static final String NO_NAME = "There is no name provided for this command!";
    private static final String NO_DESCRIPTION = "There is no description provided for this command!";
    private static final String NO_USAGE = "There is no usage instructions provided for this command!";
    private static final String NO_EXAMPLE = "There is no example provided for this command!";


    private static TreeMap<String, Command> commands;

    public HelpCommand()
    {
        commands = new TreeMap<>();
    }

    public Command registerCommand(Command command)
    {
        commands.put(command.getAliases().get(0), command);
        return command;
    }

    @Override
    public void onCommand(MessageReceivedEvent event, String[] args)
    {
        if(!event.isFromType(ChannelType.PRIVATE))
        {
            event.getTextChannel().sendMessage(new MessageBuilder()
                    .append(event.getAuthor())
                    .append(": The help commands have been sent as a private message!")
                    .build()).queue();
            event.getMessage().delete().queue();
        }

        sendPrivate(event.getAuthor().openPrivateChannel().complete(), args, event);
    }

    @Override
    public List<String> getAliases()
    {
        return Arrays.asList("/help", "/commands");
    }

    @Override
    public String getDescription()
    {
        return "The commmand that shows the usage for all other commands!";
    }

    @Override
    public String getName()
    {
        return "Help";
    }

    @Override
    public List<String> getUsage()
    {
        return Collections.singletonList(
                "/help **OR** /help *<command>*\n"
                        + "/help - returns the list of commands along with a simple description of each.\n"
                        + "/help <command> - returns the name, description, aliases and usage information of a command.\n"
                        + "   - This can use the aliases of a command as input as well.");
    }

    @Override
    public String getExample()
    {
        return "/help ping";
    }

    public static void sendPrivate(PrivateChannel channel, String[] args, MessageReceivedEvent event)
    {
        if(args.length < 2)
        {
            for (Command c : commands.values())
            {
                String name = c.getName();
                String description = c.getDescription();
                String example = c.getExample();
                List<String> usageInstructions = c.getUsage();
                name = (name == null || name.isEmpty()) ? NO_NAME : name;
                description = (description == null || description.isEmpty()) ? NO_DESCRIPTION : description;
                usageInstructions = (usageInstructions == null || usageInstructions.isEmpty()) ? Collections.singletonList(NO_USAGE) : usageInstructions;
                example = (example == null || example.isEmpty()) ? NO_EXAMPLE : example;
                channel.sendMessage(Main.getEmbedder(true, Color.white)
                        .addField("**Description: **", description, false)
                        .addField("**Aliases: **", StringUtils.join(c.getAliases(), ", "), false)
                        .addField("**Usage: ** ", usageInstructions.get(0), false)
                        .addField("**Example: **", example, false)
                        .setTitle("**Name: **", null)
                        .setDescription(name).build()).queue();
            }
        }
        else
        {
            String command = args[1].charAt(0) == '/' ? args[1] : "/" + args[1];    //If there is not a preceding '/' attached to the command we are search, then prepend one.
            for (Command c : commands.values())
            {
                if (c.getAliases().contains(command))
                {
                    String name = c.getName();
                    String description = c.getDescription();
                    String example = c.getExample();
                    List<String> usageInstructions = c.getUsage();
                    name = (name == null || name.isEmpty()) ? NO_NAME : name;
                    description = (description == null || description.isEmpty()) ? NO_DESCRIPTION : description;
                    usageInstructions = (usageInstructions == null || usageInstructions.isEmpty()) ? Collections.singletonList(NO_USAGE) : usageInstructions;
                    example = (example == null || example.isEmpty()) ? NO_EXAMPLE : example;

                    channel.sendMessage(Main.getEmbedder(false, Color.white)
                            .addField("**Description: **", description, false)
                            .addField("**Aliases: **", StringUtils.join(c.getAliases(), ", "), false)
                            .addField("**Usage: ** ", usageInstructions.get(0), false)
                            .addField("**Example: **", example, false)
                            .setTitle("**Name: **", null)
                            .setDescription(name).build()).queue();

                    return;
                }
            }
            event.getChannel().sendMessage(new MessageBuilder()
                    .setTTS(true)
                    .append("The provided command '**" + args[1] + "**' does not exist. Use /help to list all commands.")
                    .build()).queue();
        }

    }
}
