package booking.backend.service.model;

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

  @UsernameUnique
  @Pattern(regexp = "^[a-zA-Z\\d]{5,32}$", message = "username.invalid")
  @NotNull(message = "username.is-null")
  private String username;

  @JsonProperty("first_name")
  @NotBlank(message = "firstName.is-blank")
  @Size(min = 1, max = 45, message = "firstName.out-of-range")
  private String firstName;

  @JsonProperty("last_name")
  @NotBlank(message = "lastName.is-blank")
  @Size(min = 1, max = 45, message = "lastName.out-of-range")
  private String lastName;

  @NotBlank(message = "password.is-blank")
  @Length(min= 12, message = "password.too-short")
  @Length(max= 60, message = "password.too-long")
  private String password;

  @JsonProperty("photo_path")
  private byte[] photo;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
