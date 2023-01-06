package challenge.server.datamodellingtest.repository;

import challenge.server.datamodellingtest.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataModellingTestReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByUserHabitHabitHabitId(Long habitId, PageRequest pageRequest);

    Page<Review> findAllByUserHabitUserUserId(Long userId, PageRequest reviewId);
}
