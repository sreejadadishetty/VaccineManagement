package com.epam.vaccinemanagementtool.daolayer;

import com.epam.vaccinemanagementtool.entities.UserEntity;
import com.epam.vaccinemanagementtool.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserConverter {
    @Autowired
    UserDAO userDAO;

    public void putUser(UserModel model) {
        UserEntity user;
        ModelMapper mapper = new ModelMapper();
        user = mapper.map(model, UserEntity.class);
        userDAO.register(user);
    }

    public void update(UserModel model) {
        UserEntity user;
        ModelMapper mapper = new ModelMapper();
        user = mapper.map(model, UserEntity.class);
        userDAO.updateInfo(user);
    }

    public UserModel getUser(String aadhaar) {
        UserModel model = null;
        UserEntity entity = userDAO.getDetails(aadhaar);
        if (entity != null) {
            ModelMapper mapper = new ModelMapper();
            model = mapper.map(entity, UserModel.class);
        }
        return model;
    }

    public UserEntity dtoToEntity(UserModel model) {
        UserEntity user;
        ModelMapper mapper = new ModelMapper();
        user = mapper.map(model, UserEntity.class);
        return user;
    }

    public UserModel entityToDto(UserEntity entity) {
        UserModel model = null;
        if (entity != null) {
            ModelMapper mapper = new ModelMapper();
            model = mapper.map(entity, UserModel.class);
        }
        return model;
    }

}
