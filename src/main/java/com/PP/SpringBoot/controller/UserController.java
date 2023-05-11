package com.PP.SpringBoot.controller;
import com.PP.SpringBoot.model.User;
import com.PP.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String home(Model mav) {
		mav.addAttribute("listUser",userService.getListUsers());
		return "all-users";
	}
	@GetMapping("/createNewUser")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "createUser";
	}
	@PostMapping()
	public String save(@ModelAttribute("user") User theuser){
		userService.addUser(theuser);
		return "redirect:/";
	}
	@GetMapping("/editUser/{id}")
	public String updateUser(@PathVariable("id") long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "updateUser";
	}
	@PostMapping("/updateUser")
	public String update(@ModelAttribute("update") User user) {
		userService.changeUser(user);
		return "redirect:/";
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		userService.removeUser(id);
		return "redirect:/";
	}



}
