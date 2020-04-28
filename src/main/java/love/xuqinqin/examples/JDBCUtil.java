package love.xuqinqin.examples;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * jdbc工具类
 *
 * @Author FGuy
 * @Date 2020/4/23 16:50
 */

public class JDBCUtil {

    public static DataSource dataSource = null;

    static {
        dataSource =new ComboPooledDataSource("jdbcConnection");
    }

    public static JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

}
