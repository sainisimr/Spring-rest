package io.egan.Spring_rest.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egan.Spring_rest.Constants.URI;
import io.egan.Spring_rest.Service.UserService;
import io.egan.Spring_rest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins="http://mocker.egen.io/")
@RestController
@RequestMapping(value = URI.USERS)
@Api(tags="Users")
public class UserController {

	private UserService userservice;
	
	public UserController(UserService userservice){
		this.userservice = userservice;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiResponses(value={
			@ApiResponse(code=200, message="success"),
			@ApiResponse(code =500, message="internal server error")
	})
	@ApiOperation(value="Find All The Users", notes="Return list of Users")
	public List<User> findAll(){
		return userservice.findAll();
		}
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public List<User> mvcfindAll(Model model){
		model.addAttribute(userlist, userservice.findAll());
		return "users.JSp";
		}
	*/
	
	@RequestMapping(method=RequestMethod.GET, value=URI.ID_PATH_VAR)
	@ApiOperation(value="Find User", notes="Return User with specific Id")
	@ApiResponses(value={
			@ApiResponse(code=200, message="success"),
			@ApiResponse(code=404, message="page not found"),
			@ApiResponse(code =500, message="internal server error")
	})
	public User findOne(@PathVariable("id") String userId){
		return userservice.findOne(userId);
		
	}
	

	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Create a User", notes="Create a new User")
	@ApiResponses(value={
			@ApiResponse(code=200, message="success"),
			@ApiResponse(code=400, message="Bad Request"),
			@ApiResponse(code =500, message="internal server error")
	})
	public User create(@RequestBody User user){
		return userservice.create(user);
		
	}
	

	@RequestMapping(method=RequestMethod.PUT, value=URI.ID_PATH_VAR)
	@ApiOperation(value="Update User", notes="Update the value of Users")
	@ApiResponses(value={
			@ApiResponse(code=200, message="success"),
			@ApiResponse(code=404, message="Bad Request"),
			@ApiResponse(code =500, message="internal server error")
	})
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return userservice.update(id, user);
		
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value=URI.ID_PATH_VAR)
	@ApiResponses(value={
			@ApiResponse(code=200, message="success"),
			@ApiResponse(code=404, message="Bad Request"),
			@ApiResponse(code =500, message="internal server error")
	})
	@ApiOperation(value="Delete User", notes="Delete User with specific Id")
	public void delete(@PathVariable("id") String id){
		userservice.delete(id);
	}
	
}
