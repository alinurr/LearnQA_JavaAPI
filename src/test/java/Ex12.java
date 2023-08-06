import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex12 {
    @Test
    public void testHeaderRequest(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        Headers responseHeaders = response.getHeaders();

        String header = response.getHeader("x-secret-homework-header");

        assertTrue(responseHeaders.hasHeaderWithName("x-secret-homework-header"), "There is no header with name 'x-secret-homework-header'");
        assertTrue(header.equals("Some secret value"), "'x-secret-homework-header' doesn't have value 'Some secret value'");

    }
}
