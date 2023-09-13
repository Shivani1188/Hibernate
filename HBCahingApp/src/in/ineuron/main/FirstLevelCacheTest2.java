package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		InsurancePolicy policy=null;
		
		session=HibernateUtil.getSession();
	
		try
		{
			policy=session.get(InsurancePolicy.class, 1L);
			if(policy!=null)
			{
				System.out.println("Record found and displayed");
				System.out.println(policy);
				transaction=session.beginTransaction();
				policy.setTenure("9");
				session.update(policy);
				policy.setTenure("30");
				session.update(policy);
				flag=true;
			}
			else
			{
				System.out.println("Record is not found");
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
				System.out.println("Object is updated.....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Object is not updated...");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
