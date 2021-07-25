package booking.backend.db.converter;

import booking.backend.db.entity.TypeOfRoom;

import javax.persistence.AttributeConverter;

public class TypeOfRoomConverter implements AttributeConverter<TypeOfRoom, Integer> {
  @Override
  public Integer convertToDatabaseColumn(TypeOfRoom attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public TypeOfRoom convertToEntityAttribute(Integer dbData) {
    return TypeOfRoom.fromId(dbData).orElse(null);
  }

}
