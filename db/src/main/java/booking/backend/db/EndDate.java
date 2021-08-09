package booking.backend.db;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class EndDate {
  public static Instant calculate(Instant startDate, Integer hours){
    return startDate.plusMillis(TimeUnit.HOURS.toMillis(hours));
  }
}
