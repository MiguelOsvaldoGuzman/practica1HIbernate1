/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;//se crea una variable de tipo final sessionfactory
    private static final ThreadLocal localSession;//se crea una variable de tipo final THreadLocal hilos locales 
    
    static {
        try {
           Configuration config = new Configuration();//Crea un objeto de tipo configuracion
            config.configure("hibernate.cfg.xml");//se le ingresa al objeto conf la configuracion de nuestro archivo hibertane.cfg y se cargan las configuraciones necesarias de hibernate
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());//SE crea un objeto y se contextualiza el ssesion factory mediante la configuracion y sus propiedades
            sessionFactory = config.buildSessionFactory(builder.build());//a la variable de tipo ssesionfactory y se hace un build de la session
        } catch (Throwable ex) {//el catch :v
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);//mensaje de error
            throw new ExceptionInInitializerError(ex);//inicializa el catch
        }
        localSession = new ThreadLocal();// para una session local se crea un nuevo hilo
    }
    
    public static SessionFactory getSessionFactory(){//se crea una interfaz de tipo sessionfactory 
        return sessionFactory;//retorna la session
    }
    
     public static Session getLocalSession() {//se crea una una interfaz SEssion
        Session session = (Session) localSession.get();//se crea un objeto session se castea y se le agrega la session
        if (session == null) {//si la session es null
            session = sessionFactory.openSession();//se creara la session de cada una de la sessiones que existan
            localSession.set(session);//se le agrega a la session local , la session que se creo 
            System.out.println("\nsesion iniciada");// mensaje :v
        }
        return session;//si esto se cumplio retornara la session
    }
     
     public static void closeLocalSession() {//se crea un metodo que no tendra retorno
        Session session = (Session) localSession.get();//se crea un objeto session se castea y se le agrega la session
        if (session != null) session.close();//se destroza la session si es diferente de null
        localSession.set(null);//decimos que la session local sera nula
        System.out.println("sesion cerrada\n");//mensaje :v
    }
}
