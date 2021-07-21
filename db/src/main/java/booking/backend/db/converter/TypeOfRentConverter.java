package booking.backend.db.converter;

import booking.backend.db.entity.TypeOfRent;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeOfRentConverter implements AttributeConverter<TypeOfRent, Integer> {
  @Override
  public Integer convertToDatabaseColumn(TypeOfRent attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public TypeOfRent convertToEntityAttribute(Integer dbData) {
    return TypeOfRent.fromId(dbData).orElse(null);
  }
}
