package booking.backend.db.converter;

import booking.backend.db.entity.RoomStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoomStatusConverter implements AttributeConverter<RoomStatus, Integer> {
  @Override
  public Integer convertToDatabaseColumn(RoomStatus attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public RoomStatus convertToEntityAttribute(Integer dbData) {
    return RoomStatus.fromId(dbData).orElse(null);
  }

}
