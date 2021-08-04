package booking.backend.service.model;

import booking.backend.db.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
  @JsonProperty("user_id")
  private Integer id;

  @JsonProperty("username")
  private String username;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("photo")
  private byte[] photoPath;

  @JsonProperty("phone_number")
  private String phoneNumber;

  @JsonProperty("email")
  private String email;

  @JsonProperty("role")
  private Role role;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public byte[] getPhotoPath() {
    return photoPath;
  }

  public void setPhotoPath(byte[] photoPath) {
    this.photoPath = photoPath;
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
}
