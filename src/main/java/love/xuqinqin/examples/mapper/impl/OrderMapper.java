package love.xuqinqin.examples.mapper.impl;

import love.xuqinqin.examples.JDBCUtil;
import love.xuqinqin.examples.mapper.IOrderMapper;
import love.xuqinqin.examples.model.Order;
import love.xuqinqin.examples.model.Taco;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

/**
 * Order持久层 实现类
 *
 * @Author FGuy
 * @Date 2020/4/25 13:16
 */
@Repository
public class OrderMapper implements IOrderMapper {


    @Override
    public Order save(Order order) {
        order.setId(this.saveOrderDetails(order));
        for (Taco taco : order.getTacos()) {
            this.saveTacoToOrder(taco,order.getId());
        }
        return order;
    }


    private Integer saveOrderDetails(Order order){
        order.setCreatedAt(new Date().getTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        JDBCUtil.getJdbcTemplate().update((conn) -> {
            PreparedStatement ps = conn.prepareStatement(
                    "insert into taco_order (createdAt, name, street, city, state, zip, ccNumber, ccExpiration, ccCVV) values (?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,order.getCreatedAt());
            ps.setString(2,order.getName());
            ps.setString(3,order.getStreet());
            ps.setString(4,order.getCity());
            ps.setString(5,order.getState());
            ps.setString(6,order.getZip());
            ps.setString(7,order.getCcNumber());
            ps.setString(8,order.getCcExpiration());
            ps.setString(9,order.getCcCVV());
            return ps;
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    private void saveTacoToOrder(Taco taco,Integer orderId){
        JDBCUtil.getJdbcTemplate().update("insert into taco_order_tacos(order_id,taco_id) values (?,?)",orderId,taco.getId());
    }

}
