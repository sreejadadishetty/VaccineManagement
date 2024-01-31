package com.epam.vaccinemanagementtool.daolayer;

import com.epam.vaccinemanagementtool.entities.CovaxinVaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CovaxinVaccineInterface extends JpaRepository<CovaxinVaccineEntity, String> {
    public CovaxinVaccineEntity findByVaccineCenter(String center);
}
