package booking.backend.service.mapper;

import booking.backend.db.entity.RoomEntity;
import booking.backend.service.model.RoomDto;
import booking.backend.service.model.RoomWithReviewsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {
  TypeOfRentMapper.class,
  EquipmentMapper.class,
  ReviewMapper.class,
  UserMapper.class
})
public interface RoomMapper {

  RoomDto fromEntity(RoomEntity entity);

  RoomWithReviewsDto fromEntityWithReviews(RoomEntity entity);

  RoomEntity toEntity(RoomDto dto);

  List<RoomWithReviewsDto> fromEntitiesWithReviews(Iterable<RoomEntity> entities);

  List<RoomDto> fromEntities(Iterable<RoomEntity> entities);
}
