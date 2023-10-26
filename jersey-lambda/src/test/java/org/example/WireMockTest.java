package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.minidev.json.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

public class WireMockTest {

//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(8080);
//
////    static WireMockServer wireMockServer = new WireMockServer();
//
//
//    @Before
//    public void beforeAll() {
//        wireMockRule.start();
//    }
//
//    @After
//    public void afterAll() {
//        wireMockRule.stop();
//    }
//
//    @AfterEach
//    public void afterEach() {
//        wireMockRule.resetAll();
//    }

//    @Test
//    void simpleStubTesting(WireMockRuntimeInfo wmRuntimeInfo) {
//        String responseBody = "Hello World !!";
//        String apiUrl = "/api-url";
//
//        //Define stub
//        stubFor(get(apiUrl).willReturn(ok(responseBody)));
//
//        //Hit API and check response
//        String apiResponse = getContent(wmRuntimeInfo.getHttpBaseUrl() + apiUrl);
//        assertEquals(apiResponse, responseBody);
//
//        //Verify API is hit
//        verify(getRequestedFor(urlEqualTo(apiUrl)));
//    }
//
//    private String getContent(String url) {
//
//        TestRestTemplate testRestTemplate = new TestRestTemplate();
//        return testRestTemplate.getForObject(url, String.class);
//    }
    @BeforeClass
    public static void setUp() {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        configureFor("localhost", 8080);
        // return all messages
        stubFor(get(urlEqualTo("/messages")).willReturn(aResponse().withBody(
                "{\"1\":\"Good morning\"}," +
                        "{\"2\":\"Good afternoon\"}," +
                        "{\"3\":\"Good evening\"}," +
                        "{\"4\":\"Good night\"}")));
        // return message by id
        stubFor(get(urlEqualTo("/messages/1")).willReturn(aResponse().withBody("{\"1\": \"Good morning\"}")));
    }

    @Test
    public void firstTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8080/test");

        HttpResponse httpResponse = httpClient.execute(request);
        InputStream responseStream = httpResponse.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();

        verify(getRequestedFor(urlEqualTo("/test")));
        assertEquals("Wiremock", responseString);
    }
}
