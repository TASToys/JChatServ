package net.tastoys.chatserv.twitch;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.WebSocket;

import java.net.URI;

public class TwitchClient
{
    String name;
    String token;
    WebSocket socket;
    HttpClient client;
    boolean isConnected;

    public TwitchClient(String name, String token)
    {
        this.name = name;
        this.token = token;
    }

    public String getName()
    {
        return name;
    }


    public void connect()
    {
        client = HttpClient.newHttpClient();
        socket = client.newWebSocketBuilder().buildAsync(URI.create("wss://irc-ws.chat.twitch.tv"), new TwitchListener()).join();

        socket.sendText("PASS " + token, false);
        socket.sendText("NICK " + name, false);
        this.isConnected = true;
    }

    public boolean isConnected()
    {
        return isConnected;
    }

    public void joinChannel(String channel)
    {
        if (isConnected)
        {
            socket.sendText("JOIN #" + channel, false);
        }
    }
}
