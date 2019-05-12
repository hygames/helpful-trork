package co.hygames.helpfultrork;

//Private message to player after they join for the first time
public class Communitcator {
        bot.on("Ready",function(){
            console.log("Ready");
        })
    }

bot.on(`ready`,function()(
            console.log(`ready`);
        ));

        bot.on("guildMemberAdd", function(member))
        {
        member.send("Welcome to Hygames");
        }