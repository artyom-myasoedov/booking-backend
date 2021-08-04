package booking.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "booking.backend")
public class BookingApplication {
  public static void main(String[] args) {
    SpringApplication.run(BookingApplication.class, args);
  }
}
