package source.crm;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCRM {

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String password;
    @Email
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String email;



    public UserCRM() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
