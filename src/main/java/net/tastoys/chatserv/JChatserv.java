package net.tastoys.chatserv;

import net.tastoys.chatserv.twitch.TwitchClient;

public class JChatserv
{
    static TwitchClient twitchClient;
    public static void main(String[] args)
    {
       twitchClient = new TwitchClient("", "");
       twitchClient.joinChannel("illyohs");
       twitchClient.joinChannel("dwangoac");
    }
}
