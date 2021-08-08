package booking.backend.service.logic.impl;

import booking.backend.db.provider.PhotoProvider;
import booking.backend.service.logic.PhotoService;
import booking.backend.service.mapper.PhotoMapper;
import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@Validated
public class PhotoServiceImpl implements PhotoService {

  private final PhotoMapper photoMapper;

  private final PhotoProvider photoProvider;

  @Autowired
  public PhotoServiceImpl(PhotoMapper photoMapper, PhotoProvider photoProvider) {
    this.photoMapper = photoMapper;
    this.photoProvider = photoProvider;
  }

  @Override
  public List<PhotoDto> findByRoomId(Integer roomId) {
    return photoMapper.fromEntities(
      photoProvider.findByRoomId(roomId));
  }

  @Override
  public PhotoDto findById(Integer photoId) {
    return photoProvider.findById(photoId)
      .map(photoMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public void deleteById(Integer photoId) {
    photoProvider.deleteById(photoId);
  }

  @Override
  public PhotoDto updatePhoto(PhotoDto photo) {
    var photoEntity = photoProvider.findById(photo.getRoomPhotoId())
      .orElseThrow(() -> new IllegalArgumentException("Photo not found"));
    //() -> new EntityNotFoundException(equipment.getEquipmentId(), "Equipment")

    return Optional.of(photo)
      .map(photoMapper::toEntity)
      .map(photoProvider::save)
      .map(photoMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public PhotoDto addPhoto(PhotoCreateDto photo) {
    return Optional.ofNullable(photo)
      .map(photoMapper::toEntity)
      .map(photoProvider::save)
      .map(photoMapper::fromEntity)
      .orElseThrow();
  }
}
