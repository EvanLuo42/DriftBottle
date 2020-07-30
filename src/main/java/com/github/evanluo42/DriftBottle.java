package com.github.evanluo42;

import com.github.evanluo42.api.APIFile;
import com.github.evanluo42.command.CommandDriftBottle;
import com.github.evanluo42.command.CommandReceive;
import com.github.evanluo42.command.CommandThrow;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class DriftBottle extends JavaPlugin {
    public static ArrayList<Object> bottles = new ArrayList<>();
    private File file = new File(getDataFolder()+"bottles.bin");
    @Override
    public void onEnable() {
        getLogger().info("[DriftBottle]The plugin has been loaded!");
        try{
            if(file.exists()){
                bottles = APIFile.load(file.toString());
            }else{
                file.createNewFile();
                bottles = APIFile.load(file.toString());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        this.getCommand("db").setExecutor(new CommandDriftBottle(this));
        this.getCommand("throw").setExecutor(new CommandThrow(this));
        this.getCommand("receive").setExecutor(new CommandReceive(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("[DriftBottle]The plugin has been closed!");
        try {
            APIFile.save(bottles,file.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
