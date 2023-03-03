package module13;

import java.net.URI;
import java.util.List;

import static module13.Task2HTTP.lastPostId;

public class Task2HttpTest {
    public static void main(String[] args) throws Exception {
        Task2HTTP task2HTTP = new Task2HTTP();
      Integer num = lastPostId(URI.create("https://jsonplaceholder.typicode.com/users/1/posts"));
        task2HTTP.sendPostbyId(num);
    }
}
