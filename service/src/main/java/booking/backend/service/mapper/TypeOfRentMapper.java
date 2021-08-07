package booking.backend.service.mapper;

import booking.backend.db.entity.TypeOfRentEntity;
import booking.backend.service.model.TypeOfRentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TypeOfRentMapper {

  @Mapping(target = "roomId", source = "entity.id.roomId")
  @Mapping(target = "typeOfRent", source = "entity.id.typeOfRentId")
  TypeOfRentDto fromEntity(TypeOfRentEntity entity);

  @Mapping(source = "roomId", target = "id.roomId")
  @Mapping(source = "typeOfRent", target = "id.typeOfRentId")
  TypeOfRentEntity toEntity(TypeOfRentDto dto);

  List<TypeOfRentDto> fromEntities(Iterable<TypeOfRentEntity> entities);

  List<TypeOfRentEntity> toEntities(Iterable<TypeOfRentDto> entities);
}
