package booking.backend.service.logic;

import booking.backend.service.model.TypeOfRentDto;

import java.util.List;

public interface TypeOfRentService {

  TypeOfRentDto findById(Integer typeOfRentId, Integer roomId);

  void deleteById(Integer typeOfRentId, Integer roomId);

  TypeOfRentDto updateTypeOfRent(TypeOfRentDto typeOfRent);

  TypeOfRentDto addTypeOfRent(TypeOfRentDto typeOfRent);

  List<TypeOfRentDto> findByRoomId(Integer roomId);
}
