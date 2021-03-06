package com.github.evanluo42.command;

import com.github.evanluo42.DriftBottle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.Random;

import static com.github.evanluo42.DriftBottle.bottles;

public class CommandReceive implements CommandExecutor {
    private final DriftBottle plugin;

    public CommandReceive(DriftBottle plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Collections.shuffle(bottles);
        Random r = new Random(1000);
        int index = r.nextInt(bottles.size());
        if(bottles.contains(index)){
            sender.sendMessage("漂流瓶:"+bottles.get(index));
            return true;
        }else{
            sender.sendMessage("没有漂流瓶哦!");
            return true;
        }
    }
}
