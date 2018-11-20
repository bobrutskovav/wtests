import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ApiTests {

    private static String endpoint = "https://httpbin.org";


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = endpoint;
        //  RestAssured.proxy("cp-proxy.nspk.ru", 8080);
        RestAssured.useRelaxedHTTPSValidation();
    }


    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void delayTest(long delayInSeconds) {
        //Сервис не может отдать делей в 1 секунду)))
        given().pathParam("delay", delayInSeconds).get("/delay/{delay}").then().statusCode(200)
                .time(equalTo(delayInSeconds), TimeUnit.SECONDS);
    }

    @ParameterizedTest
    @ValueSource(longs = {11, 12, 100, 1000})
    public void negativeDeleyTest(long delay) {
        //Cервис отдаёт максимум через 10 секунд,посчитаем за граничное условие
        given().pathParam("delay", delay).
                get("/delay/{delay}").then().statusCode(200).time(equalTo(10L), TimeUnit.SECONDS);
    }


    @Test
    public void imageTest() {
        byte[] expectedImage = ApiTests.class.getResource("/pic/test.png").getFile().getBytes();
        byte[] actualImange = given().get("/image/png").getBody().asByteArray();
        Assertions.assertEquals(expectedImage, actualImange);
    }


}
