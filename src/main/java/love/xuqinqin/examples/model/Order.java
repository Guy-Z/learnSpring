package love.xuqinqin.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order实体类
 *
 * @Author FGuy
 * @Date 2020/4/22 14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "taco_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long createdAt;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<Taco>();

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotBlank(message = "无效街道")
    private String street;

    @NotBlank(message = "无效城市")
    private String city;

    @NotBlank(message = "无效省份")
    private String state;

    @NotBlank(message = "无效邮编")
    private String zip;

    @CreditCardNumber(message = "不是一个有效的信用卡号")
    private String ccNumber;

    @Pattern(regexp = "^(o[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "必须为格式MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "无效CVV")
    private String ccCVV;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

    @PrePersist
    void createdAt(){
        this.createdAt = new Date().getTime();
    }

}
