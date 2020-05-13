import com.dao.CustomerDao;
import com.domian.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")//指定spring容器的配置信息
public class CustomerJpalTest {
    @Autowired
    private CustomerDao customerDao;
    /*根据用户名查找数据
    * */
    @Test
    public void testFindJpql(){
        Customer customer = customerDao.findJpql("秦世交");
        System.out.println(customer);
    }
    /*根据用户名和id查找数据
     * */
    @Test
    public void findCustomerByNameAndId(){
        Customer customer = customerDao.findCustomerByNameAndId("秦世交",1);
        System.out.println(customer);
    }
    /*根据用户名查找数据
        springDataJpa中使用jpql完成，更新、删除操作
            需要手动添加事务的支持
            默认会执行结束之后，回滚事务
            @Rollback：设置是否回滚 true|false
     * */
    @Test
    @Transactional//添加事务的支持
    @Rollback(value = false)
    public void updateByID(){
        customerDao.updateByID(1,"我真帅");
    }
}
