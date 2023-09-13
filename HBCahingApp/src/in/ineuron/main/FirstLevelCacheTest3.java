package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class FirstLevelCacheTest3 {

	public static void main(String[] args) {
		
		Session session=null;
		InsurancePolicy policy1=null;
		InsurancePolicy policy2=null;
		
		session=HibernateUtil.getSession();
		
		try
		{
			//hit database and put it into L1-cache
			policy1=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy1);
			
			//get from L1-cache and assign same reference
			policy2=session.get(InsurancePolicy.class, 1L);
			System.out.println(policy2);
			
			System.in.read();
			System.out.print(policy1.hashCode()+"::"+policy1.hashCode());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
