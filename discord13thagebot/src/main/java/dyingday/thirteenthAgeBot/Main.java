package dyingday.thirteenthAgeBot;

import dyingday.thirteenthAgeBot.Commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static JDA api;

    public static final String BOT_TOKEN = "MzQ1NTU0NjE0MDU1MjA2OTE0.DG8_YA.C1IBRC9TJL2dR_XZE_NsXS9uBQI";

    public static Date date = new Date();
    public static SimpleDateFormat sdf = new SimpleDateFormat("E',' d MMM yyyy' at 'hh:mm a");

    public static int esc;

    public static void main(String[] args) throws Exception
    {
        JDABuilder jda = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN);
        HelpCommand help = new HelpCommand();
        jda.addEventListener(help.registerCommand(help));
        jda.addEventListener(help.registerCommand(new RollCommand()));
        jda.addEventListener(help.registerCommand(new ChangeEscalationDieCommand()));
        jda.addEventListener(help.registerCommand(new RelationshipPointRollCommand()));
        jda.addEventListener(new ClearCommand());
        jda.addEventListener(new SayCommand());
        jda.addEventListener(new UsageCommand());
        jda.addEventListener(new SetNameCommand());

        api = jda.buildAsync();
    }

    public static EmbedBuilder getEmbedder(boolean botnameAsAuthor, Color color)
    {
        EmbedBuilder emb = new EmbedBuilder();
        //emb.setFooter(sdf.format(date), null);
        emb.setColor(color);
        if(botnameAsAuthor) {emb.setAuthor(api.getSelfUser().getName(), null, api.getSelfUser().getAvatarUrl());}
        return emb;
    }
}
