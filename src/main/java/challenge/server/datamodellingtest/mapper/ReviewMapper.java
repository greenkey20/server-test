package challenge.server.datamodellingtest.mapper;

import challenge.server.datamodellingtest.dto.ReviewDto;
import challenge.server.datamodellingtest.entity.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto.Response reviewToReviewResponse(Review review);

    List<ReviewDto.Response> reviewsToReviewResponses(List<Review> reviews);
}
