package spring5.cms.domain.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Tag {

    String value;

}
