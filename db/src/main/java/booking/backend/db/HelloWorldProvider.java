package booking.backend.db;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HelloWorldProvider {

  public String sayHello(String name) {
    if (name == null || name.isBlank()) {
      return "Hello, anonymous";
    }
    return "Hello, " + name;
  }
}
