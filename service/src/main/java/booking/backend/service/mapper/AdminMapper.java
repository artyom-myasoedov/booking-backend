package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import booking.backend.service.model.AdminDto;
import org.mapstruct.Mapper;

@Mapper
public interface AdminMapper {
  AdminDto fromEntity(AdminEntity adminEntity) ;

  AdminEntity toEntity(AdminDto aminDto);
//  List<AdminDto> fromEntities(AdminEntity adminEntity);
}
