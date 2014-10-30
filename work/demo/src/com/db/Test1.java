package com.db;

import com.util.DBConn;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

    public static void main(String[] args) {

        Connection conn = DBConn.getConnection();

        if(conn==null) {
            System.out.println("DB 연결 실패!");
            System.exit(0);
        }

        try {
            Statement stmt = conn.createStatement();
            String sql;

            sql = "insert into score (hak,name,kor,eng,mat) ";
            sql += "values ('222', '배수지', 70, 50, 90)";

            int result = stmt.executeUpdate(sql);

            if(result == 1)
                System.out.println("추가 성공!");

            sql = "update score set name='박슬기', kor=100 where hak='111'";

            result = stmt.executeUpdate(sql);

            if(result == 1)
                System.out.println("수정 성공!");

            sql = "delete score where hak='222'";

            result = stmt.executeUpdate(sql);

            if(result == 1)
                System.out.println("삭제 성공!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConn.close();
    }

}
