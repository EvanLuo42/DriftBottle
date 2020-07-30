package com.github.evanluo42.command;

import com.github.evanluo42.DriftBottle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.Random;

import static com.github.evanluo42.DriftBottle.bottles;

public class CommandThrow implements CommandExecutor {
    private final DriftBottle plugin;

    public CommandThrow(DriftBottle plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[1]!=null){
            bottles.add(args[1]);
            sender.sendMessage("漂流瓶已投掷成功!");
            return true;
        }else{
            return false;
        }
    }
}
