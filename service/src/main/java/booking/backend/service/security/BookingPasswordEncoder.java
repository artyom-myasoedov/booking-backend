package booking.backend.service.security;

public interface BookingPasswordEncoder {

  String encode(CharSequence charSequence);
}
