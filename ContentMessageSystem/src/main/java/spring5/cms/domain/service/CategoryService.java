package spring5.cms.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring5.cms.domain.exceptions.CategoryNotFoundExceptions;
import spring5.cms.domain.exceptions.UserNotFoundException;
import spring5.cms.domain.models.Category;
import spring5.cms.domain.repository.CategoryRepository;
import spring5.cms.domain.vo.CategoryRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(Category category){
        return this.categoryRepository.save(category);
    }

    public Category create(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    public void delete(String id){
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Category findByOne(String id){
        final Optional<Category> category = this.categoryRepository.findById(id);

        if(category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundExceptions(id);
        }
    }
}
