package spring5.cms.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import spring5.cms.domain.models.News;

@Service
public interface NewsRepository extends MongoRepository<News, String> {
}
