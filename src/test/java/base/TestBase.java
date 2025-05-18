package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigManager;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class TestBase {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigManager.get("base.url");
        useRelaxedHTTPSValidation();
    }
}