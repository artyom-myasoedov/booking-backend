package booking.backend.db.provider.impl;

import booking.backend.db.entity.PhotoEntity;
import booking.backend.db.provider.PhotoProvider;
import booking.backend.db.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhotoProviderImpl implements PhotoProvider {

  private final PhotoRepository photoRepository;

  @Autowired
  public PhotoProviderImpl(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

  @Override
  public List<PhotoEntity> findByRoomId(Integer roomId) {
    return photoRepository.findByRoomId(roomId);
  }

  @Override
  public Optional<PhotoEntity> findById(Integer photoId) {
    return photoRepository.findById(photoId);
  }

  @Override
  public void deleteById(Integer photoId) {
    photoRepository.deleteById(photoId);
  }

  @Override
  public PhotoEntity save(PhotoEntity photoEntity) {
    return photoRepository.save(photoEntity);
  }
}
