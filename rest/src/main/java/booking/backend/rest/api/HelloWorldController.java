package booking.backend.rest.api;

import booking.backend.db.HelloWorldProvider;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  private final HelloWorldProvider provider;

  public HelloWorldController(HelloWorldProvider provider) {
    this.provider = provider;
  }

  @GetMapping("/world")
  public String helloWorld(@RequestParam(name = "name", required = false) String name) {
    return provider.sayHello(name);
  }

  @GetMapping("/{name}")
  public String helloZ(
    @PathVariable("name") String name
  ) {
    return provider.sayHello(name);
  }
}
