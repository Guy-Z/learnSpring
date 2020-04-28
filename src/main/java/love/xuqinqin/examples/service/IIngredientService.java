package love.xuqinqin.examples.service;

import love.xuqinqin.examples.model.Ingredient;

import java.util.List;

/**
 * 成分业务层接口
 *
 * @Author FGuy
 * @Date 2020/4/23 16:35
 */
public interface IIngredientService {

    /**
     * 获取所有成分
     *
     * @return
     */
    List<Ingredient> getIngredients();

}
