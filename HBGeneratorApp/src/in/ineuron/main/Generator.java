package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Mentor;
import in.ineuron.util.HibernateUtil;

public class Generator {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=false;
		
		try
		{
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null)
			{
				Mentor mentor=new Mentor();
				//mentor.setMid(1);
				mentor.setMname("virat");
				mentor.setNoOfLectures(2);
				mentor.setSalary(10000);
				
				Integer id=(Integer) session.save(mentor);
				System.out.println("The id of mentor is::"+id);
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
