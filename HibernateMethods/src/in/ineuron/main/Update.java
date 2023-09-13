package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class Update {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=true;
		Integer id=3;
		
		//updating the entire object based on the id
		Customer customer=new Customer();
		customer.setCid(3);
		customer.setCname("MS Dhoni");
		customer.setPname("watch");
		customer.setPcost(7000.0);
		
		try
		{
			transaction=session.beginTransaction();
			session.update(customer);
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
				System.out.println("Record is updated.....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record is not updated.....");
			}
		}
	}
}
