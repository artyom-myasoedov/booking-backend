package booking.backend.db.provider.impl;

import booking.backend.db.entity.ReviewDto;
import booking.backend.db.provider.ReviewProvider;
import booking.backend.db.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewProviderImpl implements ReviewProvider {

  private final ReviewRepository reviewRepository;

  @Autowired
  public ReviewProviderImpl(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public Page<ReviewDto> findReviews(String search, Pageable pageable) {
    if (search == null) {
      return reviewRepository.findAll(pageable);
    }
    return reviewRepository.findReviews(search, pageable);
  }

  @Override
  public ReviewDto save(ReviewDto reviewDto) {
    return reviewRepository.save(reviewDto);
  }

  @Override
  public Optional<ReviewDto> findById(Integer id) {
    return reviewRepository.findById(id);
  }

  @Override
  public Iterable<ReviewDto> findAll() {
    return reviewRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    reviewRepository.deleteById(id);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKey(Integer authorId, Integer ratedEntityId, Integer reviewTargetId) {
    return reviewRepository.checkIdentityForPrimaryKey(ratedEntityId, authorId, reviewTargetId);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                        Integer authorId,
                                                                        Integer ratedEntityId,
                                                                        Integer reviewTargetId) {
    return reviewRepository.checkIdentityForPrimaryKeyAccountingCurrentTuple(id, ratedEntityId, authorId, reviewTargetId);
  }

  @Override
  public Page<ReviewDto> findByCriteria(Integer ratedEntityId,
                                        Integer authorId,
                                        Integer reviewTargetId,
                                        Integer minRating,
                                        Integer maxRating,
                                        String sortOrder,
                                        String sortBy,
                                        Pageable pageable) {
    return null;
  }
}
