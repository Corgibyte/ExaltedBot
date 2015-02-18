package com.corgibyte.ExaltedBot;

import org.pircbotx.Configuration;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;

/**
 * Created by hannah on 2/15/15.
 */
public class MyListener extends ListenerAdapter {
    private DiceRoller roller;

    @Override
    public void onJoin(JoinEvent event) {
        event.respond("Hello world");
    }

    /**
     * Performed everytime a event is sent to a channel the bot is occupying. Will check to see if a command is given, and then hand off to the appropriate function.
     *
     * @param event
     */
    @Override
    public void onMessage(MessageEvent event) {
        String[] messages = event.getMessage().split("\\s+");
        if (messages.length > 0 && messages[0].startsWith("!")) {
            switch (messages[0]) {
                case "!cd":
                    characterDice(event);
                    break;
                default:
                    break;
            }
        }
    }

    private void characterDice(MessageEvent event) {
        //TODO: impelement
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
