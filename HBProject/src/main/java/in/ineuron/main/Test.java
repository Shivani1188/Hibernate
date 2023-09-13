package in.ineuron.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

public class Test {

	public static void main(String[] args) {
		
		//step 1. Creating a configuration object
		
		Configuration cfg=new Configuration();
		
		//step 2. configure hibernate.cfg.xml file to Configuration object
		
		cfg.configure();
		
		//step 3. create SessionFactory object
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		//step 4. Get the Session object from SessionFactory
		
		Session session=sessionFactory.openSession();
		
		//step 5. Begin the transaction within a session
		
		Transaction transaction=session.beginTransaction();
		
		Employee employee=new Employee();
		employee.setEmpid(2);
		employee.setEmpname("Dhoni");
		employee.setEmpsal(20000);
		
		//step 6. Perform operation
		
		Serializable object=session.save(employee);
		System.out.println(object);
		
		//step 7. Performing Transaction operations
		transaction.commit();
		
		//step 8. close the connection
		session.close();
		
		
	}

}
