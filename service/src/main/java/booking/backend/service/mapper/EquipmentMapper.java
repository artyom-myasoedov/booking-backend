package booking.backend.service.mapper;

import booking.backend.db.entity.EquipmentEntity;
import booking.backend.service.model.EquipmentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EquipmentMapper {

  EquipmentDto fromEntity(EquipmentEntity entity);

  EquipmentEntity toEntity(EquipmentDto dto);

  List<EquipmentDto> fromEntities(Iterable<EquipmentEntity> entities);
}
