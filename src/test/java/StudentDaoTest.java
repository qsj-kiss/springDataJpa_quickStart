import com.dao.StudentDao;
import com.domian.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void TestFindOne(){
        /**
         * 根据客户查询，查询id为1的客户
         *      查询条件：
         *              查询方式：
         *                  cb对象
         *              比较的属性名称
         *                  root对象
         */
        Specification<Student> specifications=new Specification<Student>(){
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取比较的属性 属性名称
                Path<Object> id = root.get("id");
                //构造查询条件 select * from stu_student where stu_id=1
                /**
                 * 第一个参数：需要比较的属性（path对象）
                 * 第二个参数：当前需要比较的取值
                 */
                Predicate equal = cb.equal(id, 1);//进行精准匹配（定义比较的属性名，比较属性的取值）
                return equal;
            }
        };
        Student one = studentDao.findOne(specifications);
        System.out.println(one);
    }
    //查询多个条件
    @Test
    public void testFindOneByNameAndAddress(){
        Specification<Student> specification=new Specification<Student>() {
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> name = root.get("name");
                Path<Object> address = root.get("address");
                Predicate p1 = cb.equal(name, "秦小交");
                Predicate p2 = cb.equal(address, "湖南长沙");
                //将多个查询条件组合到一起：组合（满足一并且满足条件二：与关系，满足一或满足条件二：或关系）
                Predicate and = cb.and(p1, p2);//以与的方式拼接多个查询条件
                Predicate or = cb.or(p1, p2);//以或的方式拼接多个查询条件
                return or;
            }
        };
//        Student one = studentDao.findOne(specification);
//        System.out.println(one);
        List<Student> all = studentDao.findAll(specification);
        for (Student student : all) {
            System.out.println(student);
        }
    }
    /**
     * equal：直接得到path对象（属性）然后进行比较即可
     * gt lt ge le like ：得到path对象，根据path指定比较的参数类型，在去进行比较
     *      指定参数类型：path.as(类型的字节码对象)
        查询多个条件模糊查询
     */
    @Test
    public void findNameLike(){
        Specification<Student> specification=new Specification<Student>() {
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> name = root.get("name");
                Predicate like = cb.like(name.as(String.class), "%秦%");
                return like;
            }
        };
        //不排序的方法
       // List<Student> all = studentDao.findAll(specification);
        /**
         *
        创建排序对象,需要调用构造方法实例化对象
            第一个参数：排序的顺序
            第二个参数：排序的属性名称
                DESC倒序 ASC升序
         */
        Sort sort=new Sort(Sort.Direction.DESC,"id");//倒叙
        List<Student> all = studentDao.findAll(specification,sort);
        for (Student student : all) {
            System.out.println(student);
        }
    }
    /**
     * equal：直接得到path对象（属性）然后进行比较即可
     * gt lt ge le like ：得到path对象，根据path指定比较的参数类型，在去进行比较
     *      指定参数类型：path.as(类型的字节码对象)
     查询多个条件模糊查询
     */
    @Test
    public void testLimit(){
        Specification<Student> specification=new Specification<Student>() {
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> name = root.get("name");
                Predicate like = cb.like(name.as(String.class), "%秦%");
                return like;
            }
        };
        List<Student> all = studentDao.findAll(specification);
        for (Student student : all) {
            System.out.println(student);
        }
    }
}
