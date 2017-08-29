package dyingday.thirteenthAgeBot;

import dyingday.thirteenthAgeBot.Commands.*;
import dyingday.thirteenthAgeBot.RegisterPlayersExcelFiles.Seakul;
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
        jda.addListener(help.registerCommand(help));
        jda.addListener(help.registerCommand(new RollCommand()));
        jda.addListener(help.registerCommand(new ChangeEscalationDieCommand()));
        jda.addListener(help.registerCommand(new GetPlayerInfo()));
        jda.addListener(help.registerCommand(new RelationshipPointRollCommand()));
        jda.addListener(new ClearCommand());
        jda.addListener(new SayCommand());
        jda.addListener(new UsageCommand());
        jda.addListener(new SetNameCommand());

        api = jda.buildAsync();

        Seakul.init();
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
