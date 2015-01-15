package login_hibernate.Controllers;

import login_hibernate.Model.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Gagandeep.Singh on 1/14/2015.
 */
@Controller
public class PermissionsController {

    @RequestMapping("/subordinates")
    public ModelAndView subordinates(HttpServletRequest request , HttpServletResponse response){
        boolean status = new Service().validatePermission(request.getParameter("name") , "subordinates");
        if(!status) return new ModelAndView("message" , "message" , "<em>ERROR: </em>You Don`t have the required Permissions");

        System.out.println("finding subordinates");
        ArrayList<UsersEntity> subs = new UsersEntity().subordinates(request.getParameter("name"));
        return new ModelAndView("list-subordinates" , "subordinates" , subs);
    }

    @RequestMapping("/delete-user")
    public ModelAndView deleteUser(HttpServletRequest request , HttpServletResponse response){
        boolean status = new Service().validatePermission(request.getParameter("name") , "delete");
        if(!status) return new ModelAndView("message" , "message" , "<em>ERROR: </em>You Don`t have the required Permissions");

        int status_del = new Service().deleteUser(request.getParameter("del_user"));
        if(status_del == 0) return new ModelAndView("message" , "message" , "<em>ERROR: </em>User Does not Exist !!");
        return new ModelAndView("message" , "message" , "User Deleted !!");
    }


    @RequestMapping("/create-user")
    public ModelAndView createUser(HttpServletRequest request , HttpServletResponse response){

        boolean val_status = new Service().validatePermission(request.getParameter("name") , "create-user");
        if(!val_status) return new ModelAndView("message" , "message" , "<em>ERROR:</em> You Dont have the required Permissions");

        int status = new Service().createUser(request);

        if(status==1){
            String s = "<h3>User Created</h3>" ;
            return new ModelAndView("message" , "message" ,s);
        }else {
            String s = "<h3>Username Already Exists</h3>" ;
            return new ModelAndView("reg-error" , "message" , s);
        }

    }

}
