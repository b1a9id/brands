package brands.core.entity;

import brands.core.model.UserCreateRequest;
import brands.core.model.UserEditRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class User extends AbstractEntity<Long> implements Serializable {

    public User(String name, Integer age, Gender gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

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

    public static User generateUser(UserCreateRequest request) {
        return generateUser(request.getName(), request.getAge(), request.getGender(), request.getAddress());
    }

    public static User generateUser(UserEditRequest request) {
        return generateUser(request.getName(), request.getAge(), request.getGender(), request.getAddress());
    }

    private static User generateUser(String name, Integer age, Gender gender, Address address) {
        return new User(name, age, gender, address);
    }
}
