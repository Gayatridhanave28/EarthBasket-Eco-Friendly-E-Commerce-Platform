package com.JfsProject.eco.service;

import com.JfsProject.eco.dto.Logindto;
import com.JfsProject.eco.dto.Registerdto;
import com.JfsProject.eco.dto.UpdateProfiledto;
import com.JfsProject.eco.dto.UserProfiledto;
import com.JfsProject.eco.model.User;

public interface UserService {
	User register(Registerdto registerdto);

    User login(Logindto logindto);

    User getUserById(Long userId);
    
    UserProfiledto getProfile(Long userId);

    User updateProfile(Long userId, UpdateProfiledto dto);
}
