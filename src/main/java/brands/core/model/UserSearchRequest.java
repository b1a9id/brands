package brands.core.model;

import brands.core.entity.Address;
import brands.core.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserSearchRequest implements Serializable {
    private String name;

    private Integer age;

    private Gender gender;

    private Address address = new Address();
}
