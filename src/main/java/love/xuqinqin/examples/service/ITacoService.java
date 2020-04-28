package love.xuqinqin.examples.service;

import love.xuqinqin.examples.model.Taco;

/**
 * Taco业务层接口
 *
 * @Author FGuy
 * @Date 2020/4/25 12:48
 */
public interface ITacoService {

    /**
     * 保存Taco
     *
     * @param taco
     */
    Taco save(Taco taco);

}
