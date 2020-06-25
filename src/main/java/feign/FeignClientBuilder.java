package feign;

import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Getter;

@Getter
public class FeignClientBuilder {

    private ToDoClient toDoClient = createClient(ToDoClient.class, "https://jsonplaceholder.typicode.com/todos");

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .logger(new Slf4jLogger())
                    .logLevel(Logger.Level.FULL)
                    .target(type, uri);
    }
}
