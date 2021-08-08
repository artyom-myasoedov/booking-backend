package booking.backend.service.logic.impl;

import booking.backend.db.provider.BookingProvider;
import booking.backend.service.logic.BookingService;
import booking.backend.service.mapper.BookingMapper;
import booking.backend.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
  private final BookingMapper bookingMapper;

  private final BookingProvider bookingProvider;

  @Autowired
  public BookingServiceImpl(BookingMapper bookingMapper, BookingProvider bookingProvider) {
    this.bookingMapper = bookingMapper;
    this.bookingProvider = bookingProvider;
  }

  @Override
  public BookingDto createBooking(BookingCreateDto bookingDto) {
    return
            Optional.ofNullable(bookingDto)
                    .map(bookingMapper::toEntity)
                    .map(bookingProvider::save)
                    .map(bookingMapper::fromEntity)
                    .orElseThrow();
  }

  @Override
  public BookingDto updateBooking(BookingDto bookingDto) {
    var booking = bookingProvider.findById(bookingDto.getId())
      .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

    return Optional.of(bookingDto)
      .map(bookingMapper::toEntity)
      .map(bookingProvider::save)
      .map(bookingMapper::fromEntity)
      .orElseThrow();
  }

  @Override
  public BookingDto findById(Integer id) {
    return bookingProvider.findById(id)
      .map(bookingMapper::fromEntity)
      .orElse(null);
  }

  @Override
  public void deleteBookingById(Integer id) {
    bookingProvider.deleteById(id);
  }

  @Override
  public PageDto<BookingDto> find(String search, Integer pageSize, Integer pageNumber) {
    var values =  bookingProvider.findByUserName(
      search,
      Pageable
        .ofSize(pageSize)
        .withPage(pageNumber)
    )
      .map(bookingMapper::fromEntity);

    return ImmutablePageDto.<BookingDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public List<BookingDto> findAll() {
    return bookingMapper.fromEntities(bookingProvider.findAll());
  }

  @Override
  public PageDto<BookingDto> findByRoomId(Integer id, Integer pageSize, Integer pageNumber) {
    var values =  bookingProvider.findByRoomId(
      id,
      Pageable
        .ofSize(pageSize)
        .withPage(pageNumber)
    )
      .map(bookingMapper::fromEntity);

    return ImmutablePageDto.<BookingDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<BookingDto> findByTenantId(Integer id, Integer pageSize, Integer pageNumber) {
    var values =  bookingProvider.findByTenantId(
      id,
      Pageable
        .ofSize(pageSize)
        .withPage(pageNumber)
    )
      .map(bookingMapper::fromEntity);

    return ImmutablePageDto.<BookingDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
