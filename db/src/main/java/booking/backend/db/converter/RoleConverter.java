package booking.backend.db.converter;

import booking.backend.db.entity.Role;

import javax.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<Role, Integer> {
  @Override
  public Integer convertToDatabaseColumn(Role attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public Role convertToEntityAttribute(Integer dbData) {
    return Role.fromId(dbData).orElse(null);
  }
}
