import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex13 {

    @ParameterizedTest
    @ValueSource(strings = {"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)", "Web", "Chrome", "No"})
    public void testUserAgent(String userAgent, String platform, String browser, String device){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("userAgent", userAgent);
        queryParams.put("platform", platform);
        queryParams.put("browser", browser);
        queryParams.put("device", device);

        JsonPath response = RestAssured
                .given()
                .queryParam(userAgent)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .jsonPath();
        
        String answer = response.get("user_agent");
        assertEquals(platform + " " + browser + " " + device, answer, "");
    }


}
