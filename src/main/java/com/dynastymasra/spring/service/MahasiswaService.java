package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.Mahasiswa;
import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

public interface MahasiswaService {
    void save(Mahasiswa mahasiswa);
    Mahasiswa update(Integer id, Mahasiswa mahasiswa);
    void delete(Mahasiswa mahasiswa);
    void delete(Integer id);
    List<Mahasiswa> findAll();
    Mahasiswa findById(Integer id);
}
