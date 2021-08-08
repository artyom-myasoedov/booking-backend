package booking.backend.service.model;

import booking.backend.commons.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class AdminDto {
  private Integer id;

  private String username;

  private String firstName;

  private String lastName;

  private byte[] photo;

  private String phoneNumber;

  private String email;

  private Role role;

  private BigDecimal userRating;

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

  public BigDecimal getUserRating() {
    return userRating;
  }

  public void setUserRating(BigDecimal userRating) {
    this.userRating = userRating;
  }
}
