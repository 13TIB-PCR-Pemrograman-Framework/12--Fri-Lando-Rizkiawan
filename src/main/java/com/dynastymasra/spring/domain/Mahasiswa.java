package com.dynastymasra.spring.domain;

import com.dynastymasra.spring.domain.enumeration.Sex;

import javax.persistence.*;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Entity
@Table(name = "sc_mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mahasiswa_id")
    private Integer id;
    @Column(name = "mahasiswa_nim", nullable = false, length = 30)
    private String nim;
    @Column(name = "mahasiswa_name", nullable = false, length = 255)
    private String name;
    @Column(name = "mahasiswa_email", nullable = false, length = 50)
    private String email;
    @Column(name = "mahasiswa_number", nullable = false, length = 20)
    private String number;
    @Column(name = "mahasiswa_sex", nullable = false)
    private Sex sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
