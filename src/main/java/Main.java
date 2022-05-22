import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;


public class Main {
    private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=FRl1zW5Em5OOjWU7bWEx23HYqpz1tL4dHhXA64O0";

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(NASA_URL);

        CloseableHttpResponse response = httpClient.execute(request);
        Nasa nasa = mapper.readValue(response.getEntity().getContent(), Nasa.class);

        HttpGet request2 = new HttpGet(nasa.getHdurl());
        CloseableHttpResponse response2 = httpClient.execute(request2);
        byte[] bytes = response2.getEntity().getContent().readAllBytes();
        File file = new File("nasa_image.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(bytes);
        bos.flush();
        bos.close();
    }
}
