package com.epam.vaccinemanagementtool.daolayer;


import com.epam.vaccinemanagementtool.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAOInterface extends JpaRepository<UserEntity, String> {
    public UserEntity findByAadharnumberAndPassword(String aadhaar, String password);


}
