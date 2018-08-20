package pojo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		return configuration.buildSessionFactory(builder.build());

	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}