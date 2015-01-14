package login_hibernate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gagandeep.Singh on 1/14/2015.
 */
@Controller
public class PermissionsController {

    public boolean validatePermission(String user , String Permission) {
        return true;
    }
    @RequestMapping("Delete")
    public ModelAndView delete(HttpServletRequest request , HttpServletResponse response) {

    }
}
