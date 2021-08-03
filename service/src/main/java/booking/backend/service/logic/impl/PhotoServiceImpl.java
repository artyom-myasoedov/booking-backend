package booking.backend.service.logic.impl;

import booking.backend.db.repository.PhotoRepository;
import booking.backend.db.repository.RoomRepository;
import booking.backend.service.logic.PhotoService;
import booking.backend.service.mapper.PhotoMapper;
import booking.backend.service.mapper.RoomMapper;
import booking.backend.service.model.PhotoCreateDto;
import booking.backend.service.model.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

  private final PhotoMapper photoMapper;

  private final PhotoRepository photoRepository;

  @Autowired
  public PhotoServiceImpl(PhotoMapper photoMapper, PhotoRepository photoRepository) {
    this.photoMapper = photoMapper;
    this.photoRepository = photoRepository;
  }

  @Override
  public List<PhotoDto> findByRoomId(Integer roomId) {
    return null;
  }

  @Override
  public PhotoDto findById(Integer photoId) {
    return null;
  }

  @Override
  public void deleteById(Integer photoId) {

  }

  @Override
  public PhotoDto updatePhoto(PhotoDto photo) {
    return null;
  }

  @Override
  public PhotoDto addPhoto(PhotoCreateDto photo) {
    return null;
  }
}
