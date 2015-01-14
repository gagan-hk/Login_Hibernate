package login_hibernate.Model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Gagandeep.Singh on 1/14/2015.
 */
@Entity
@Table(name = "permission" , schema="" , catalog = "test")
public class PermissionEntity implements Serializable {
    private String role;
    private String permission;

    @Id
    @Column(name = "role")
    public String getRole(){return role;}
    public void setRole(String role) {
        this.role = role;
    }

    @Id
    @Column(name = "permission")
    public String getPermission(){return permission;}
    public void setPermission(String permission){
        this.permission = permission;
    }

    public boolean validate(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria c = session.createCriteria(PermissionEntity.class);
        c.add(Restrictions.eq("role", role));
        c.add(Restrictions.eq("permission" , permission));
        List rs = c.list();
        if(rs.isEmpty()) return false;
        else return true;
    }

}
