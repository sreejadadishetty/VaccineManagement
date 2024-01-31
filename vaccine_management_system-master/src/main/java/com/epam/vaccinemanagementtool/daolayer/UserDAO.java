package com.epam.vaccinemanagementtool.daolayer;


import com.epam.vaccinemanagementtool.entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UserDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    void insert(EntityManager entityManager, UserEntity model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    public void register(UserEntity model) {
        UserEntity model1 = new UserEntity();
        model1.setUsername(model.getUsername());
        model1.setPassword(model.getPassword());
        model1.setAge(model.getAge());
        model1.setAadharnumber(model.getAadharnumber());
        insert(entityManager, model1);

    }

    public void updateInfo(UserEntity model) {
        UserEntity model1 = entityManager.find(UserEntity.class, model.getAadharnumber());
        model1.setVaccinename(model.getVaccinename());
        model1.setFirstdosedate(model.getFirstdosedate());
        model1.setSeconddosedate(model.getSeconddosedate());
        model1.setFirstdosecentername(model.getFirstdosecentername());
        model1.setSeconddosecentername(model.getSeconddosecentername());
        entityManager.getTransaction().begin();
        entityManager.persist(model1);
        entityManager.getTransaction().commit();
    }

    public UserEntity getDetails(String aadhaar) {
        return entityManager.find(UserEntity.class, aadhaar);
    }
}
