package booking.backend.db.repository;

import booking.backend.db.entity.RoomTypeOfRentId;
import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeOfRentRepository extends JpaRepository<TypeOfRentEntity, RoomTypeOfRentId> {


  Optional<TypeOfRentEntity> findById_TypeOfRentIdAndId_RoomId(TypeOfRent typeOfRentId, Integer roomId);

  void deleteById_TypeOfRentIdAndId_RoomId(TypeOfRent typeOfRentId, Integer roomId);

  List<TypeOfRentEntity> findById_RoomId(Integer roomId);
}
