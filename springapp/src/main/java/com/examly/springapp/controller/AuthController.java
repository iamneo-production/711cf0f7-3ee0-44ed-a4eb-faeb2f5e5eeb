package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IUserModel;
import com.examly.springapp.model.UserModel;


@RestController
public class AuthController {

	@Autowired
	IUserModel iUser;
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserModel user){
		try {
		UserModel u= iUser.getUseByEmail(user.getEmail());
		 if(u==null) {
			 return false;
		 }
		 else if (!u.getPassword().equals(user.getPassword())) {
			 return false;
		}
		}catch (Exception e) {
			return false;
		}
		return true;		
	}
	

	@PostMapping("/signup")
	public boolean signup(@RequestBody UserModel user){
		try {
			UserModel u=iUser.save(user);
			if(u==null) {
				return false;
			}

			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
}
