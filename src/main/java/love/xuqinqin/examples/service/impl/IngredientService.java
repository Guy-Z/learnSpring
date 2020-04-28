package love.xuqinqin.examples.service.impl;

import love.xuqinqin.examples.mapper.impl.IngredientMapper;
import love.xuqinqin.examples.model.Ingredient;
import love.xuqinqin.examples.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成分业务层实现类
 *
 * @Author FGuy
 * @Date 2020/4/23 16:39
 */
@Service
public class IngredientService implements IIngredientService {

    @Autowired
    private IngredientMapper ingredientMapper;

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientMapper.getIngredients();
    }
}
