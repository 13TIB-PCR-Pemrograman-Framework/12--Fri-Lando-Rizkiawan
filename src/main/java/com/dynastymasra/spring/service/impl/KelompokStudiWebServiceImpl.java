package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.KelompokStudiWeb;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;
import com.dynastymasra.spring.service.KelompokStudiWebService;
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
public class KelompokStudiWebServiceImpl implements KelompokStudiWebService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(KelompokStudiWeb kelompokStudiWeb) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(kelompokStudiWeb);
    }

    @Override
    public KelompokStudiWeb update(Integer id, KelompokStudiWeb kelompokStudiWeb) {
        KelompokStudiWeb oldKelompokStudiWeb = findById(id);
        oldKelompokStudiWeb.setMahasiswa(kelompokStudiWeb.getMahasiswa());
        oldKelompokStudiWeb.setYear(kelompokStudiWeb.getYear());

        return entityManager.merge(oldKelompokStudiWeb);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(KelompokStudiWeb kelompokStudiWeb) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(kelompokStudiWeb);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<KelompokStudiWeb> findAll() {
        List<KelompokStudiWeb> result = entityManager.createQuery("SELECT w FROM KelompokStudiWeb w", KelompokStudiWeb.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiWeb findById(Integer id) {
        return entityManager.find(KelompokStudiWeb.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public KelompokStudiWeb findByMahasiswa(Mahasiswa mahasiswa, Sex sex) {
        return entityManager.createQuery("SELECT w FROM KelompokStudiWeb w WHERE w.mahasiswa = :mahasiswa AND w.sex = :sex", KelompokStudiWeb.class).setParameter("mahasiswa", mahasiswa).setParameter("sex", sex).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
