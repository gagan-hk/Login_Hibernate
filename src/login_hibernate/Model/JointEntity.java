package login_hibernate.Model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Gagandeep.Singh on 1/15/2015.
 */
public class JointEntity {
    public boolean validatePermission(String name , String permission){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        //System.out.println("joins");
        Query q = session.createQuery("Select p.permission from  RoleEntity r , PermissionEntity p where r.name ='" + name + "' and p.permission = '" + permission +"' and r.role = p.role");
        List ls = q.list();
        if(ls.size()==0)return false;
        else return true;
    }
}
