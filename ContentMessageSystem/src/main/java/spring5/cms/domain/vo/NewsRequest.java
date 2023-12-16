package spring5.cms.domain.vo;

import lombok.Data;
import spring5.cms.domain.models.Category;
import spring5.cms.domain.models.Tag;

import java.util.Set;

@Data
public class NewsRequest {
    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;
}
