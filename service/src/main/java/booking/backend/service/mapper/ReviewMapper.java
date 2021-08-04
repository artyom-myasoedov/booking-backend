package booking.backend.service.mapper;

import booking.backend.db.entity.ReviewEntity;
import booking.backend.service.model.ReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

  ReviewDto fromEntity(ReviewEntity reviewEntity);

  ReviewEntity toEntity(ReviewDto reviewDto);

  List<ReviewDto> fromEntities(Iterable<ReviewEntity> reviewEntities);
}
