package booking.backend.db.provider.impl;

import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.entity.TypeOfRentEntity;
import booking.backend.db.provider.TypeOfRentProvider;
import booking.backend.db.repository.TypeOfRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TypeOfRentProviderImpl implements TypeOfRentProvider {

  private final TypeOfRentRepository typeOfRentRepository;

  @Autowired
  public TypeOfRentProviderImpl(TypeOfRentRepository typeOfRentRepository) {
    this.typeOfRentRepository = typeOfRentRepository;
  }

  @Override
  public Optional<TypeOfRentEntity> findById(TypeOfRent typeOfRentId, Integer roomId) {
    return typeOfRentRepository.findById_TypeOfRentIdAndId_RoomId(typeOfRentId, roomId);
  }

  @Override
  public void deleteById(TypeOfRent typeOfRentId, Integer roomId) {
    typeOfRentRepository.deleteById_TypeOfRentIdAndId_RoomId(typeOfRentId, roomId);
  }

  @Override
  public List<TypeOfRentEntity> findByRoomId(Integer roomId) {
    return typeOfRentRepository.findById_RoomId(roomId);
  }

  @Override
  public TypeOfRentEntity save(TypeOfRentEntity typeOfRentEntity) {
    return typeOfRentRepository.save(typeOfRentEntity);
  }
}
