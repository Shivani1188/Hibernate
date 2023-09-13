package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class Delete {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction =null;
		Boolean flag=true;
		
		try
		{
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Customer customer=new Customer();
			customer.setCid(5);
			
			session.delete(customer);
			flag=true;
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				transaction.commit();
				System.out.println("Record is deleted");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record deletion is failed");
			}
		}
	}

}
