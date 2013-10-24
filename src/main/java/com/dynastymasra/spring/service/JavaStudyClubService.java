package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.JavaStudyClub;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;

import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

public interface JavaStudyClubService {
    void save(JavaStudyClub javaStudyClub);
    JavaStudyClub update(Integer id, JavaStudyClub javaStudyClub);
    void delete(JavaStudyClub javaStudyClub);
    void delete(Integer id);
    List<JavaStudyClub> findAll();
    JavaStudyClub findById(Integer id);
    JavaStudyClub findByMahasiswa(Mahasiswa mahasiswa, Sex sex);
}
