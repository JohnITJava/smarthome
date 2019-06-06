package com.smarthome.client.db;

import com.smarthome.client.divices.Device;
import com.smarthome.client.divices.Tablet;
import com.smarthome.client.divices.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class DeviceDBImpl implements DeviceDB {

    private static final Map<Integer, Device> identityMap = new HashMap<>();

    public void insert(Connection conn, Device device) {
        PreparedStatement stat = null;
        String insertSql = "INSERT into devices values(?, ?, ?, ?, ?, ?);";
        try {
            stat = conn.prepareStatement(insertSql);
            stat.setInt(1, device.getId());
            stat.setObject(2, device.getType());
            stat.setDouble(3, device.getScreenHeight());
            stat.setDouble(4, device.getScreenWidth());
            stat.setString(5, device.getCore());
            stat.setDouble(6, device.getCoreSpeed());
            stat.executeUpdate();
            identityMap.put(device.getId(), device);
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
    }

    public void delete(Connection conn, Device device) {
        identityMap.remove(device.getId());
        int result = -1;
        PreparedStatement stat = null;
        String insertSql = "DELETE from devices WHERE id = ?;";
        try {
            stat = conn.prepareStatement(insertSql);
            stat.setInt(1, device.getId());
            int count = stat.executeUpdate();
            result = 0;

        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
    }

    public Device findById(Connection conn, Integer id) {
        if (identityMap.containsKey(id)) {
            return identityMap.get(id);
        }
        Device device = null;
        PreparedStatement stat = null;

        try {
            String selectSql = "SELECT * from devices WHERE id = ?;";
            stat = conn.prepareStatement(selectSql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                device = new Tablet(rs.getInt(1),
                                    (Type) rs.getObject(2),
                                    rs.getDouble(3),
                                    rs.getDouble(4),
                                    rs.getString(5),
                                    rs.getDouble(6));
            }
            identityMap.put(device.getId(), device);
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения команды: " + e.getLocalizedMessage());
            System.err.println("Код ошибки: " + e.getErrorCode());
        } finally {
            try {
                stat.close();
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии оператора: " + e.getLocalizedMessage());
                System.err.println("Код ошибки: " + e.getErrorCode());
            }
        }
        return device;
    }

}
