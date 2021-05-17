package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionSample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbUtils.getConnection();
            // 关闭默认自动提交 // 自动回滚
            conn.setAutoCommit(false);
            String sql = "insert into employee(eno,ename,salary,dname) values(?,?,?,?)";
            for(int i=1000; i<2000; i++){
                if(i==1005){
                    //throw new RuntimeException("插入失败");
                }
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,i);
                pstmt.setString(2,"员工"+i);
                pstmt.setFloat(3,4000f);
                pstmt.setString(4,"市场部");
                pstmt.executeUpdate();
            }
            // for循环完整执行后再提交
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if(conn!=null && !conn.isClosed()){
                    conn.rollback(); // 回滚数据
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally{
            DbUtils.closeConnection(null,pstmt,conn);
        }

    }
}
