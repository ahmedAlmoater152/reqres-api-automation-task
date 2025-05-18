package tests;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserApi;

public class CreateUserTest extends TestBase {

    UserApi userApi = new UserApi();

    @Test
    public void testCreateAndRetrieveUser() {
        // Input data
        String name = "Ahmed";
        String job = "Tester";
        String age = "25";

        // Step 1: Create the user (POST)
        Response postResponse = userApi.createUser(name, job, age);
        postResponse.then().statusCode(201);

        String createdId = postResponse.jsonPath().getString("id");
        System.out.println("Created user ID: " + createdId);

        // Step 2: Get the user by ID (GET)
        Response getResponse = userApi.getUserById(createdId);
        getResponse.then().statusCode(200); // Assuming a real backend

        // Step 3: Validate that the GET response matches the POST request
        String getName = getResponse.jsonPath().getString("data.name");
        String getJob = getResponse.jsonPath().getString("data.job");
        String getAge = getResponse.jsonPath().getString("data.age");

        // Assertions (simulate real persistence)
        Assert.assertEquals(getName, name, "Name does not match!");
        Assert.assertEquals(getJob, job, "Job does not match!");
        Assert.assertEquals(getAge, age, "Age does not match!");
        //reqres do not save posted users
    }
}