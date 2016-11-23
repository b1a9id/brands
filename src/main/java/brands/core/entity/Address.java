package brands.core.entity;

import lombok.Getter;
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
public class Address implements Serializable {
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
}
