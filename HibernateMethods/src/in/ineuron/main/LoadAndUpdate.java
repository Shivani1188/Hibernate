package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class LoadAndUpdate {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Customer customer=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try
		{
			int id=2;
			customer=session.get(Customer.class, id);
			if(customer!=null)
			{
				transaction=session.beginTransaction();
				customer.setCname("virat Kohli");
				session.update(customer);
				flag=true;
			}
			else
			{
				System.out.println("Record is not found with the given id::"+id);
				System.exit(0);
			}
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
			flag=false;
		}
		finally
		{
			if(flag)
			{
				transaction.commit();
				System.out.println("Record is updated.....");
			}
			else
			{
				transaction.rollback();
				System.out.print("Reacord is not updated...");
			}
		}
	}

}
