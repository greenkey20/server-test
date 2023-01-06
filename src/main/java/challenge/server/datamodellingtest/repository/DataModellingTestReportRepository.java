package challenge.server.datamodellingtest.repository;

import challenge.server.datamodellingtest.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataModellingTestReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findAllByHabitNotNull(PageRequest pageRequest);

    Page<Report> findAllByAuthNotNull(PageRequest pageRequest);
}
