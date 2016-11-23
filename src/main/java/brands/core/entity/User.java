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
    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String nameKana;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @Field(analyze = Analyze.NO)
    private Gender gender;

    private Address address = new Address();

    /**
     * ユーザのお気に入りブランド
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Brand> brands;
}
