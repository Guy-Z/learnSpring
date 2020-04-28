package love.xuqinqin.examples.mapper;

import love.xuqinqin.examples.model.Ingredient;

import java.util.List;

/**
 * Ingredient持久层接口
 *
 * @Author FGuy
 * @Date 2020/4/23 16:48
 */
public interface IIngredientMapper {

    /**
     * 获取所有成分类型
     *
     * @return
     */
    List<Ingredient> getIngredients();




}
