package spring5.cms.domain.vo;

import lombok.Data;
import spring5.cms.domain.models.Role;

@Data
public class UserRequest {
    String identity;
    String name;
    Role role;
}
