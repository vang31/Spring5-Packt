package spring5.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import spring5.cms.domain.models.Category;

import java.util.List;

@Service
public interface CategoryRepository extends MongoRepository<Category, String> {
}
