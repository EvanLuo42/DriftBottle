package com.github.evanluo42.api;

import java.io.*;

public class APIFile {
    public static <T extends Object> void save(T obj,String path) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }

    public static <T extends Object> T load(String path) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        T result = (T)ois.readObject();
        ois.close();
        return result;
    }
}