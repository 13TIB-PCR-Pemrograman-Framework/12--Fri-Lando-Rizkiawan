package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.KelompokStudiLinux;
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

public interface KelompokStudiLinuxService {
    void save(KelompokStudiLinux kelompokStudiLinux);
    KelompokStudiLinux update(Integer id, KelompokStudiLinux kelompokStudiLinux);
    void delete(KelompokStudiLinux kelompokStudiLinux);
    void delete(Integer id);
    List<KelompokStudiLinux> findAll();
    KelompokStudiLinux findById(Integer id);
    KelompokStudiLinux findByMahasiswa(Mahasiswa mahasiswa, Sex sex);
}
