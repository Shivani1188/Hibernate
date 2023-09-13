package in.ineuron.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class SaveOperation {

	public static void main(String[] args) {
		
		Session session=null;
		Transaction transaction=null;
		Boolean flag=true;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
				transaction=session.beginTransaction();
			if(transaction!=null)
			{
				PersonInfo personInfo=new PersonInfo();
				personInfo.setPname("Sachin");
				personInfo.setPaddress("MI");
				personInfo.setDob(LocalDate.of(1973, 4, 24));
				personInfo.setDoj(LocalTime.of(10, 45));
				personInfo.setDom(LocalDateTime.of(1987, 6, 21, 12, 35));
				
				session.save(personInfo);
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
				System.out.println("Object is saved");
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
