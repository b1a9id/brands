package brands.web.controller.user;

import brands.core.entity.Address;
import brands.core.entity.Gender;
import brands.core.model.UserCreateRequest;
import brands.core.support.AddressForm;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UserCreateForm implements Serializable {
    @NotNull
    private String name;

    private Integer age;

    @NotNull
    private Gender gender;

    @Valid
    private AddressForm address;

    public UserCreateRequest toUserCreateRequest() {
        return new UserCreateRequest(getName(), getAge(), getGender(), Address.generateAddress(getAddress()));
    }
}
