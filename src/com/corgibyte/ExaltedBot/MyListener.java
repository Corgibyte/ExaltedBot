package com.corgibyte.ExaltedBot;

import org.pircbotx.Configuration;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.JoinEvent;

/**
 * Created by hannah on 2/15/15.
 */
public class MyListener extends ListenerAdapter {
    @Override
    public void onJoin(JoinEvent event) {
        event.respond("Hello world");
    }

    public static void main(String[] args) throws Exception {
        //Configure what we want the bot to do
        Configuration configuration = new Configuration.Builder<ExaltedIrcBot>()
                .setName("ExaltedBot")
                .setServerHostname("irc.magicstar.net")
                .addAutoJoinChannel("#ExaltedBotTest")
                .addListener(new MyListener())
                .buildConfiguration();

        ExaltedIrcBot bot = new ExaltedIrcBot(configuration);

       bot.startBot();
    }
}
