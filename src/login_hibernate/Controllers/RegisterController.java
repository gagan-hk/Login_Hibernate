package login_hibernate.Controllers;

import login_hibernate.Model.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gagandeep.Singh on 1/9/2015.
 */
@Controller

public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request , HttpServletResponse response){
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        UsersEntity bean = new UsersEntity();
        bean.setName(user);
        bean.setPwd(pwd);
        int status = bean.insert();
        System.out.print(status);

        if(status==1){
            //System.out.print(status);
            String s = "<h3>Successful Registration</h3><br>Welcome "+user ;
            return new ModelAndView("login-success" , "message" ,s);
        }else {
            String s = "<h3>Username Already Exists</h3>" ;
            return new ModelAndView("reg-error" , "message" , s);
        }

    }
}
