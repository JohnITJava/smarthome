package com.smarthome.client.divices;

public abstract class Device {
    private int id;
    private Type type;
    private double screenHeight;
    private double screenWidth;
    private String core;
    private double coreSpeed;

    public Device(int id, Type type, double screenHeight, double screenWidth, String core, double coreSpeed) {
        this.id = id;
        this.type = type;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.core = core;
        this.coreSpeed = coreSpeed;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public double getScreenHeight() {
        return screenHeight;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public String getCore() {
        return core;
    }

    public double getCoreSpeed() {
        return coreSpeed;
    }

    public Device() {
    }


}
