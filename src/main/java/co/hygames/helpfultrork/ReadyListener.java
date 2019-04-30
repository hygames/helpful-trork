package co.hygames.helpfultrork;

import discord4j.core.DiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.User;

public class ReadyListener {

    ReadyListener(Trork trork, DiscordClient client) {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(event -> {
                    User self = event.getSelf();
                    System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator()));
                    trork.loggedIn();
                });
    }
}
