package com.db;

import com.util.DBConn;
import java.sql.Connection;

public class DBTest {

    public static void main(String[] args) {

        Connection conn = DBConn.getConnection();

        if(conn == null) {
            System.out.println("연결 실패!");
            System.exit(0);
        }

        System.out.println("연결 성공!");
        DBConn.close();
    }
}
