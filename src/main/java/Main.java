import static spark.Spark.get;

/**
 * Created by deant on 9/14/17.
 */
public class Main {
    public static void main(String[] args) {
        get("/hello", (request, response) -> "Hello from localhost");
    }
}
