package booking.backend.db.repository.impl;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.db.repository.RoomCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class RoomCustomRepositoryImpl implements RoomCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;


  @Override
  public Page<RoomEntity> findByLandlordId(Integer landlordId, Pageable pageable) {
    return null;
  }

  @Override
  public Optional<RoomEntity> findByRoomId(Integer roomId) {

    return null;
  }

  @Override
  public Page<RoomEntity> findAllRooms(Pageable pageable) {
    return null;
  }

  @Override
  public Page<RoomEntity> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, Double minRating,
    String startOfBooking, String endOfBooking, String sortOrder,
    String sortBy, Pageable pageable) {
    return null;
  }
}
