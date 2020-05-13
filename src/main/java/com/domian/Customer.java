package com.domian;

import javax.persistence.*;

/**
 * 客户实体类
 * 1.实体类和表的关系
 * @Entity @Table
 * 2.类中属性和表中字段的映射关系
 * @Id @GenerateValue @Column
 */

@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int custid;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_number")
    private String custNumber;


    public long getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custid=" + custid +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custNumber='" + custNumber + '\'' +
                '}';
    }
}
