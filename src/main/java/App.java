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

    // connect to database
    connectDatabase connectDatabase = new connectDatabase();
    connectDatabase.main(args);

    // create user table
    createTable createTable = new createTable();
    createTable.main(args);

    // insert a record into user table
    insertQuery insertQuery = new insertQuery();
    insertQuery.main(args);


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
}