package spring5.cms.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring5.cms.domain.exceptions.CategoryNotFoundExceptions;
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

    @Transactional
    public Category update(String id, CategoryRequest categoryRequest){
        Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isPresent()){
            Category categoryDB = category.get();
            categoryDB.setId(UUID.randomUUID().toString());
            categoryDB.setName(categoryRequest.getName());
            return this.categoryRepository.save(categoryDB);
        } else{
            throw new CategoryNotFoundExceptions(id);
        }
    }

    @Transactional
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return this.categoryRepository.save(category);
    }
    @Transactional
    public void delete(String id){
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }
    public List<Category> findByName(String name){
        return this.categoryRepository.findByName(name);
    }

    public List<Category> findByNameStartingWith(String name){
        return this.categoryRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public Category findByOne(String id) {
        final Optional<Category> category = this.categoryRepository.findById(id);

        if(category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundExceptions(id);
        }
    }
}
