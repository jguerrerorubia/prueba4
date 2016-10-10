package control;

import java.util.HashSet;
import java.util.Set;
import entidades.Motes;
import entidades.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import control.HibernateUtil;
//import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Creamos las tablas
        HibernateUtil.droptable("drop table personas");
        HibernateUtil.droptable("drop table motes");

        HibernateUtil.setup("create table personas (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,nombre varchar(30))");
        HibernateUtil.setup("create table motes (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,mote varchar(30),persona_id int)");

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        // tb vale SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        // org.​hibernate.​SessionFactory
        Session session = sessions.openSession();

        // Creamos los objetos y sus relaciones.
        Set<Motes> list1 = new HashSet<Motes>();
        list1.add(new Motes("El profe"));
        list1.add(new Motes("El guaperas"));
        list1.add(new Motes("Er tio gueno"));

        Persona p1 = new Persona("Antonio Santos");
        p1.setMotes(list1);

        Set<Motes> list2 = new HashSet<Motes>();
        list2.add(new Motes("El millonario"));
        list2.add(new Motes("El forrao"));
        list2.add(new Motes("Guillermo Puertas"));

        Persona p2 = new Persona("Bill Gates");
        p2.setMotes(list2);

        // Realiza la operación
        Transaction tx = null;
        try {
            System.out.println("--- Guardando datos");
            tx = session.beginTransaction();
            session.save(p1);
            session.save(p2);
            System.out.println("--- OK. Realizo transaccion");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                System.out.println("--- Fallo. Deshacer accion");
                tx.rollback();
            }
            System.out.println(e.getMessage());
            e.getMessage();
        } finally {
            session.close();
        }

        // Listar los datos
        HibernateUtil.checkData("select * from personas");
        HibernateUtil.checkData("select * from motes");
    }
}