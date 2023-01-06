package challenge.server.datamodellingtest.repository;

import challenge.server.datamodellingtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataModellingTestUserRepository extends JpaRepository<User, Long> {
}
