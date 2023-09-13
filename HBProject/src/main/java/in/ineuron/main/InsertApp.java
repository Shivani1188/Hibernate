package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null)
			{
				Employee employee=new Employee();
				employee.setEmpid(4);
				employee.setEmpname("Rohit");
				employee.setEmpsal(5000);
				session.save(employee);
				flag=true;
			}
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		finally
		{
			if(flag==true)
			{
				transaction.commit();
				System.out.println("Object is inserted succesfully");
			}
			else
			transaction.rollback();
			HibernateUtil.closeSession(session);
		}
	}

}
