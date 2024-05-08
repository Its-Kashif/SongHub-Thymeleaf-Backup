package com.songhub.controller;

import java.util.List;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhub.entity.Song;
import com.songhub.entity.User;
import com.songhub.service.SongService;
import com.songhub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	SongService songService;

	@PostMapping(value="/register")
	public String adduser(@Validated @ModelAttribute User user, BindingResult br) {
		
		if(br.hasErrors()) {
			return "registration";
		}
		
		userService.saveUser(user);

		return "login";

	}

	@PostMapping(value="/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model) {

		boolean validCredential=(userService.validateCredential(email, password));
		System.out.println(validCredential);
		if(validCredential) {
			session.setAttribute("email", email);
			if(userService.getRole(email).equals("admin"))
				return "adminhome";
//						else if(userService.isPremium(email)) 
//							return "viewsongs";
//						else
//							return "customerhome";
			else {
				boolean userStatus = userService.isPremium(email);
				model.addAttribute("isPremium", userStatus);
				if(userStatus) {
					System.out.println("paid user");
				}
				else {
					System.out.println("not a paid user");
				}
				List<Song> allSongs=songService.getAllSongs();
				System.out.println(allSongs);
				model.addAttribute("songs", allSongs);

				return "customerhome";
			}
		}
		else {

			return "login";
		}

	}




}
