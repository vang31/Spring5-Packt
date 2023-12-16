package spring5.cms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import spring5.cms.domain.models.Category;

import java.util.List;

@Service
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByName(String name);

    List<Category> findByNameIgnoreCaseStartingWith(String name);
}
