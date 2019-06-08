package co.hygames.helpfultrork;

import discord4j.core.DiscordClient;
import discord4j.core.event.domain.guild.MemberJoinEvent;
import discord4j.core.object.util.Snowflake;

//Set a role
public class RoleAssignment {
    private final Snowflake seedlingRole = Snowflake.of(574524064777895936l);

    RoleAssignment(Trork trork, DiscordClient client) {
        client.getEventDispatcher().on(MemberJoinEvent.class)
                .subscribe((event) -> {
                    System.out.println("User " + event.getMember().getDisplayName() + " is now one of us");
                    event.getMember().addRole(seedlingRole).block();
                });
    }
}