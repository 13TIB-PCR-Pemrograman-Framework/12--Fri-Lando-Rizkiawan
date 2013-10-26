package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.KelompokStudiLinux;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;
import com.dynastymasra.spring.service.KelompokStudiLinuxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

@Service
@Transactional
public class KelompokStudiLinuxServiceImpl implements KelompokStudiLinuxService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(KelompokStudiLinux kelompokStudiLinux) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(kelompokStudiLinux);
    }

    @Override
    public KelompokStudiLinux update(Integer id, KelompokStudiLinux kelompokStudiLinux) {
        KelompokStudiLinux oldKelompokStudiLinux = findById(id);
        oldKelompokStudiLinux.setMahasiswa(kelompokStudiLinux.getMahasiswa());
        oldKelompokStudiLinux.setYear(kelompokStudiLinux.getYear());

        return entityManager.merge(oldKelompokStudiLinux);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(KelompokStudiLinux kelompokStudiLinux) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(kelompokStudiLinux);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<KelompokStudiLinux> findAll() {
        List<KelompokStudiLinux> result = entityManager.createQuery("SELECT l FROM KelompokStudiLinux l", KelompokStudiLinux.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiLinux findById(Integer id) {
        return entityManager.find(KelompokStudiLinux.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiLinux findByMahasiswa(Mahasiswa mahasiswa, Sex sex) {
        return entityManager.createQuery("SELECT l FROM KelompokStudiLinux l WHERE l.mahasiswa = :mahasiswa AND l.sex = :sex", KelompokStudiLinux.class).setParameter("mahasiswa", mahasiswa).setParameter("sex", sex).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
