package net.tastoys.chatserv.twitch;

import jdk.incubator.http.WebSocket;
import jdk.incubator.http.WebSocket.Listener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TwitchListener implements Listener
{
    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence message, WebSocket.MessagePart part)
    {
        return CompletableFuture.completedFuture(message).thenAccept(System.out::println);
    }
}
