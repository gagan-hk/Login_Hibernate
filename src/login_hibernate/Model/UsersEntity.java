package login_hibernate.Model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gagandeep.Singh on 1/9/2015.
 */
@Entity
@Table(name = "users", schema = "", catalog = "test")
public class UsersEntity {
    private String name;
    private String pwd;
    private String manager_name;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "manager_name")
    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    public boolean validate(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria c = session.createCriteria(UsersEntity.class);
        c.add(Restrictions.eq("name", name));
        List rs = c.list();

        if(rs.isEmpty()) return false;

        UsersEntity u = (UsersEntity) rs.get(0);
        if(u.getPwd().equals(pwd)) return true;
        return false;
    }

    public int insert(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Criteria c = session.createCriteria(UsersEntity.class);
        c.add(Restrictions.eq("name", name));
        List rs = c.list();

        if(!rs.isEmpty()) return -1;

        Transaction t = session.beginTransaction();
        session.persist(this);
        t.commit();
        session.close();
        return 1;
    }

    public ArrayList subordinates(String manager_name){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        //String hql = "Select U.name , U.pwd from UsersEntity U";
        //Query q = session.createQuery(hql);
        Criteria c = session.createCriteria(UsersEntity.class);
        List rs = c.list();

        ArrayList ans = new ArrayList();
        Stack st = new Stack();
        String mgr ;


        st.push(manager_name);
        while(!st.empty()){
            mgr = (String)st.pop();
            ans.add(mgr);
            System.out.println(mgr);
            Iterator it = rs.iterator();
            while(it.hasNext()){
                UsersEntity a = (UsersEntity) it.next();
                if(a.getManager_name()!=null && a.getManager_name().equals(mgr)) st.push(a.getName());
            }
        }
        return ans;
    }

}
