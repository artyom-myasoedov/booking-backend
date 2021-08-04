package booking.backend.db.provider.impl;

import booking.backend.db.entity.ReviewEntity;
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
  public Page<ReviewEntity> findReviews(String search, Pageable pageable) {
    if (search == null) {
      return reviewRepository.findAll(pageable);
    }
    return reviewRepository.findReviews(search, pageable);
  }

  @Override
  public ReviewEntity save(ReviewEntity reviewEntity) {
    return reviewRepository.save(reviewEntity);
  }

  @Override
  public Optional<ReviewEntity> findById(Integer id) {
    return Optional.empty();
  }

  @Override
  public Iterable<ReviewEntity> findAll() {
    return reviewRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    reviewRepository.deleteById(id);
  }
}
