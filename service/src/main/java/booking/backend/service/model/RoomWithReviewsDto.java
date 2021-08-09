package booking.backend.service.model;

import java.util.List;

public class RoomWithReviewsDto extends RoomDto {

  private List<RoomReviewDto> reviews;

  public List<RoomReviewDto> getReviews() {
    return reviews;
  }

  public void setReviews(List<RoomReviewDto> reviews) {
    this.reviews = reviews;
  }
}
