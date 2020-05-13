import com.dao.CustomerDao;
import com.domian.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne(){
        Customer one = customerDao.findOne(1);
        System.out.println(one);
    }

    /**
     * 保存或者更新
     * 没有id主键 保存
     * 存在id主键 更新
     */
    @Test
    public void testSave(){
       Customer customer=new Customer();
       customer.setCustid(3);
       customer.setCustName("小秦哥");
       customer.setCustAddress("湖南株洲");
       customer.setCustNumber("12312313213");
       customerDao.save(customer);
    }
//    删除一个
    @Test
    public void testDelete(){
        customerDao.delete(4);
    }
//    查询所有
    @Test
    public void testFindAll(){
        List<Customer> all = customerDao.findAll();
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
//    统计查询
    @Test
    public void testCount(){
        //查询全部用户数量
        long count = customerDao.count();
        System.out.println(count);
    }
/*
  判断id为4的客户是否存在
    1.查询id为4的客户如果返回值为空，代表不存在
    2.判断数据库中id为4的用户的数量
 */
    @Test
    public void testExists(){
        boolean exists = customerDao.exists(4);
        System.out.println(exists);
    }
    /*
    * findOne:em.find :立即加载
    * getOne:em.getReference ：延迟加载
    * */
    @Test
    @Transactional
    public void testGetOne(){
        Customer one = customerDao.getOne(2);
        System.out.println(one);
    }
}
