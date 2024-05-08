package com.songhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavigationController {
	
	@GetMapping(value="/register")
	public String Register() {
		return "registration";
	}
	
	@GetMapping(value="/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping(value="/admin/home")
	public String adminHome() {
		return null;
	}
	
	@GetMapping(value="/addsong")
	public String addSong() {
		return "song";
	}
	
//	@GetMapping(value="/playlist")
//	public String addPlaylist() {
//		return "";
//	}
	@GetMapping(value="/logout")
	public static String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
