package booking.backend.db.repository;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface RoomCustomRepository {

  Page<RoomEntity> findByLandlordId(Integer landlordId, Pageable pageable, String sortBy, String sortOrder);

  Page<RoomEntity> findAllRooms(Pageable pageable, String sortBy, String sortOrder);

  Page<RoomEntity> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, BigDecimal minRating,
    Instant startOfBooking, Instant endOfBooking, String sortOrder,
    String sortBy, Pageable pageable);

}
