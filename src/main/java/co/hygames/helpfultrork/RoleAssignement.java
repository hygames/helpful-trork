package co.hygames.helpfultrork;
//Set a role
public class RoleAssignement {
    bot.on("Ready",function(){
        console.log("Ready");
    })
}
//known ID
let SetRole = member.setRoles(["Seedling"]);

//Unown ID
const role = guild.roles.find(role => role.name ===`Seedling`);
member.addRole(role);

bot.on("guildMemberAdd", function(member))
        {
            let memberRole = member.guild.roles.find("name","Seedling");
            member.addRole(memberRole);
        })