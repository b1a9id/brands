package brands.web.controller.user;

import brands.core.entity.Gender;
import brands.core.model.UserSearchRequest;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserSearchForm implements Serializable {
    private String name;

    private Gender gender;

    public UserSearchRequest toUserSearchRequest() {
        UserSearchRequest request = new UserSearchRequest();
        request.setName(getName());
        request.setGender(getGender());
        return request;
    }
}
