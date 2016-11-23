package brands.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 利用者
 */
@Entity
@Getter
@Setter
public class User extends AbstractEntity<Long> implements Serializable {
    /**
     * 名前
     */
    @Column(length = 100, nullable = false)
    private String name;

    /**
     * 年齢
     */
    private Integer age;

    /**
     * 性別
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @Field(analyze = Analyze.NO)
    private Gender gender;

    /**
     * 住所
     */
    private Address address = new Address();

    /**
     * ユーザのお気に入りブランド
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Brand> brands;
}
