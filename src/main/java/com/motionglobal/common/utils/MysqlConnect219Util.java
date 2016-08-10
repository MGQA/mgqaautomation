package com.motionglobal.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlConnect219Util {

    public static String[][] getTestData(String sql) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://180.150.153.219:3306/sbg2012";
        String user = "dev_update_0607";
        String password = "zPXrfyqzcm02QtlOyrX9@dev";
        List<String[]> records = new ArrayList<String[]>();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            // if (!conn.isClosed()) {
            // System.out.println("connection mysql database success");
            // }
            Statement statement = conn.createStatement();
            //
            // String sql = "select * from " + tablename + ";";
            // String sql = "SELECT payment_product_id FROM gc_payment_country WHERE country_id=63;";
            //
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int cols = rsMetaData.getColumnCount();
            while (rs.next()) {
                String fields[] = new String[cols];
                int col = 0;
                for (int colIdx = 0; colIdx < cols; colIdx++) {
                    fields[col] = rs.getString(colIdx + 1);
                    col++;
                }
                records.add(fields);
            }
            rs.close();
            conn.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("don't find Mysql driver");
        }
        String[][] results = new String[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }
}
