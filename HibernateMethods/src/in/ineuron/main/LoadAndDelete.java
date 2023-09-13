package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class LoadAndDelete {

	public static void main(String[] args) {

		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=true;
		Customer customer=null;
		Integer id=6;
		
		try
		{
			transaction=session.beginTransaction();
			customer=session.get(Customer.class, id);
			if(customer!=null)
			{
				session.delete(customer);
				flag=true;
			}
			else
			{
				System.out.println("No Record is found with the given id"+id);
				flag=false;
			}
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
				System.out.print("Record is deleted.....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record deletion is failed.....");
			}
		}
	}

}
