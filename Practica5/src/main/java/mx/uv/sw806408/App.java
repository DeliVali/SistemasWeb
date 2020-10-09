package mx.uv.sw806408;

import static spark.Spark.*;
/**
 * Hello worldd!
 *
 */
public class App 
{
    public static void main( String[] args )
    { port(2020);
        get("/", (req, res)->"Hola desde Spark");
    }
}
