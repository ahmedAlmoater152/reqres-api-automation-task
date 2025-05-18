package pages;

import io.restassured.response.Response;
import utils.ConfigManager;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApi {

    private final String apiKey = ConfigManager.get("api.key");

    public Response createUser(String name, String job, String age) {
        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("job", job);
        body.put("age", age);

        return given()
                .header("x-api-key", apiKey)
                .contentType("application/json")
                .body(body)
                .post("/api/users");
    }

    public Response getUserById(String id) {
        return given()
                .header("x-api-key", apiKey)
                .get("/api/users/" + id);
    }
}
