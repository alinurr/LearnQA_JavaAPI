import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex11 {

    @Test
    public void testMethodCookie(){
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        Map<String, String> responseCookie = response.getCookies();
        System.out.println(responseCookie);

        String cookie = response.getCookie("HomeWork");
        System.out.println(cookie);

        assertTrue(responseCookie.containsKey("HomeWork"), "Response doesn't have 'HomeWork' cookie");
        assertTrue(responseCookie.containsValue("hw_value"), "Cookie doesn't have 'hw_value'");
    }
}
