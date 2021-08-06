package booking.backend.service.logic.impl;

import booking.backend.db.entity.TypeOfRent;
import booking.backend.db.provider.TypeOfRentProvider;
import booking.backend.service.logic.TypeOfRentService;
import booking.backend.service.mapper.TypeOfRentMapper;
import booking.backend.service.model.TypeOfRentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeOfRentServiceImpl implements TypeOfRentService {

  private final TypeOfRentMapper typeOfRentMapper;

  private final TypeOfRentProvider typeOfRentProvider;

  @Autowired
  public TypeOfRentServiceImpl(TypeOfRentMapper typeOfRentMapper, TypeOfRentProvider typeOfRentProvider) {
    this.typeOfRentMapper = typeOfRentMapper;
    this.typeOfRentProvider = typeOfRentProvider;
  }

  @Override
  public TypeOfRentDto findById(Integer typeOfRentId, Integer roomId) {
    return typeOfRentProvider.findById(TypeOfRent.fromId(typeOfRentId).orElse(null), roomId)
      .map(typeOfRentMapper::fromEntity).orElseThrow();
  }

  @Override
  public void deleteById(Integer typeOfRentId, Integer roomId) {
    typeOfRentProvider.deleteById(TypeOfRent.fromId(typeOfRentId).orElse(null), roomId);
  }

  @Override
  public TypeOfRentDto updateTypeOfRent(TypeOfRentDto typeOfRent) {
    var typeOfRentEntity = typeOfRentProvider.findById(typeOfRent.getTypeOfRent(), typeOfRent.getRoomId())
      .orElseThrow(() -> new IllegalArgumentException("TypeOfRent not found"));
    //() -> new EntityNotFoundException(equipment.getEquipmentId(), "Equipment")

    return Optional.of(typeOfRent)
      .map(typeOfRentMapper::toEntity)
      .map(typeOfRentProvider::save)
      .map(typeOfRentMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public TypeOfRentDto addTypeOfRent(TypeOfRentDto typeOfRent) {
    return Optional.ofNullable(typeOfRent)
      .map(typeOfRentMapper::toEntity)
      .map(typeOfRentProvider::save)
      .map(typeOfRentMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public List<TypeOfRentDto> findByRoomId(Integer roomId) {
    return typeOfRentMapper.fromEntities(
      typeOfRentProvider.findByRoomId(roomId));
  }
}
