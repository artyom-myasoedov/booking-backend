package booking.backend.service.model;

import java.util.List;

public class RoomWithReviewsDto extends RoomDto {

  private List<ReviewDto> reviews;

  public List<ReviewDto> getReviews() {
    return reviews;
  }

  public void setReviews(List<ReviewDto> reviews) {
    this.reviews = reviews;
  }
}
