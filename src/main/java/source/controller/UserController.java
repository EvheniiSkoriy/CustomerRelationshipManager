package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import source.crm.UserCRM;
import source.entity.User;
import source.exception.UserEmailException;
import source.exception.UserExistingException;
import source.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserCRM registerNewUser(

            @Valid
            @NotNull
            @RequestBody
            UserCRM userCRM
            )
    {
        User existing = userService.findByUserName(userCRM.getUserName());

        if(existing != null) {
            throw new UserExistingException("Username already exist");
        }
        existing = userService.findByEmail(userCRM.getEmail());
        if(existing != null) {
            throw new UserEmailException("Email already exist");
        }
        userService.save(userCRM);
        return userCRM;
    }
}
