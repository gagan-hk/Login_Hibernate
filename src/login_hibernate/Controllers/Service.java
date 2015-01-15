package login_hibernate.Controllers;

import login_hibernate.Model.JointEntity;
import login_hibernate.Model.RoleEntity;
import login_hibernate.Model.UsersEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gagandeep.Singh on 1/15/2015.
 */
public class Service {

    public boolean validatePermission(String name , String permission) {

        return new JointEntity().validatePermission(name , permission);

    }

    public int deleteUser(String name){
        int status = new UsersEntity().deleteUser(name);
        new RoleEntity().deleteUser(name);
        return status;
    }

    public int createUser(HttpServletRequest request){
        String user = request.getParameter("new_user");
        String pwd = request.getParameter("pwd");
        String mgr = request.getParameter("manager");
        UsersEntity bean = new UsersEntity();
        bean.setName(user);
        bean.setPwd(pwd);
        bean.setManager_name(mgr);
        int status = bean.insert();
        //System.out.print(status);
        return status;
    }


}
