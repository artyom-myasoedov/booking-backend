package booking.backend.service.logic;


import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;

import java.util.List;

public interface RoomService {

  RoomDto findById(Integer roomId);

  void deleteById(Integer roomId);

  RoomDto addRoom(RoomCreateDto room);

  RoomDto updateRoom(RoomDto room);

  List<RoomDto> findByLandlordId(Integer landlordId);

  List<RoomDto> findAll();
}
