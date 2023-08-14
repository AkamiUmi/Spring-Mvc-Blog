package blog.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginForm {
    @Size(min = 2, max = 30, message = "Username size should be in the range [2..30] symbols")
    private String username;
    @NotNull
    @Size(min = 6, message = "Password size should contain at list 6 symbols")
    private String password;

}
