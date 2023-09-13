package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class VersionInsertion {

	public static void main(String[] args) {

		Session session=null;
		Transaction transaction=null;
		Integer IdValue=null;
		Boolean flag=false;
		
		session=HibernateUtil.getSession();
		MobileCustomer mobileCustomer=new MobileCustomer();
		mobileCustomer.setCname("sachin");
		mobileCustomer.setMobileNo(982233446);
		mobileCustomer.setCallerTune("KGF-2");
		
		try
		{
			transaction=session.beginTransaction();
			IdValue =(Integer)session.save(mobileCustomer);
			System.out.println("id value is::"+IdValue);
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
				System.out.print("Object is saved");
			}
			else
			{
				transaction.rollback();
				System.out.print("Object is not saved");
			}
			HibernateUtil.getSession();
			
		}
	}
}
