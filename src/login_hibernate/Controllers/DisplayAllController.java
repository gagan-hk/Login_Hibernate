package login_hibernate.Controllers;

import login_hibernate.Model.UsersEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gagandeep.Singh on 1/12/2015.
 */
@RestController
public class DisplayAllController {

    @RequestMapping(value ="/users", produces="application/json")
    public @ResponseBody
    List<UsersEntity> ListAllUser(){

        return new Service().listAll();
    }
}
