package com.function;

import java.io.IOException;
import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Azure Functions with HTTP Trigger to get the weather.
 */
public class Function {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    @FunctionName("HttpTrigger")
    public HttpResponseMessage run(@HttpTrigger(name = "req", methods = { HttpMethod.GET,
            HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) throws ParseException, IOException {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Get the current weather at Microsoft
        HttpGet weatherRequest = new HttpGet("https://api.darksky.net/forecast/3ac036c93fab776bb5ae3f1451070a1a/47.639880,-122.124380");
        CloseableHttpResponse weatherResponse = httpClient.execute(weatherRequest);

        return request.createResponseBuilder(HttpStatus.OK).body(EntityUtils.toString(weatherResponse.getEntity())).build();
    }
}
