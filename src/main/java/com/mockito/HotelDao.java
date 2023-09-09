package com.mockito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

    public List<String> fetchAvailableRooms() throws SQLException {
        List<String> availableRooms = new ArrayList<>();
        Connection conn = DriverManager.getConnection("DATABASE_URL");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM ROOMS WHERE AVAILABLE like '1'");

        while (rs.next()) {
            availableRooms.add(rs.getString("Room name"));
        }

        return availableRooms;
    }
}