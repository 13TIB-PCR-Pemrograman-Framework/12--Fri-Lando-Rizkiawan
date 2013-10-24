package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.InformaticDatabaseClub;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;
import com.dynastymasra.spring.service.InformaticDatabaseClubService;
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
public class InformaticDatabaseClubServiceImpl implements InformaticDatabaseClubService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(InformaticDatabaseClub informaticDatabaseClub) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(informaticDatabaseClub);
    }

    @Override
    public InformaticDatabaseClub update(Integer id, InformaticDatabaseClub informaticDatabaseClub) {
        InformaticDatabaseClub oldInformaticDatabaseClub = findById(id);
        oldInformaticDatabaseClub.setMahasiswa(informaticDatabaseClub.getMahasiswa());
        oldInformaticDatabaseClub.setYear(informaticDatabaseClub.getYear());

        return entityManager.merge(oldInformaticDatabaseClub);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(InformaticDatabaseClub informaticDatabaseClub) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(informaticDatabaseClub);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<InformaticDatabaseClub> findAll() {
        List<InformaticDatabaseClub> result = entityManager.createQuery("SELECT i FROM InformaticDatabaseClub i", InformaticDatabaseClub.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public InformaticDatabaseClub findById(Integer id) {
        return entityManager.find(InformaticDatabaseClub.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public InformaticDatabaseClub findByMahasiswa(Mahasiswa mahasiswa, Sex sex) {
        return entityManager.createQuery("SELECT i FROM InformaticDatabaseClub i WHERE i.mahasiswa = :mahasiswa AND i.sex = :sex", InformaticDatabaseClub.class).setParameter("mahasiswa", mahasiswa).setParameter("sex", sex).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
