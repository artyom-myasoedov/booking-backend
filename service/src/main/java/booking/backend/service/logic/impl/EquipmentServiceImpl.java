package booking.backend.service.logic.impl;

import booking.backend.db.provider.EquipmentProvider;
import booking.backend.service.logic.EquipmentService;
import booking.backend.service.mapper.EquipmentMapper;
import booking.backend.service.model.EquipmentCreateDto;
import booking.backend.service.model.EquipmentDto;
import booking.backend.service.model.ImmutablePageDto;
import booking.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Transactional
@Validated
public class EquipmentServiceImpl implements EquipmentService {

  private final EquipmentMapper equipmentMapper;

  private final EquipmentProvider equipmentProvider;

  @Autowired
  public EquipmentServiceImpl(EquipmentMapper equipmentMapper, EquipmentProvider equipmentRepository) {
    this.equipmentMapper = equipmentMapper;
    this.equipmentProvider = equipmentRepository;
  }

  @Override
  public EquipmentDto findById(Integer equipmentId) {
    return equipmentProvider.findById(equipmentId)
      .map(equipmentMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public void deleteById(Integer equipmentId) {
    equipmentProvider.deleteById(equipmentId);
  }

  @Override
  public PageDto<EquipmentDto> findByRoomId(Integer roomId, Integer pageSize, Integer pageNumber) {
    var values = equipmentProvider
      .findByRoomId(roomId,
        Pageable.ofSize(pageSize).withPage(pageNumber)).map(equipmentMapper::fromEntity);

    return ImmutablePageDto.<EquipmentDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public EquipmentDto updateEquipment(EquipmentDto equipment) {
    var equipmentEntity = equipmentProvider.findById(equipment.getEquipmentId())
      .orElseThrow(() -> new IllegalArgumentException("Equipment not found"));
    //() -> new EntityNotFoundException(equipment.getEquipmentId(), "Equipment")

    return Optional.ofNullable(equipment)
      .map(equipmentMapper::toEntity)
      .map(equipmentProvider::save)
      .map(equipmentMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public EquipmentDto addEquipment(EquipmentCreateDto equipment) {
    return Optional.ofNullable(equipment)
      .map(equipmentMapper::toEntity)
      .map(equipmentProvider::save)
      .map(equipmentMapper::fromEntity)
      .orElseThrow();
  }
}
