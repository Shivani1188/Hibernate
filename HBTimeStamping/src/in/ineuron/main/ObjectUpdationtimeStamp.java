package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectUpdationtimeStamp {

	public static void main(String[] args)
	{
		Session session=null;
		Transaction transaction=null;
		BankAccount account=null;
		Boolean flag=false;
		
		session=HibernateUtil.getSession();
		
		try
		{
			transaction=session.beginTransaction();
			long id=1L;
			
			account=session.get(BankAccount.class,id);
			if(account!=null)
			{
				account.setBalance(account.getBalance()+10000);
				flag=true;
				
			}
			else
			{
				System.out.println("Record is not available for modification...");
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
			{
				transaction.commit();
				System.out.println("object is updated");
				System.out.println("Account opened on::"+account.getOpeningDate());
				System.out.println("Account modified on::"+account.getLastUpdated());
				System.out.println("Number of modification is ::"+account.getVersion());
			}
			else
			{
				transaction.rollback();
				System.out.println("object is not saved");
			}
			HibernateUtil.closeSession(session);
		
	}
}
}