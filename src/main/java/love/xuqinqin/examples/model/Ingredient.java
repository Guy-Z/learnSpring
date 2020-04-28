package love.xuqinqin.examples.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Ingredient实体类
 *
 * @Author FGuy
 * @Date 2020/4/22 12:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
@Entity
public class Ingredient {

    @Id
    private String id;
    private String name;
    private Type type;

    public static  enum  Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
