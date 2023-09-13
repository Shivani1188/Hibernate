package in.ineuron.main;
import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Employee;

public class StandardApp {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		Integer idValue=null;
		boolean flag=false;
		
		
		cfg=new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());
		
		sessionFactory=cfg.buildSessionFactory();
		session=sessionFactory.openSession();
		
		Employee employee=new Employee();
		employee.setEmpid(1);
		employee.setEmpname("Sachin");
		employee.setEmpsal(30000);
		
		try
		{
			transaction=session.beginTransaction();
		
			idValue=(Integer)session.save(employee);
			System.out.println("Generated idValue is:"+idValue);
			flag=true;
			System.out.println("id value is::"+employee.getEmpid());
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag==true)
			{
				transaction.commit();
				
			}
			else
			{
				transaction.rollback();
				
			}
			session.close();
			sessionFactory.close();
		}
	}

}
