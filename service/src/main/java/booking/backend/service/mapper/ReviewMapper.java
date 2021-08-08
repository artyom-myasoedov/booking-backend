package booking.backend.service.mapper;

import booking.backend.db.entity.ReviewEntity;
import booking.backend.service.model.ReviewCreateDto;
import booking.backend.service.model.ReviewDto;
import booking.backend.service.model.ReviewUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper
public interface ReviewMapper {

  ReviewDto fromEntity(ReviewEntity reviewEntity);

  @Mapping(target = "id", ignore = true)
  ReviewEntity toEntity(ReviewCreateDto reviewDto);

  void toEntity(ReviewUpdateDto dto, @MappingTarget ReviewEntity original);

  List<ReviewDto> fromEntities(Iterable<ReviewEntity> reviewEntities);
}
