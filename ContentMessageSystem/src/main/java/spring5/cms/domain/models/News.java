package spring5.cms.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="news")
public class News {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;
    String title;
    String context;

    @ManyToOne
    User author;

    @OneToMany
    Set<User> mandatoryReviewers = new HashSet<>();

    @ElementCollection
    Set<Review> reviewers = new HashSet<>();

    @OneToMany
    Set<Category> categories = new HashSet<>();

    @ElementCollection
    Set<Tag> tags = new HashSet<>();

    public Review review(String userId, String status){
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }
    public Boolean revised() {
        return this.mandatoryReviewers.stream()
                .allMatch(reviewer -> this.reviewers.stream()
                        .anyMatch(review -> reviewer.id.equals(review.userId) && "approved".equals(review.status)));
    }


}
