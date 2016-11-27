package brands.core.entity;

import brands.core.support.AddressForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 住所
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {

    public Address(String zip, String prefecture) {
        this.zip = zip;
        this.prefecture = prefecture;
    }

    /**
     * 郵便番号
     */
    @Column(name = "address_zip", length = 10)
    @Field
    private String zip;

    /**
     * 都道府県
     */
    @Column(name = "address_prefecture", length = 10)
    @Field
    private String prefecture;

    public static Address generateAddress(AddressForm form) {
        if (form == null) {
            return null;
        }
        return new Address(form.getZip(), form.getPrefecture());
    }
}
