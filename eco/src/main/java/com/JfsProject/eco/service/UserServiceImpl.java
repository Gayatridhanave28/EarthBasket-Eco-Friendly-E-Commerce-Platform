package com.JfsProject.eco.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.JfsProject.eco.dto.Logindto;
import com.JfsProject.eco.dto.Registerdto;
import com.JfsProject.eco.dto.UpdateProfiledto;
import com.JfsProject.eco.dto.UserProfiledto;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	    private UserRepository userRepository;
	 
	
	 


	public User register(Registerdto registerdto) {
		User user = new User();

        user.setName(registerdto.getName());
        user.setEmail(registerdto.getEmail());
        user.setPassword(registerdto.getPassword());
        user.setRole("ROLE_USER");

        return userRepository.save(user);
	}

	
	public User login(Logindto logindto) {
		 User user = userRepository.findByEmail(logindto.getEmail());

	        if (user != null && user.getPassword().equals(logindto.getPassword())) {
	            return user;
	        }

	        return null;
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
		
		
		
	}
	
	@Override
	public UserProfiledto getProfile(Long userId) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    UserProfiledto dto = new UserProfiledto();

	    dto.setUserId(user.getUserId());
	    dto.setName(user.getName());
	    dto.setEmail(user.getEmail());
	    dto.setRole(user.getRole());

	    return dto;
	}
	
	@Override
	public User updateProfile(Long userId, UpdateProfiledto dto) {

	    System.out.println("Received User ID = " + userId);

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    System.out.println("Database User ID = " + user.getUserId());

	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());

	    if(dto.getPassword() != null && !dto.getPassword().trim().isEmpty()){
	        user.setPassword(dto.getPassword());
	    }

	    User updatedUser = userRepository.save(user);

	    System.out.println("Saved User ID = " + updatedUser.getUserId());

	    return updatedUser;
	}
	
	

}
