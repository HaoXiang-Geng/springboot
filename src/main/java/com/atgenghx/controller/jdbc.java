package com.atgenghx.controller;


import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;


public class jdbc {
    static Connection con; // 声明Connection对象
    static Statement sql; // 声明Statement对象
    static ResultSet res; // 声明ResultSet对象

    public Connection getConnection() { // 连接数据库方法

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:"
                    + "//192.168.5.249:3306/report", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con; // 返回Connection对象
    }



    public void report(String message){
        jdbc c = new jdbc(); // 创建本类对象
        con = c.getConnection(); // 与数据库建立连接

        try {
            sql = con.createStatement(); // 实例化Statement对象
            // 执行SQL语句，返回结果集
            String sqlan="";
//                    sqlan="insert into dat(infohash,size) values(\""+arr.get(i)+"\")";
            sqlan="insert into p2p(message) " +
                    "values(\""+message+"\");";
            System.out.println(sqlan);
            sql.execute(sqlan);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<String> douyinurl() throws SQLException{
//    @Test
//    public void douyinurl() throws SQLException{
        jdbc c = new jdbc(); // 创建本类对象
        con = c.getConnection(); // 与数据库建立连接
        ArrayList<String> arr=new ArrayList<String>();
        try {
            String sqlan="select * from p2p;";
            sql = con.createStatement();// 实例化Statement对象
            // 执行SQL语句，返回结果集

            System.out.println(sqlan);
            res = sql.executeQuery(sqlan);

            while (res.next()) { // 如果当前语句不是最后一条则进入循环
                String message = res.getString("message"); // 获取列名是"id"的字段值
                arr.add(message);
                System.out.println("message:" + message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Test
    public void testjdbc() throws SQLException {
//        ArrayList<String> arr1= douyinurl();
//        System.out.println(arr1.toString());
    }
}
