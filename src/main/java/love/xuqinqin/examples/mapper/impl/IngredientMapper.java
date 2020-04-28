package love.xuqinqin.examples.mapper.impl;

import love.xuqinqin.examples.JDBCUtil;
import love.xuqinqin.examples.mapper.IIngredientMapper;
import love.xuqinqin.examples.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Ingredient持久层实现类
 *
 * @Author FGuy
 * @Date 2020/4/23 16:50
 */
@Repository
public class IngredientMapper implements IIngredientMapper {
    @Override
    public List<Ingredient> getIngredients() {

        return JDBCUtil.getJdbcTemplate().query("select id,name,ingredient_type.type_str from ingredient inner join ingredient_type on ingredient.Type = ingredient_type.type_id",
                (rs, rowNum) -> new Ingredient(
                        rs.getString("id"),
                        rs.getString("name"),
                        Ingredient.Type.valueOf(rs.getString("type_str"))
                ));
    }
}
