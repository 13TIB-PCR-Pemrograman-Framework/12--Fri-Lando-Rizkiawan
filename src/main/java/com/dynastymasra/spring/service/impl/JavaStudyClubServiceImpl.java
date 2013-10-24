package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.JavaStudyClub;
import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.domain.enumeration.Sex;
import com.dynastymasra.spring.service.JavaStudyClubService;
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
public class JavaStudyClubServiceImpl implements JavaStudyClubService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(JavaStudyClub javaStudyClub) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(javaStudyClub);
    }

    @Override
    public JavaStudyClub update(Integer id, JavaStudyClub javaStudyClub) {
        JavaStudyClub oldJavaStudyClub = findById(id);
        oldJavaStudyClub.setMahasiswa(javaStudyClub.getMahasiswa());
        oldJavaStudyClub.setYear(javaStudyClub.getYear());

        return entityManager.merge(oldJavaStudyClub);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(JavaStudyClub javaStudyClub) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(javaStudyClub);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<JavaStudyClub> findAll() {
        List<JavaStudyClub> result = entityManager.createQuery("SELECT j FROM JavaStudyClub j", JavaStudyClub.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public JavaStudyClub findById(Integer id) {
        return entityManager.find(JavaStudyClub.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public JavaStudyClub findByMahasiswa(Mahasiswa mahasiswa, Sex sex) {
        return entityManager.createQuery("SELECT j FROM JavaStudyClub j WHERE j.mahasiswa = :mahasiswa AND j.sex = :sex", JavaStudyClub.class).setParameter("mahasiswa", mahasiswa).setParameter("sex", sex).getSingleResult();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
