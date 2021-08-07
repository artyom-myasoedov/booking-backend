package booking.backend.service.logic;


import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.service.model.PageDto;
import booking.backend.service.model.RoomCreateDto;
import booking.backend.service.model.RoomDto;

import java.math.BigDecimal;
import java.util.List;

public interface RoomService {

  RoomDto findById(Integer roomId);

  void deleteById(Integer roomId);

  RoomDto addRoom(RoomCreateDto room);

  RoomDto updateRoom(RoomDto room);

  PageDto<RoomDto> findByLandlordId(Integer landlordId, Integer pageSize, Integer pageNumber);

  PageDto<RoomDto> findAll(Integer pageSize, Integer pageNumber);

  PageDto<RoomDto> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, Double minRating,
    String startOfBooking, String endOfBooking, String sortOrder,
    String sortBy, Integer pageSize, Integer pageNumber);
}
