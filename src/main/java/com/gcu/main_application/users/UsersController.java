package com.gcu.main_application.users;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for directing to pages for creating, listing, and editing Users.
 */
@Controller
public class UsersController {
	//logger
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	/** The users repository interface. */
	@Autowired UsersRepositoryInterface usersRepositoryInterface;
	
	/**
	 * Show form to create new user in database
	 *
	 * @param model the model
	 * @return the signup page
	 */
	@GetMapping("/signup")
	public String signup(Model model) 
	{
		logger.info("signup started");
		model.addAttribute("userInfo", new UsersModel());
		logger.info("signup ending");
		return "signup";
	}
	
	/**
	 * Creates the user.
	 *
	 * @param userInfo the user info
	 * @param model the model
	 * @return the signup page
	 */
	@PostMapping("/signup")
    public String createUser(@ModelAttribute UsersModel userInfo, Model model) {
		logger.info("createUser started");

        // Save the new user to the database
        usersRepositoryInterface.save(userInfo);

        // Send user to the form to be displayed
        model.addAttribute("userInfo", userInfo);
		logger.info("createUser ending");

        return "signup"; // Redirect back to the signup page
    }
	
	/**
	 * List all of the users in the database
	 *
	 * @param model the model
	 * @return the userslist page
	 */
	@GetMapping("/userslist")
	public String listAllUsers(Model model) 
	{
		logger.info("listAllUsers starting");
		List<UsersModel> userList = (List<UsersModel>) usersRepositoryInterface.findAll();
		model.addAttribute("userList", userList);
		logger.info("listAllUsers ending");
		return "userslist";
	}
	
	/**
	 * Show edit form to edit the selected user.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the edituser page with the selected user
	 */
	@GetMapping("/edituser/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		logger.info("showEditForm starting");
	    // Retrieve the user from the database based on the ID
	    Optional<UsersModel> userOptional = usersRepositoryInterface.findById(id);

        UsersModel user = userOptional.get();
        model.addAttribute("user", user);
		logger.info("showEditForm ending");
        return "edituser"; 
	}

	/**
	 * Edit the user and then redirect to the users list.
	 *
	 * @param id the id
	 * @param updatedUser the updated user
	 * @return the userslist page
	 */
	@PostMapping("/edituser/{id}")
	public String processEditForm(@PathVariable int id, @ModelAttribute UsersModel updatedUser) {
		logger.info("processEditForm starting");
	    // Retrieve the user from the database based on the ID
	    Optional<UsersModel> userOptional = usersRepositoryInterface.findById(id);

        UsersModel user = userOptional.get();
        // Update the user's information with the values from the form
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPassword(updatedUser.getPassword());

        // Save the updated user to the database
        usersRepositoryInterface.save(user);
		logger.info("processEditForm ending");

        return "redirect:/userslist"; // Redirect back to the user list page
	}
	
	/**
	 * Delete single user from database
	 * 
	 * @param id the id_users
	 * @return the userslist page
	 */
	@GetMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {
		logger.info("deleteUser starting");
		usersRepositoryInterface.deleteById(id);
		logger.info("deleteUser ending");
		
		return "redirect:/userslist"; // Redirect back to the user list page
	}
}
