package com.smarthome.client.divices;

import com.smarthome.client.db.DeviceDBImpl;

import java.util.List;

public abstract class DeviceHandler {
    private Long id;
    private String version;
    private static List<Device> requestOtherDevices;

    private State state;
}
