package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class ObjectCreationTimeStamp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Long idValue=null;
		Boolean flag=false;
		
		session=HibernateUtil.getSession();
		BankAccount account=new BankAccount();
		account.setHolderName("Sachin");
		account.setBalance(50000.0);
		account.setType("saving");
		
		try
		{
			transaction=session.beginTransaction();
			idValue=(Long) session.save(account);
			System.out.println("Account no is::"+idValue);
			flag=true;
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
				System.out.println("object is saved");
				System.out.println("Account opened at::"+account.getOpeningDate());
				System.out.println("Account lastly updated at::"+account.getLastUpdated());
				System.out.println("Version id is::"+account.getVersion());
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
