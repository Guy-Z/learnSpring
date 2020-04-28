package love.xuqinqin.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Taco实体类
 *
 * @Author FGuy
 * @Date 2020/4/22 13:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Column(name = "createdAt")
    private Long createdAt;
    @NotNull
    @Size(min = 5, message = "名称至少5个字符")
    private String name;
    @NotEmpty(message = "至少选择一个")

    @ManyToMany(targetEntity = Ingredient.class)
    private List<String> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date().getTime();
    }

}
