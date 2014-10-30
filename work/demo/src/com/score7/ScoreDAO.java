package com.score7;

import com.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2014-10-30.
 */
public class ScoreDAO {

    Connection conn = DBConn.getConnection();

    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql;

    public void insert(ScoreDTO dto) {
        sql = "insert into score(hak, name, kor, eng, mat) ";
        sql += "values (?,?,?,?,?)";

        executeQuery(dto);
    }

    public ResultSet print() {
        sql = "select hak, name, kor, eng, mat, (kor+eng+mat) tot, (kor+eng+mat)/3 ave, " +
                "RANK() OVER(ORDER BY (kor+eng+mat) DESC) rank";
        sql += " from score order by hak";
        executeQuery();

        return rs;
    }

    public ResultSet find(String gv) {
        sql = "select hak, name, kor, eng, mat, (kor+eng+mat) tot, (kor+eng+mat)/3 ave, " +
                "RANK() OVER(ORDER BY (kor+eng+mat) DESC) rank";
        sql += " from score " + gv + " order by hak";
        executeQuery();

        return rs;
    }

    public void update(String hak, ScoreDTO info) {
        sql = "update score set ";
        sql += "hak='" + info.getHak() +"', name='" + info.getName() + "', kor='"
                + info.getKor() + "', eng='" + info.getEng() + "', mat='" + info.getMat() + "' ";
        sql +=  "where hak='" + hak + "'";
        executeQuery();
    }

    public void deleteOne(String hak) {
        sql = "delete score where hak='" + hak + "'";
        executeQuery();
    }

    public void deleteAll() {
        sql = "delete score";
        executeQuery();
    }

    public void executeQuery() {
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(ScoreDTO dto) {
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getHak());
            pstmt.setString(2, dto.getName());
            pstmt.setInt(3, dto.getKor());
            pstmt.setInt(4, dto.getEng());
            pstmt.setInt(5, dto.getMat());
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
