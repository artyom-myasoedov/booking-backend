package booking.backend.security.handler;

import booking.backend.db.provider.UserSecurityProvider;
import booking.backend.service.security.ProfileMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookingSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

  private final UserSecurityProvider userProvider;
  private final ProfileMapper profileMapper;

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public BookingSuccessHandler(UserSecurityProvider userProvider, ProfileMapper profileMapper) {
    this.userProvider = userProvider;
    this.profileMapper = profileMapper;
  }

  @Override
  public void onAuthenticationSuccess(
    HttpServletRequest request,
    HttpServletResponse response,
    Authentication authentication
  ) throws IOException {
    var profile = profileMapper.toProfile(
      userProvider.findByUsername(authentication.getName()));

    var authorities = List.of(
      new SimpleGrantedAuthority("ROLE_" + profile.getRole().name()));
    SecurityContextHolder.getContext()
      .setAuthentication(
        new UsernamePasswordAuthenticationToken(profile, null, authorities));

    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(200);
    OBJECT_MAPPER.writeValue(response.getWriter(), profile);
  }
}
