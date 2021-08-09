package booking.backend.service.mapper;

import booking.backend.db.entity.UserReviewEntity;
import booking.backend.service.model.UserReviewCreateDto;
import booking.backend.service.model.UserReviewDto;
import booking.backend.service.model.UserReviewUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper
public interface UserReviewMapper {

  UserReviewDto fromEntity(UserReviewEntity userReviewEntity);

  @Mapping(target = "id", ignore = true)
  UserReviewEntity toEntity(UserReviewCreateDto reviewDto);

  void toEntity(UserReviewUpdateDto dto, @MappingTarget UserReviewEntity original);

  List<UserReviewDto> fromEntities(Iterable<UserReviewEntity> reviewEntities);
}
