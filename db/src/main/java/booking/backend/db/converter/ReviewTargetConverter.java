package booking.backend.db.converter;

import booking.backend.db.entity.ReviewTarget;

import javax.persistence.AttributeConverter;

public class ReviewTargetConverter implements AttributeConverter<ReviewTarget, Integer> {
  @Override
  public Integer convertToDatabaseColumn(ReviewTarget attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public ReviewTarget convertToEntityAttribute(Integer dbData) {
    return ReviewTarget.fromId(dbData).orElse(null);
  }
}
