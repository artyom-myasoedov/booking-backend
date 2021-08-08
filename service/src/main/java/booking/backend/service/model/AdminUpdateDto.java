package booking.backend.service.model;

import booking.backend.commons.Role;
import booking.backend.service.validation.UsernameUnique;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminUpdateDto {
  @NotNull(message = "id.is-null")
  private Integer id;

  @Pattern(regexp = "^[a-zA-Z\\d]{5,32}$", message = "username.invalid")
  @NotNull(message = "username.is-null")
  private String username;

  @NotBlank(message = "password.is-blank")
  @Length(min = 12, message = "password.too-short")
  @Length(max = 60, message = "password.too-long")
  private String password;

  @NotBlank(message = "firstName.is-blank")
  @Size(min = 1, max = 45, message = "firstName.out-of-range")
  private String firstName;

  @NotBlank(message = "lastName.is-blank")
  @Size(min = 1, max = 45, message = "lastName.out-of-range")
  private String lastName;

  @NotNull(message = "role.is-null")
  private Role role;

  private byte[] photo;

  @NotBlank(message = "phoneNumber.is-blank")
  private String phoneNumber;

  @NotBlank(message = "email.is-blank")
  @Pattern(regexp = "^.+@.+\\..+$", message = "email.invalid")
  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer userId) {
    this.id = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
