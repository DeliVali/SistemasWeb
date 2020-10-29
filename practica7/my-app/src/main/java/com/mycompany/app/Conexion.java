package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String url="jdbc:mysql://127.0.0.1:3306/ejemplo_simple";
private static String driverName="com.mysql.jdbc.Driver";
private static String username="root";
private static String password="";
private static Connection conexion=null;

public static Connection getConnection(){
    try{
      Class.forName(driverName);  
      conexion=DriverManager.getConnection(url, username, password);
      System.out.println("Connection Success");
    }catch(Exception e){
        System.out.println("Failed to connect");
    }catch(ClassNotFoundException e){
        System.out.println("Driver not found");
    }
return conexion;
}

}
