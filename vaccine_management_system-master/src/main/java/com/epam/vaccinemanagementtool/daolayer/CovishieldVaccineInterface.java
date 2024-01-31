package com.epam.vaccinemanagementtool.daolayer;

import com.epam.vaccinemanagementtool.entities.CovishieldVaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovishieldVaccineInterface extends JpaRepository<CovishieldVaccineEntity, String> {
    public CovishieldVaccineEntity findByVaccineCenter(String centerName);

}
