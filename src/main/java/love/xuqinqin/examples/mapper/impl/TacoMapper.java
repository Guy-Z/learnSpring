package love.xuqinqin.examples.mapper.impl;

import love.xuqinqin.examples.JDBCUtil;
import love.xuqinqin.examples.mapper.ITacoMapper;
import love.xuqinqin.examples.model.Taco;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

/**
 * Taco持久层实现类
 *
 * @Author FGuy
 * @Date 2020/4/24 12:06
 */
@Repository
public class TacoMapper implements ITacoMapper {

    @Override
    public Taco save(Taco taco) {
        taco.setId(this.saveTacoInfo(taco));
        for (String ingredient : taco.getIngredients()) {
            this.saveTacoIngredient(taco.getId(),ingredient);
        }
        return taco;
    }

    /**
     * 保存Taco并返回MySql自动生成的ID
     *
     * @param taco
     * @return
     */
    private int saveTacoInfo(Taco taco){
        taco.setCreatedAt(new Date().getTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        JDBCUtil.getJdbcTemplate().update((conn) -> {
            PreparedStatement ps = conn.prepareStatement("insert into taco (name, createdAt) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,taco.getName());
            ps.setLong(2,taco.getCreatedAt());
            return ps;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 保存Taco的成分
     *
     * @param tacoID
     * @param ingredientID
     */
    private void saveTacoIngredient(Integer tacoID, String ingredientID){
        JDBCUtil.getJdbcTemplate().update("insert into taco_ingredient(taco_id,ingredient_id) values (?,?)",tacoID,ingredientID);
    }


}
