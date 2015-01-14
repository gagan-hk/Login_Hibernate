package login_hibernate.Controllers;


import login_hibernate.Model.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gagandeep.Singh on 1/8/2015.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request , HttpServletResponse response){
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        UsersEntity bean = new UsersEntity();
        bean.setName(user);
        bean.setPwd(pwd);
        boolean status = bean.validate();

       // bean.subordinates("admin");

        if(status) {
            String s = "Welcome "+user ;
            return new ModelAndView("login-success" , "message" ,s);
        }else {
            //System.out.print();
            return new ModelAndView("login-error" , "message" , "Invalid ID or Password");
        }
    }


}
