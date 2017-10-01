import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

/**
 * Created by deant on 9/14/17.
 */
public class App {
  public static void main(String[] args) {
    port(getHerokuAssignedPort());
    staticFileLocation("public");

    get("/", (request, response) -> {
      Map<String, Object> viewObjects = new HashMap<>();
      viewObjects.put("title", "Welcome to IT Matcher");
      return new ModelAndView(viewObjects, "home.ftl");
    }, new FreeMarkerEngine());

    get("/login.html", (request, response) -> {
      Map<String, Object> viewObjects = new HashMap<>();
      viewObjects.put("title", "Welcome to IT Matcher");
      return new ModelAndView(viewObjects, "login.ftl");
    }, new FreeMarkerEngine());
  }

  static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
  }
}