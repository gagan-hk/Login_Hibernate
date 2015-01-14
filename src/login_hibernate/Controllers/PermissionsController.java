package login_hibernate.Controllers;

import login_hibernate.Model.PermissionEntity;
import login_hibernate.Model.RoleEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Gagandeep.Singh on 1/14/2015.
 */
@Controller
public class PermissionsController {
    @RequestMapping("validatePermission")
    public ModelAndView validatePermission(HttpServletRequest request , HttpServletResponse response) {
        String name = request.getParameter("name");
        String permission = request.getParameter("permission");
//System.out.print(name+permission);
        RoleEntity rbean = new RoleEntity();
        rbean.setName(name);
        List roles = rbean.allRoles();
        PermissionEntity pbean = new PermissionEntity();
        Boolean status = false;
      //  System.out.println(roles.size());
        for(int i=0 ; i<roles.size() ; i++ ) {
            rbean = (RoleEntity)roles.get(i);
            String role = rbean.getRole();
            pbean.setRole(role);
            pbean.setPermission(permission);
            if(pbean.validate()){ status = true ; break;}
        }

        System.out.print(status);
        if(status){
            return new ModelAndView(permission);
        }else{
            return new ModelAndView("permission-error" , "message" , "You Dont have the required Permissions");
        }
    }
}
