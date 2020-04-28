package love.xuqinqin.examples;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * thymaleaf模板工具类
 *
 * @Author FGuy
 * @Date 2020/4/23 17:53
 */
@Component
public class ThymeleafUtil {

    public boolean containsIngredientType(String id, List<String> ingredients){
        if(ingredients == null || ingredients.size() == 0){
            return false;
        }
        return ingredients.contains(id);
    }

}
