package com.smarthome.client.divices;

import java.util.List;

public interface SmartPhone {
    State connect();
    State reload();
    State startUp();
    Long connectToServer();
    String downloadUpdates();

    List<Device> requestDevicesInfo();

}
