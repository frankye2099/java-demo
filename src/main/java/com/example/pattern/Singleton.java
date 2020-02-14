package com.example.pattern;

public class Singleton {
    private static volatile Singleton instance;
    private String data;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public String getData() {
        return data;
    }

    /**
     * not thread safe
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }
}
