package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.KelompokStudiWeb;
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

public interface KelompokStudiWebService {
    void save(KelompokStudiWeb kelompokStudiWeb);
    KelompokStudiWeb update(Integer id, KelompokStudiWeb kelompokStudiWeb);
    void delete(KelompokStudiWeb kelompokStudiWeb);
    void delete(Integer id);
    List<KelompokStudiWeb> findAll();
    KelompokStudiWeb findById(Integer id);
    KelompokStudiWeb findByMahasiswa(Mahasiswa mahasiswa, Sex sex);
}
