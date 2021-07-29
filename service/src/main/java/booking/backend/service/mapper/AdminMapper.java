package booking.backend.service.mapper;

import booking.backend.db.entity.AdminEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
  AdminDto fromEntity(AdminEntity adminEntity);
  AdminEntity toEntity(AdminDto aminDto);
//  List<AdminDto> fromEntities(AdminEntity adminEntity);
}
