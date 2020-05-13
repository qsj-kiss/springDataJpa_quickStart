package com.dao;
/**
 * 实现springDataJpa的dao层接口规范
 *  JpaRepository<操作的实体类类型，实体类中主键属性的类型>
 *      封装了CRUD操作
 *  JpaSpecificationExecutor<操作的实体类类型>
 *      封装了复杂查询（分页）
 */

import com.domian.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Integer> , JpaSpecificationExecutor<Customer> {
    /*
    * 定义jpql语句
    * jpql:from Customer where cust_name
    * 配置jpql语句使用@query注解
    * */
    @Query(value ="from Customer where cust_name = ?1")
    public Customer findJpql(String cust_name);
    /*
    * 根据用户id和名称查询客户
    * jpql：from Customer where cust_name =?0 and cust_id = ?1
    * */
    @Query(value ="from Customer where cust_name =?1 and cust_id = ?2")
    Customer findCustomerByNameAndId(String name,Integer id);

    /*
     * 根据用户id进行更新
     * sql:update cus_customer set cust_name=? where cust_id=?
     * jpql：update Customer set custName=?1 where custid=?2
     * @Query：代表是查询
     *          需要声明方法用来更新
     * @Modifying
     *      当前执行的是一个更新操作
     * */
    @Query(value = "update Customer set custName=?2 where custid=?1")
    @Modifying
     void updateByID(Integer id,String name);


    /*
     * 使用sql语句查询
     *   查询全部用户
     * sql ：select * from cst_customer
     * */
    @Query(value = "select * from cst_customer",nativeQuery = true)
    List<Object []>findAllBySql();

    /*
     * 使用sql语句查询
     *   查询全部用户
     * sql ：select * from cst_customer
     * */
    @Query(value = "select * from cst_customer where cust_name like ?1",nativeQuery = true)
    List<Object []>findLikeByName(String name);
}
