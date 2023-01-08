package challenge.server.datamodellingtest.repository;

import challenge.server.datamodellingtest.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataModellingTestReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findAllByHabitNotNull(PageRequest pageRequest);

    Page<Report> findAllByAuthNotNull(PageRequest pageRequest);

//    @Query(value = "SELECT REPORT_TYPE, COUNT(*) FROM REPORT WHERE HABIT IS NOT NULL GROUP BY REPORT_TYPE", nativeQuery = true)
//    Page<Report> countHabitReportsByTypes(PageRequest pageRequest);

    Long countAllByHabitNotNullAndAndReportTypeIsLike(String reportType);
    /* select
        report0_.report_id as report_i1_5_,
        report0_.auth_id as auth_id3_5_,
        report0_.habit_id as habit_id4_5_,
        report0_.report_type as report_t2_5_,
        report0_.review_id as review_i5_5_
    from
        report report0_
    where
        report0_.habit_id is not null
    order by
        report0_.report_id desc limit ?
     */
}
