package booking.backend.db.repository.impl;

import booking.backend.db.entity.RoomEntity;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRoom;
import booking.backend.db.repository.RoomCustomRepository;
import org.hibernate.annotations.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


public class RoomCustomRepositoryImpl implements RoomCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;


  @Override
  public Page<RoomEntity> findByLandlordId(Integer landlordId, Pageable pageable, String sortBy, String sortOrder) {
    List<RoomEntity> rooms = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r.landlord l " +
        "left join fetch r.equipments " +
        "where l.id = :lId", RoomEntity.class)
      .setParameter("lId", landlordId)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();

    List<RoomEntity> rooms2 = getRooms(rooms, "typesOfRent ");

    rooms = getRooms(rooms2, "reviews ");

    rooms2 = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r.photos " +
        "where r in :rooms " +
        "order by r." + sortBy + " " + sortOrder, RoomEntity.class)
      .setParameter("rooms", rooms)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();


    return new PageImpl<>(rooms2, pageable, rooms2.size());
  }

  private List<RoomEntity> getRooms(List<RoomEntity> rooms, String s) {
    return entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r." + s +
        " where r in :rooms", RoomEntity.class)
      .setParameter("rooms", rooms)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();
  }

  @Override
  public Page<RoomEntity> findAllRooms(Pageable pageable, String sortBy, String sortOrder) {
    List<RoomEntity> rooms = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r.landlord " +
        "left join fetch r.equipments ", RoomEntity.class)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();

    List<RoomEntity> rooms2 = getRooms(rooms, "typesOfRent ");

    rooms = getRooms(rooms2, "reviews ");

    rooms2 = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r.photos " +
        "where r in :rooms " +
        "order by r." + sortBy + " " + sortOrder, RoomEntity.class)
      .setParameter("rooms", rooms)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();


    return new PageImpl<>(rooms2, pageable, rooms2.size());
  }

  @Override
  public Page<RoomEntity> findByCriteria(
    Integer minSquare, Integer maxSquare, Integer minNumberOfPeople,
    Integer maxNumberOfPeople, Integer minRentalPeriod, List<TypeOfRent> typesOfRent,
    List<TypeOfRoom> typesOfRoom, BigDecimal minPrice, BigDecimal maxPrice,
    String addressLike, String landlordUsernameLike, BigDecimal minRating,
    Instant startOfBooking, Instant endOfBooking, String sortOrder,
    String sortBy, Pageable pageable) {

    List<RoomEntity> rooms = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "left join fetch r.landlord l " +
        "left join fetch r.equipments e " +
        "where r.square between :minSquare AND :maxSquare " +
        "AND r.capacity between :minCapacity AND :maxCapacity " +
        "AND r.minRentalPeriod >= :minRentalPeriod " +
        "AND r.typeOfRoom in :typesOfRoom " +
        "AND r.rating >= :minRating " +
        "AND r.address like concat('%', :addresLike, '%') " +
        "AND l.username like concat('%', :username, '%') " +
        "", RoomEntity.class)
      .setParameter("minSquare", minSquare)
      .setParameter("maxSquare", maxSquare)
      .setParameter("minCapacity", minNumberOfPeople)
      .setParameter("maxCapacity", maxNumberOfPeople)
      .setParameter("minRentalPeriod", minRentalPeriod)
      .setParameter("typesOfRoom", typesOfRoom)
      .setParameter("minRating", minRating)
      .setParameter("addresLike", addressLike)
      .setParameter("username", landlordUsernameLike)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .getResultList();

    List<RoomEntity> rooms2 = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "" +
        "join fetch r.typesOfRent t " +
        "where  t.typeOfRent in :typesOfRent " +
        "AND t.price between :minPrice AND :maxPrice " +
        "AND r in :rooms", RoomEntity.class)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .setParameter("typesOfRent", typesOfRent)
      .setParameter("minPrice", minPrice)
      .setParameter("maxPrice", maxPrice)
      .setParameter("rooms", rooms)
      .getResultList();

    startOfBooking = startOfBooking == null ? Instant.now() : startOfBooking;
    endOfBooking = endOfBooking == null ? Instant.now().plusSeconds(10) : endOfBooking;


    rooms = entityManager
      .createQuery("select distinct r " +
        "from rooms r " +
        "where " +
        "(select count(b) from bookings b " +
        "where b.room.id = r.id " +
        "AND b.rentalStartDate ) = 0 " +
        "AND r in :rooms", RoomEntity.class)
      .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
      .setParameter("starting", startOfBooking)
      .setParameter("ending", endOfBooking)
      .setParameter("rooms", rooms2)
      .getResultList();


    return new PageImpl<>(rooms, pageable, rooms.size());
  }
}
