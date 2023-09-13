package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Children;
import in.ineuron.util.HibernateUtil;

public class ChildrenSaveApp {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null)
			{
				Children children=new Children();
				children.setCid(1);
				children.setCname("Raha");
				children.setCmarks(100);
				session.save(children);
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
			{
				transaction.commit();
				System.out.println("Object is saved.....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Object is not saved.....");
			}
		}
	}
}
