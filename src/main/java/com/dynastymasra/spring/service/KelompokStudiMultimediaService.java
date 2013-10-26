package com.dynastymasra.spring.service;

import com.dynastymasra.spring.domain.KelompokStudiMultimedia;
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

public interface KelompokStudiMultimediaService {
    void save(KelompokStudiMultimedia kelompokStudiMultimedia);
    KelompokStudiMultimedia update(Integer id, KelompokStudiMultimedia kelompokStudiMultimedia);
    void delete(KelompokStudiMultimedia kelompokStudiMultimedia);
    void delete(Integer id);
    List<KelompokStudiMultimedia> findAll();
    KelompokStudiMultimedia findById(Integer id);
    KelompokStudiMultimedia findByMahasiswa(Mahasiswa mahasiswa, Sex sex);
}
