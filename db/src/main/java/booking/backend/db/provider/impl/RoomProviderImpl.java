package booking.backend.db.provider.impl;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.db.provider.RoomProvider;
import booking.backend.db.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class RoomProviderImpl implements RoomProvider {

  private final RoomRepository roomRepository;

  @Autowired
  public RoomProviderImpl(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public Optional<RoomEntity> findById(Integer roomId) {
    return roomRepository.findById(roomId);
  }

  @Override
  public void deleteById(Integer roomId) {
    roomRepository.deleteById(roomId);
  }

  @Override
  public Page<RoomEntity> findAll(Pageable pageable, String sortBy, String sortOrder) {
    return roomRepository.findAllRooms(pageable, sortBy, sortOrder);
  }

  @Override
  public RoomEntity save(RoomEntity roomEntity) {
    return roomRepository.save(roomEntity);
  }

  @Override
  public Page<RoomEntity> findByLandlord_Id(Integer landlordId, Pageable pageable, String sortBy, String sortOrder) {
    return roomRepository.findByLandlordId(landlordId, pageable, sortBy, sortOrder);
  }

  @Override
  public Page<RoomEntity> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, BigDecimal minRating,
    Instant startOfBooking, Instant endOfBooking, String sortOrder,
    String sortBy, Pageable pageable) {
    return roomRepository.findByCriteria(
      minSquare, maxSquare, minNumberOfPeople,
      maxNumberOfPeople, minRentalPeriod, typesOfRent,
      typesOfRoom, minPrice, maxPrice,
      addressLike, landlordUsernameLike, minRating,
      startOfBooking, endOfBooking, sortOrder,
      sortBy, pageable
    );
  }
}
