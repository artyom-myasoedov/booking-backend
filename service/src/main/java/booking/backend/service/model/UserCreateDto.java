package booking.backend.service.model;

import booking.backend.commons.Role;
import booking.backend.service.validation.UsernameUnique;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class UserCreateDto {
  @UsernameUnique
  @Pattern(regexp = "^[a-zA-Z\\d]{5,32}$", message = "username.invalid")
  @NotNull(message = "username.is-null")
  @JsonProperty("username")
  private String username;

  @NotBlank(message = "password.is-blank")
  @Min(value = 12, message = "password.too-short")
  @Max(value = 128, message = "password.too-long")
  @JsonProperty("password")
  private String password;

  @NotBlank(message = "firstName.is-blank")
  @Size(min = 1, max = 45, message = "firstName.out-of-range")
  @JsonProperty("first_name")
  private String firstName;

  @Size(min = 1, max = 45, message = "lastName.out-of-range")
  @NotBlank(message = "lastName.is-blank")
  @JsonProperty("last_name")
  private String lastName;

  @NotNull(message = "role.is-null")
  @JsonProperty("role")
  private Role role;

  @JsonProperty("photo")
  private byte[] photo;

  @JsonProperty("phone_number")
  private String phoneNumber;

  @JsonProperty("email")
  private String email;
}
