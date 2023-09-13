package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class SaveOrUpdate {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=false;
		
		Customer customer=new Customer();
		customer.setCid(1);
		customer.setCname("Sachin Tendulkar");
		customer.setPname("shoes");
		customer.setPcost(4000.0);
		
		try
		{
			//session=HibernateUtil.getSession();
			
				transaction=session.beginTransaction();
				session.saveOrUpdate(customer);
				flag=true;
				
				
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
				System.out.println("Record is saved or updated");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record not saved or updated");
			}
			
		}
	}

}
