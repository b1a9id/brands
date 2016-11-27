package brands.core.model;

import brands.core.entity.Address;
import brands.core.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserEditRequest implements Serializable {

    public UserEditRequest(String name, Integer age, Gender gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    private String name;

    private Integer age;

    private Gender gender;

    private Address address;
}
