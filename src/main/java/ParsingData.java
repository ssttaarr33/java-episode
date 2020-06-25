import java.util.Map;
import java.util.stream.Collectors;

import feign.FeignClientBuilder;
import feign.ToDoClient;
import model.Todo;

public class ParsingData {
    private static ToDoClient client;

    public static void main(String[] args) {
        FeignClientBuilder feignClientBuilder = new FeignClientBuilder();
        client = feignClientBuilder.getToDoClient();

        Map<Boolean, Long> collect = client.getTodo().stream().collect(Collectors.groupingBy(Todo::getCompleted, Collectors.counting()));

        System.out.println("Completed: " + collect.get(true) + " Not completed: " + collect.get(false));
    }
}
