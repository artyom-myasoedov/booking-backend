package booking.backend.service.logic.impl;

import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.db.provider.RoomProvider;
import booking.backend.service.logic.RoomService;
import booking.backend.service.mapper.RoomMapper;
import booking.backend.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

  private final RoomMapper roomMapper;

  private final RoomProvider roomProvider;

  @Autowired
  public RoomServiceImpl(RoomMapper roomMapper, RoomProvider roomProvider) {
    this.roomMapper = roomMapper;
    this.roomProvider = roomProvider;
  }

  @Override
  public RoomDto findById(Integer roomId) {
    return roomProvider.findById(roomId)
      .map(roomMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public void deleteById(Integer roomId) {
    roomProvider.deleteById(roomId);
  }

  @Override
  public RoomDto addRoom(RoomCreateDto room) {
    return Optional.ofNullable(room)
      .map(roomMapper::toEntity)
      .map(roomProvider::save)
      .map(roomMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public RoomDto updateRoom(RoomDto room) {
    var roomEntity = roomProvider.findById(room.getId())
      .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    //() -> new EntityNotFoundException(equipment.getEquipmentId(), "Equipment")

    return Optional.of(room)
      .map(roomMapper::toEntity)
      .map(roomProvider::save)
      .map(roomMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public PageDto<RoomDto> findByLandlordId(Integer landlordId, Integer pageSize, Integer pageNumber) {
    var values = roomProvider
      .findByLandlord_Id(landlordId,
        Pageable.ofSize(pageSize).withPage(pageNumber)).map(roomMapper::fromEntity);

    return ImmutablePageDto.<RoomDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<RoomDto> findAll() {
    return null;
  }

  @Override
  public PageDto<RoomDto> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, Double minRating,
    String startOfBooking, String endOfBooking, String sortOrder,
    String sortBy, Integer pageSize, Integer pageNumber) {


    var values = roomProvider.findByCriteria(
      minSquare, maxSquare, minNumberOfPeople,
      maxNumberOfPeople, minRentalPeriod, typesOfRent,
      typesOfRoom, minPrice, maxPrice,
      addressLike, landlordUsernameLike, minRating,
      startOfBooking, endOfBooking, sortOrder,
      sortBy, Pageable.ofSize(pageSize).withPage(pageNumber)).map(roomMapper::fromEntity);

    return ImmutablePageDto.<RoomDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
