package booking.backend.service.logic;

import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;

import java.util.List;

public interface PhotoService {

  List<PhotoDto> findByRoomId(Integer roomId);

  PhotoDto findById(Integer photoId);

  void deleteById(Integer photoId);

  PhotoDto updatePhoto(PhotoDto photo);

  PhotoDto addPhoto(PhotoCreateDto photo);
}
