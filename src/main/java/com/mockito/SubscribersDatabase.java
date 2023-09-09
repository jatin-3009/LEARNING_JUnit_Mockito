package com.mockito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersDatabase {

    public List<String> getSubscribers() {
        List<String> subscribers = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("DB_URL");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT EMAIL FROM SUBSCRIBER_TABLE");

            while(rs.next()) {
                subscribers.add(rs.toString());
            }
        } catch(SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return subscribers;
    }
}
