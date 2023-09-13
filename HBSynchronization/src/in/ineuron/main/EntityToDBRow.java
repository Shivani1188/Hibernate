package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Teacher;
import in.ineuron.util.HibernateUtil;

public class EntityToDBRow {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSession();
		Transaction transaction=null;
		Boolean flag=false;
		Teacher teacher=null;
		Integer id=1;
		
		try
		{
			transaction=session.beginTransaction();
			teacher=session.get(Teacher.class, id);
			if(teacher!=null)
			{
				System.out.println(teacher);
				teacher.setSalary(16000.0);
				flag=true;
			}
			else
			{
				System.out.println("Record is not available for the given id::"+id);
				flag=false;
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
				System.out.println("Record is updated.....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Record updation is failed.....");
			}
		}
	}

}
