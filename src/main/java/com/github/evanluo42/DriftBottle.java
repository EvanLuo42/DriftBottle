package com.github.evanluo42;

import com.github.evanluo42.api.APIFile;
import com.github.evanluo42.command.CommandDriftBottle;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class DriftBottle extends JavaPlugin {
    public static ArrayList<Object> bottles = new ArrayList<>();
    private File file = new File(getDataFolder()+File.separator+"bottle.dat");
    @Override
    public void onEnable() {
        getLogger().info("The plugin has been loaded!");
        if(getDataFolder().exists()){
            try{
                if (!file.exists()) {
                    file.createNewFile();
                }
                bottles = APIFile.load(file.toString());
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            getDataFolder().mkdir();
            try{
                if (!file.exists()) {
                    file.createNewFile();
                }
                bottles = APIFile.load(file.toString());
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        this.getCommand("db").setExecutor(new CommandDriftBottle(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been closed!");
        try {
            APIFile.save(bottles,file.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
