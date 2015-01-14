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
@Table(name = "role" , schema="" , catalog = "test")
public class RoleEntity implements Serializable {
    private String name;
    private String role;

    @Id
    @Column(name = "name")
    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "role")
    public String getRole(){return role;}
    public void setRole(String role){
        this.role = role;
    }

    public List allRoles(){
        //System.out.println(name);
       Configuration cfg = new Configuration();
       cfg.configure("hibernate.xml");
       SessionFactory factory = cfg.buildSessionFactory();
       Session session = factory.openSession();
       Criteria c = session.createCriteria(RoleEntity.class);
       c.add(Restrictions.eq("name", name));
       List rs = c.list();
       return rs;
    }

}
