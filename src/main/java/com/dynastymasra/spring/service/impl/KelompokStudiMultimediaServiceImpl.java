package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.KelompokStudiMultimedia;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;
import com.dynastymasra.spring.service.KelompokStudiMultimediaService;
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
public class KelompokStudiMultimediaServiceImpl implements KelompokStudiMultimediaService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(KelompokStudiMultimedia kelompokStudiMultimedia) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(kelompokStudiMultimedia);
    }

    @Override
    public KelompokStudiMultimedia update(Integer id, KelompokStudiMultimedia kelompokStudiMultimedia) {
        KelompokStudiMultimedia oldKelompokStudiMultimedia = findById(id);
        oldKelompokStudiMultimedia.setMahasiswa(kelompokStudiMultimedia.getMahasiswa());
        oldKelompokStudiMultimedia.setYear(kelompokStudiMultimedia.getYear());

        return entityManager.merge(oldKelompokStudiMultimedia);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(KelompokStudiMultimedia kelompokStudiMultimedia) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(kelompokStudiMultimedia);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<KelompokStudiMultimedia> findAll() {
        List<KelompokStudiMultimedia> result = entityManager.createQuery("SELECT m FROM KelompokStudiMultimedia m", KelompokStudiMultimedia.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiMultimedia findById(Integer id) {
        return entityManager.find(KelompokStudiMultimedia.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiMultimedia findByMahasiswa(Mahasiswa mahasiswa, Sex sex) {
        return entityManager.createQuery("SELECT m FROM KelompokStudiMultimedia m WHERE m.mahasiswa = :mahasiswa AND m.sex = :sex", KelompokStudiMultimedia.class).setParameter("mahasiswa", mahasiswa).setParameter("sex", sex).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
