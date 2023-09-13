package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SecondLevelCacheApp {

	public static void main(String[] args) {
		
		Session session=null;
		InsurancePolicy policy=null;
		
		session=HibernateUtil.getSession();
		
		try
		{
			//get it from Database and keep it in L2 and L1 cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("1::"+policy);
			
			//get from L1 cache
			policy=session.get(InsurancePolicy.class, 1l);
			System.out.println("2::"+policy);
			
			//remove from L1 cache
			session.evict(policy);
			System.out.println();
			
			//get it from L2 cache and keep it in l1-cache
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("3::"+policy);
			
			System.out.println("------------");
			
			//removing all the objects from the L1 cache
			session.clear();
			
			try
			{
				//20 seconds idle time for the application, so remove from L2 cache
				Thread.sleep(20000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			//hit the database and get the record and keep it into L2 and L1 cache respectively
			
			policy=session.get(InsurancePolicy.class, 1L);
			System.out.println("4::"+policy);
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
