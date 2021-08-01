package booking.backend.service.mapper;

import booking.backend.db.entity.EquipmentEntity;
import booking.backend.db.entity.TypeOfRentEntity;
import booking.backend.service.model.EquipmentDto;
import booking.backend.service.model.TypeOfRentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TypeOfRentMapper {

  TypeOfRentDto fromEntity(TypeOfRentEntity entity);

  TypeOfRentEntity toEntity(TypeOfRentDto dto);

  List<TypeOfRentDto> fromEntitiesWithReviews(Iterable<TypeOfRentEntity> entities);
}
