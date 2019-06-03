package com.smarthome.client.electricity;

public class LightPoint {
    private boolean state;

    public void turnOnOff(Boolean onOff){
        this.state = onOff;
    }
}
