package booking.backend.service.mapper;

import org.mapstruct.Mapper;

@Mapper
        (uses = {
                TypeOfRentMapper.class,
                EquipmentMapper.class,
                ReviewMapper.class,
                UserMapper.class
        })
public interface RoomMapper {

//  RoomDto fromEntity(RoomEntity entity);
//
//  RoomWithReviewsDto fromEntityWithReviews(RoomEntity entity);
//
//  RoomEntity toEntity(RoomDto dto);
//
//  List<RoomWithReviewsDto> fromEntitiesWithReviews(Iterable<RoomEntity> entities);
//
//  List<RoomDto> fromEntities(Iterable<RoomEntity> entities);
}
