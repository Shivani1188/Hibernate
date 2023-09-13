package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCache1 {

	public static void main(String[] args) {
		
		Session session=null;
		InsurancePolicy policy=null;
		
		session=HibernateUtil.getSession();
		
		try
		{
			//get it from Database and put it into L1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("1::"+policy);
			
			//get it from L1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("2::"+policy);
			System.out.println("================");
			
			//removing policy object from L1-cache
			session.evict(policy);
			
			//get it from database and put it into L1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("3::"+policy);
			
			//get it from L1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("4::"+policy);
			
			System.out.println("===================");
			
			//removing all objects from L1-cache
			session.clear();
			
			//get it from database and put it into L1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			
			System.out.println("5::"+policy);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
}
