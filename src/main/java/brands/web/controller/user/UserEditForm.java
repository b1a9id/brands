package brands.web.controller.user;

import brands.core.entity.Address;
import brands.core.entity.Gender;
import brands.core.entity.User;
import brands.core.model.UserEditRequest;
import brands.core.support.AddressForm;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class UserEditForm implements Serializable {
    @NotNull
    private String name;

    private Integer age;

    @NotNull
    private Gender gender;

    @Valid
    private AddressForm address;

    public UserEditForm() {}

    public UserEditForm(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.gender = user.getGender();

        if (user.getAddress() != null) {
            AddressForm addressForm = new AddressForm();
            Address address = user.getAddress();
            addressForm.setZip(address.getZip());
            addressForm.setPrefecture(address.getPrefecture());
            this.address = addressForm;
        }
    }

    public UserEditRequest toUserEditRequest() {
        return new UserEditRequest(getName(), getAge(), getGender(), Address.generateAddress(getAddress()));
    }
}
