package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class Merge {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=false;
		Customer c1=null;
		Customer c2=null;
		Customer c3=null;
		
		c1=session.get(Customer.class, 4);
		
		try
		{
			transaction=session.beginTransaction();
			c2=new Customer();
			c2.setCid(4);
			c2.setCname("Rohit Sharma");
			c2.setPname("watch");
			c2.setPcost(7000.0);
			
			c3=(Customer) session.merge(c2);
					
			flag=true;
			
			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
			System.out.println(c1.hashCode()+"::"+c2.hashCode()+"::"+c3.hashCode());
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
				System.out.println("Object is updated using merge");
			}
			else
			{
				transaction.rollback();
				System.out.println("Object updation is failed");
			}
		}
	}

}
