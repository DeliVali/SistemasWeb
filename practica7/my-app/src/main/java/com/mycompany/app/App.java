package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App 
{




    
    private static Gson gson=new Gson();
    private  static Map<String,Usuarios>usuarios=new HashMap<>();
    
    public static void main( String[] args )
    {
port(4567);

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));






        before((req,res)-> res.type("application/json"));
        get("/usuarios", (req,res)->gson.toJson(usuarios.values()));

        post("/usuarios", (req,res)->{
            String query=req.body();
            System.out.println( "Peticion: "+query );
             Usuarios u = gson.fromJson(query, Usuarios.class);
             String id=UUID.randomUUID().toString();
             u.setId(id);
             usuarios.put(id, u);
             return "se creo el usuario con ID: "+id;
        });
       
    }
}
