package booking.backend.db.provider;

import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRentEntity;

import java.util.List;
import java.util.Optional;

public interface TypeOfRentProvider {

  Optional<TypeOfRentEntity> findById(TypeOfRent typeOfRentId, Integer roomId);

  void deleteById(TypeOfRent typeOfRentId, Integer roomId);

  List<TypeOfRentEntity> findByRoomId(Integer roomId);

  TypeOfRentEntity save(TypeOfRentEntity typeOfRentEntity);

}
