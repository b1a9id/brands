package brands.core.support;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AddressForm implements Serializable {
    @NotNull
    private String zip;

    @NotNull
    private String prefecture;
}
