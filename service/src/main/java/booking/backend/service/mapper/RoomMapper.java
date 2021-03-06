package booking.backend.service.mapper;

import booking.backend.db.entity.RoomEntity;
import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;
import booking.backend.service.model.RoomWithReviewsDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
  (uses = {
    EquipmentMapper.class,
    RoomReviewMapper.class,
    UserMapper.class,
    PhotoMapper.class,
    TypeOfRentMapper.class
  })
public interface RoomMapper {

  @Named("without-reviews")
  RoomDto fromEntity(RoomEntity entity);

  @Named("with-reviews")
  RoomWithReviewsDto fromEntityWithReviews(RoomEntity entity);

  @Mapping(target = "reviews", ignore = true)
  RoomEntity toEntity(RoomDto dto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "roomStatus", ignore = true)
  @Mapping(target = "reviews", ignore = true)
  RoomEntity toEntity(RoomCreateDto dto);

  @IterableMapping(qualifiedByName = "with-reviews")
  List<RoomWithReviewsDto> fromEntitiesWithReviews(Iterable<RoomEntity> entities);

  @IterableMapping(qualifiedByName = "without-reviews")
  List<RoomDto> fromEntities(Iterable<RoomEntity> entities);
}
