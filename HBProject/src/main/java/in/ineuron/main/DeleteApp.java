package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class DeleteApp {

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
				int id=4;
				Employee employee=session.get(Employee.class, id);
				if(employee!=null)
				{
					session.delete(employee);
					flag=true;
				}
				else
				{
					System.out.println("Record is not found for the given id::"+id);
				}
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
				System.out.println("Record is deleted successfully");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record deletion is failed");
			}
			HibernateUtil.closeSession(session);
		}
	}

}
