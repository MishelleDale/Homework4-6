package accuweatherWithWireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public class AccuweatherWireMockWithRestAssuredAbstractTest {
    private static final WireMockServer wireMockServer = new WireMockServer();
    private static final int port = 8080;
    private static String baseUrl;
    private static String baseRealUrl;

    private static final Logger logger = LoggerFactory.getLogger(AccuweatherWireMockWithRestAssuredAbstractTest.class);

    @BeforeAll
    static void startServer() {
        baseUrl = "http://localhost:" + port;
        wireMockServer.start();
        configureFor("localhost", port);
        logger.info("Start WoreMockServer on port {}", port);
    }

    @AfterAll
    static void stopServer() {
        wireMockServer.stop();
        logger.info("Stop WireMockServer");
    }
    public static String getBaseUrl(){
        return baseUrl;
    }
}
