package booking.backend.service.logic.impl;

import booking.backend.db.repository.RoomRepository;
import booking.backend.service.logic.RoomService;
import booking.backend.service.mapper.RoomMapper;
import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

  private final RoomMapper roomMapper;

  private final RoomRepository roomRepository;

  @Autowired
  public RoomServiceImpl(RoomMapper roomMapper, RoomRepository roomRepository) {
    this.roomMapper = roomMapper;
    this.roomRepository = roomRepository;
  }

  @Override
  public RoomDto findById(Integer roomId) {
    return null;
  }

  @Override
  public void deleteById(Integer roomId) {

  }

  @Override
  public RoomDto addRoom(RoomCreateDto room) {
    return null;
  }

  @Override
  public RoomDto updateRoom(RoomDto room) {
    return null;
  }

  @Override
  public List<RoomDto> findByLandlordId(Integer landlordId) {
    return null;
  }

  @Override
  public List<RoomDto> findAll() {
    return null;
  }
}
