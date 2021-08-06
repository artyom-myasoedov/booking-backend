package booking.backend.db.provider;

import booking.backend.db.entity.PhotoEntity;

import java.util.List;
import java.util.Optional;

public interface PhotoProvider {

  List<PhotoEntity> findByRoomId(Integer roomId);

  Optional<PhotoEntity> findById(Integer photoId);

  void deleteById(Integer photoId);

  PhotoEntity save(PhotoEntity photoEntity);
}
