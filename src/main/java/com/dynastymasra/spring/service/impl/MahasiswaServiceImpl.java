package com.dynastymasra.spring.service.impl;

import com.dynastymasra.spring.domain.Mahasiswa;
import com.dynastymasra.spring.service.MahasiswaService;
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
public class MahasiswaServiceImpl implements MahasiswaService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Mahasiswa mahasiswa) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.persist(mahasiswa);
    }

    @Override
    public Mahasiswa update(Integer id, Mahasiswa mahasiswa) {
        Mahasiswa oldMahasiswa = findById(id);
        oldMahasiswa.setNim(mahasiswa.getNim());
        oldMahasiswa.setName(mahasiswa.getName());
        oldMahasiswa.setEmail(mahasiswa.getEmail());
        oldMahasiswa.setSex(mahasiswa.getSex());
        oldMahasiswa.setNumber(mahasiswa.getNumber());

        return entityManager.merge(oldMahasiswa);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Mahasiswa mahasiswa) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(mahasiswa);
    }

    @Override
    public void delete(Integer id) {
        //To change body of implemented methods use File | Settings | File Templates.
        entityManager.remove(findById(id));
    }

    @Override
    public List<Mahasiswa> findAll() {
        List<Mahasiswa> result = entityManager.createQuery("SELECT m FROM Mahasiswa m ORDER BY m.nim", Mahasiswa.class).getResultList();
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Mahasiswa findById(Integer id) {
        return entityManager.find(Mahasiswa.class, id);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
