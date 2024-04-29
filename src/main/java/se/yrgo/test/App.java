package se.yrgo.test;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Animal;
import se.yrgo.domain.Zoo;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static SessionFactory sessionFactory = null;
    private static Session session;

    public static void main(String[] args) {
        Animal bob = new Animal("Bob", 90032002, "Grizzly bear", 1991, true);
        Animal lucy = new Animal("Lucy", 90092402, "Flamingo", 2020);
        Animal dolly = new Animal("Dolly", 90092973, "Sheep", 2024);
        Zoo theZoo = new Zoo("Sunnyside Zoo", "Hiker's Road 19141, Port Venue, AZ", 1986);

        List<Animal> animalList = new ArrayList(List.of(
        bob, lucy, dolly
        ));

        SessionFactory sf = getSessionFactory();

        try {
            session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.save(theZoo);

            animalList.forEach(obj -> {
                session.save(obj);
                theZoo.addAnimalToZoo(obj);
            });
            tx.commit();

            // Retrieve the zoo from database
            Zoo databaseZoo = session.get(Zoo.class, 1);
            var databaseZooAnimals = databaseZoo.getZooAnimals();

            // Print info about all animals in the zooAnimals list of the databaseZoo
            databaseZooAnimals.forEach((obj) -> System.out.println(obj));

        } catch (Error ex) {
            System.err.println("Error" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure();

            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
