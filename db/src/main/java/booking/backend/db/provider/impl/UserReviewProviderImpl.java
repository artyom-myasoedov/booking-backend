package booking.backend.db.provider.impl;

import booking.backend.db.entity.UserReviewEntity;
import booking.backend.db.provider.UserReviewProvider;
import booking.backend.db.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserReviewProviderImpl implements UserReviewProvider {

  private final UserReviewRepository userReviewRepository;

  @Autowired
  public UserReviewProviderImpl(UserReviewRepository userReviewRepository) {
    this.userReviewRepository = userReviewRepository;
  }

  @Override
  public Page<UserReviewEntity> findReviews(String search, Pageable pageable) {
    if (search == null) {
      return userReviewRepository.findAll(pageable);
    }
    return userReviewRepository.findReviews(search, pageable);
  }

  @Override
  public UserReviewEntity save(UserReviewEntity reviewDto) {
    return userReviewRepository.save(reviewDto);
  }

  @Override
  public Optional<UserReviewEntity> findById(Integer id) {
    return userReviewRepository.findById(id);
  }

  @Override
  public Iterable<UserReviewEntity> findAll() {
    return userReviewRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    userReviewRepository.deleteById(id);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKey(Integer authorId, Integer userId) {
    return userReviewRepository.checkIdentityForPrimaryKey(authorId, userId);
  }

  @Override
  public Integer countIdenticalTuplesOfPrimaryKeyAccountingCurrentTuple(Integer id,
                                                                        Integer authorId,
                                                                        Integer userId) {
    return userReviewRepository.checkIdentityForPrimaryKeyAccountingCurrentTuple(id, authorId, userId);
  }
}
