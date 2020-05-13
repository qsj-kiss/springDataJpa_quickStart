import com.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")//指定spring容器的配置信息
public class CustomerSqlTest {
    @Autowired
    private CustomerDao customerDao;
    /*测试SQL查询
    *
    * */
    @Test
    public void findAllBySql(){
        List<Object[]> allBySql = customerDao.findAllBySql();
        for (Object[] objects : allBySql) {
            System.out.println(Arrays.toString(objects));
        }
    }
    /*测试SQL查询
     *
     * */
    @Test
    public void findLikeByName(){
        List<Object[]> allBySql = customerDao.findLikeByName("%秦%");
        for (Object[] objects : allBySql) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
