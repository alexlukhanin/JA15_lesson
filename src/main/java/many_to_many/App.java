package many_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Group groupAdmin = new Group("Group Administrator");
        Group groupGuest = new Group("Group Guest");

        User user1 = new User("Tom", "tomcat", "tom@gmail.com");
        User user2 = new User("Mary", "mary", "mary@gmail.com");

        groupAdmin.addUser(user1);
        groupAdmin.addUser(user2);

        groupGuest.addUser(user1);

        user1.addGroup(groupAdmin);
        user2.addGroup(groupAdmin);
        user1.addGroup(groupGuest);

        // save to DB
        Transaction transaction = session.beginTransaction();
        session.save(groupAdmin);
        session.save(groupGuest);
        transaction.commit();


    }
}
