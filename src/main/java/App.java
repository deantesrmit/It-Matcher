import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.get;

/**
 * Created by deant on 9/14/17.
 */
public class App {
  public static void main(String[] args) {
    Spark.staticFiles.externalLocation("src/main/resources/public");
    get("/", (request, response) -> {
      Map<String, Object> viewObjects = new HashMap<>();
      viewObjects.put("title", "Welcome to IT Matcher");
      return new ModelAndView(viewObjects, "masterTemplate.ftl");
    }, new FreeMarkerEngine());
  }
}