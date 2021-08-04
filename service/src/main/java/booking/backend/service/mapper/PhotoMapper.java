package booking.backend.service.mapper;

import booking.backend.db.entity.PhotoEntity;
import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PhotoMapper {

  PhotoDto fromEntity(PhotoEntity entity);

  PhotoEntity toEntity(PhotoDto dto);

  @Mapping(target = "roomPhotoId", ignore = true)
  PhotoEntity toEntity(PhotoCreateDto dto);

  List<PhotoDto> fromEntities(Iterable<PhotoEntity> entities);
}
