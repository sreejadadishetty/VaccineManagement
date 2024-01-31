package com.epam.vaccinemanagementtool.daolayer;

import com.epam.vaccinemanagementtool.entities.CovaxinVaccineEntity;
import com.epam.vaccinemanagementtool.entities.CovishieldVaccineEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class CentresDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<CovaxinVaccineEntity> covaxinInfo() {

        return entityManager.createQuery("from CovaxinVaccineEntity").getResultList();
    }


    public List<CovishieldVaccineEntity> covishieldInfo() {

        return entityManager.createQuery("from CovishieldVaccineEntity").getResultList();

    }


    public boolean updateCovaxinCenter(String centerName) {

        boolean flag = false;
        CovaxinVaccineEntity model = null;
        model = entityManager.find(CovaxinVaccineEntity.class, centerName);
        if (model != null && model.getCount() > 0) {
            model.setCount(model.getCount() - 1);
            entityManager.getTransaction().begin();
            entityManager.persist(model);
            entityManager.getTransaction().commit();
            flag = true;
        }
        return flag;
    }


    public boolean updateCoishieldCenter(String centerName) {
        boolean flag = false;
        CovishieldVaccineEntity model = null;
        model = entityManager.find(CovishieldVaccineEntity.class, centerName);
        if (model != null && model.getCount() > 0) {
            model.setCount(model.getCount() - 1);
            entityManager.getTransaction().begin();
            entityManager.persist(model);
            entityManager.getTransaction().commit();
            entityManager.close();
            flag = true;
        }
        return flag;
    }


}
