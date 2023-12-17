package spring5.cms.domain.exceptions;

public class CategoryNotFoundExceptions extends RuntimeException{

    String id;

    public CategoryNotFoundExceptions(String id) {
        this.id = id;
    }
}
