package booking.backend.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminCreateDto {

  private String username;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

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

  public byte[] getPhotoPath() {
    return photo;
  }

  public void setPhotoPath(byte[] photoPath) {
    this.photo = photoPath;
  }
}
