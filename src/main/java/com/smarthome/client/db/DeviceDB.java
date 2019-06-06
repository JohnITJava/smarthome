package com.smarthome.client.db;

import com.smarthome.client.divices.Device;

import java.sql.Connection;
import java.util.List;

public interface DeviceDB {

    void insert(Connection conn, Device device);

    void update(Connection conn, Device device);

    void delete(Connection conn, Device device);

    List<Device> selectAll(Connection conn);

    List<Device> findByName(Connection conn, String title);
}
