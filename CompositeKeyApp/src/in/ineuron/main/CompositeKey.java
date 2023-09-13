package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjectInfo;
import in.ineuron.model.ProjectInfo;
import in.ineuron.util.HibernateUtil;

public class CompositeKey {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		try
		{
			session=HibernateUtil.getSession();
			
			if(session!=null)
				transaction=session.beginTransaction();
			
			if(transaction!=null)
			{
				ProjectInfo info=new ProjectInfo(102,904);
				ProgrammerProjectInfo projectDetails=new ProgrammerProjectInfo(info,"Virat",8,"Data Science");
				ProjectInfo id=(ProjectInfo) session.save(projectDetails);
				System.out.println("The generated value is::"+id);
				flag=true;
				
			}	
		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}
		finally
		{
			if(flag)
				transaction.commit();
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
	}

}
