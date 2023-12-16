package spring5.cms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import spring5.cms.domain.models.User;

@Service
public interface UserRepository extends JpaRepository<User, String> {

}
