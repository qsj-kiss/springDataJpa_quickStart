package com.domian;

import javax.persistence.*;

@Entity
@Table(name = "stu_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="stu_id" )
    private int id;
    @Column(name ="stu_name" )
    private String name;
    @Column(name ="stu_number" )
    private String number;
    @Column(name ="stu_sex" )
    private char sex;
    @Column(name ="stu_address" )
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
