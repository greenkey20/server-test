package challenge.server.datamodellingtest.repository;

import challenge.server.datamodellingtest.entity.Habit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataModellingTestHabitRepository extends JpaRepository<Habit, Long> {
//   @Query(value = "select h.habit_id from Habit h join fetch h.category where h.category.categoryId = :categoryId")
   Page<Habit> findAllByCategoryCategoryId(Long categoryId, PageRequest pageRequest);
//   @Query(value = "SELECT DISTINCT p FROM Post p JOIN FETCH p.replies WHERE p.content LIKE %:content%",
//           countQuery = "SELECT COUNT(DISTINCT p) FROM Post p INNER JOIN p.replies WHERE p.content LIKE %:content%")

}
