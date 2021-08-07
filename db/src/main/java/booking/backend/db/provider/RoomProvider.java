package booking.backend.db.provider;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RoomProvider {

  Optional<RoomEntity> findById(Integer roomId);

  void deleteById(Integer roomId);

  Page<RoomEntity> findAll();

  RoomEntity save(RoomEntity roomEntity);

  Page<RoomEntity> findByLandlord_Id(Integer landlordId, Pageable withPage);

  Page<RoomEntity> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, Double minRating,
    String startOfBooking, String endOfBooking, String sortOrder,
    String sortBy, Pageable pageable);
}
