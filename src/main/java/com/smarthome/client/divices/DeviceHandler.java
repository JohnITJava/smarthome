package com.smarthome.client.divices;

import org.omg.CORBA.Request;

import java.util.ArrayList;
import java.util.List;

public abstract class DeviceHandler {
    private Long id;
    private String version;
    private List<Device> requestOtherDevices;

    private State state;
}
