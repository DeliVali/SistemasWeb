package com.mycompany.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static Conexion conexion =new Conexion();
    public static List <Usuarios> demeUsuarios(){
        Statement stm=null;
        Connection con=null;
        ResultSet rs=null;
        List<Usuarios>resultado=new ArrayList<>();
        
        con=conexion.getConnection();
        try {
            String sql= "Select * from usuarios";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u =new Usuarios(rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs=null;
            }
        }
        if(stm!=null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
