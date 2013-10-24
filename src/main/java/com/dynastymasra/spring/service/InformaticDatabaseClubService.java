package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.InformaticDatabaseClub;
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

public interface InformaticDatabaseClubService {
    void save(InformaticDatabaseClub informaticDatabaseClub);
    InformaticDatabaseClub update(Integer id, InformaticDatabaseClub informaticDatabaseClub);
    void delete(InformaticDatabaseClub informaticDatabaseClub);
    void delete(Integer id);
    List<InformaticDatabaseClub> findAll();
    InformaticDatabaseClub findById(Integer id);
    InformaticDatabaseClub findByMahasiswa(Mahasiswa mahasiswa, Sex sex);
}
