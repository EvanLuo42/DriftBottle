package com.github.evanluo42.command;

import com.github.evanluo42.DriftBottle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandDriftBottle implements CommandExecutor {
    private final DriftBottle plugin;

    public CommandDriftBottle(DriftBottle plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("db")){
            if(args[0].equalsIgnoreCase("throw")){
                CommandThrow commandthrow = new CommandThrow(plugin);
                commandthrow.onCommand(sender,command,label,args);
                return true;
            }else if(args[0].equalsIgnoreCase("receive")){
                CommandReceive commandreceive = new CommandReceive(plugin);
                commandreceive.onCommand(sender,command,label,args);
                return true;
            }
        }
        return false;
    }
}
