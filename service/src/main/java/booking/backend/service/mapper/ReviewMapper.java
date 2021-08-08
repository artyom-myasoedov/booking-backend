package booking.backend.service.mapper;

import booking.backend.db.entity.ReviewDto;
import booking.backend.service.model.ReviewCreateDto;
import booking.backend.service.model.ReviewUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ReviewMapper {

  booking.backend.service.model.ReviewDto fromEntity(ReviewDto reviewDto);

  ReviewDto toEntity(ReviewCreateDto reviewDto);

  void toEntity(ReviewUpdateDto dto, @MappingTarget ReviewDto original);

  List<booking.backend.service.model.ReviewDto> fromEntities(Iterable<ReviewDto> reviewEntities);
}
