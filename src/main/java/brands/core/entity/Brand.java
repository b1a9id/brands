package brands.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * ブランド
 */
@Entity
@Getter
@Setter
public class Brand extends AbstractEntity<Long> implements Serializable {

    /**
     * ユーザ
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @IndexedEmbedded(includeEmbeddedObjectId = true)
    private User user;

    /**
     * ブランド名
     */
    @Column(length = 100, nullable = false)
    private String brandName;

    /**
     * デザイナー名
     */
    @Column(length = 100, nullable = false)
    private String designer;

    /**
     * 住所
     */
    private Address address = new Address();
}
