package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class PolicyInsertion {

	public static void main(String[] args) {

		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		InsurancePolicy policy=null;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null)
			{
				policy=new InsurancePolicy();
				policy.setPolicyName("Jan-Dhan");
				policy.setCompany("LIC");
				policy.setPolicyType("quartely");
				policy.setTenure("2");
				session.save(policy);
				System.out.println(policy);
				flag=true;
				
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
				System.out.print("Object is saved");
			}
			else
			{
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
