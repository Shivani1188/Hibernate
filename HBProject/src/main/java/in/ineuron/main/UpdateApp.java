package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
			transaction=session.beginTransaction();
			if(transaction!=null)
			{
				Employee employee=new Employee();
				employee.setEmpid(5);
				employee.setEmpname("Hardik pandya");
				employee.setEmpsal(1000);
				session.saveOrUpdate(employee);
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
				System.out.println("Object updated successfully");
			}
			else
			{
				transaction.rollback();
				System.out.println("object updation is failed");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
