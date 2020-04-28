package love.xuqinqin.examples.service.impl;

import love.xuqinqin.examples.mapper.ITacoMapper;
import love.xuqinqin.examples.model.Taco;
import love.xuqinqin.examples.service.ITacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Taco业务层实现类
 *
 * @Author FGuy
 * @Date 2020/4/25 12:49
 */
@Repository
public class TacoService implements ITacoService {

    @Autowired
    private ITacoMapper tacoMapper;

    @Override
    public Taco save(Taco taco) {

        return tacoMapper.save(taco);

    }
}
