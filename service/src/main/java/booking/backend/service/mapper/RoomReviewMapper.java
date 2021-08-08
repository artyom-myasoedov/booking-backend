package booking.backend.service.mapper;

import booking.backend.db.entity.RoomReviewEntity;
import booking.backend.service.model.RoomReviewCreateDto;
import booking.backend.service.model.RoomReviewDto;
import booking.backend.service.model.RoomReviewUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper
public interface RoomReviewMapper {

  RoomReviewDto fromEntity(RoomReviewEntity roomReviewEntity);

  @Mapping(target = "id", ignore = true)
  RoomReviewEntity toEntity(RoomReviewCreateDto reviewDto);

  void toEntity(RoomReviewUpdateDto dto, @MappingTarget RoomReviewEntity original);

  List<RoomReviewDto> fromEntities(Iterable<RoomReviewEntity> reviewEntities);
}
