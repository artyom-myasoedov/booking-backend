package booking.backend.service.logic.impl;

import booking.backend.db.repository.RoomRepository;
import booking.backend.db.repository.TypeOfRentRepository;
import booking.backend.service.logic.TypeOfRentService;
import booking.backend.service.mapper.RoomMapper;
import booking.backend.service.mapper.TypeOfRentMapper;
import booking.backend.service.model.TypeOfRentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfRentServiceImpl implements TypeOfRentService {

  private final TypeOfRentMapper typeOfRentMapper;

  private final TypeOfRentRepository typeOfRentRepository;

  @Autowired
  public TypeOfRentServiceImpl(TypeOfRentMapper typeOfRentMapper, TypeOfRentRepository typeOfRentRepository) {
    this.typeOfRentMapper = typeOfRentMapper;
    this.typeOfRentRepository = typeOfRentRepository;
  }

  @Override
  public TypeOfRentDto findById(Integer typeOfRentId, Integer roomId) {
    return null;
  }

  @Override
  public void deleteById(Integer typeOfRentId, Integer roomId) {

  }

  @Override
  public TypeOfRentDto updateTypeOfRent(TypeOfRentDto typeOfRent) {
    return null;
  }

  @Override
  public TypeOfRentDto addTypeOfRent(TypeOfRentDto typeOfRent) {
    return null;
  }

  @Override
  public List<TypeOfRentDto> findByRoomId(Integer roomId) {
    return null;
  }
}
