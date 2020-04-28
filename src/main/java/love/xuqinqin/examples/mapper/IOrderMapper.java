package love.xuqinqin.examples.mapper;

import love.xuqinqin.examples.model.Order;

/**
 * Order持久层接口
 *
 * @Author FGuy
 * @Date 2020/4/25 13:14
 */
public interface IOrderMapper {

    /**
     * 保存账单
     *
     * @param order
     */
    Order save(Order order);

}
