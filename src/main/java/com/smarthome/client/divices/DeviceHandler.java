package com.smarthome.client.divices;

import java.util.List;

public abstract class DeviceHandler {
    private Long id;
    private String version;
    private List<Device> requestOtherDevices;

    private State state;

}
