package in.ineuron.main;

import org.hibernate.Session;

import in.ineuron.model.Teacher;
import in.ineuron.util.HibernateUtil;

public class DBtoEntityRow {

	public static void main(String[] args) {

		Session session=HibernateUtil.getSession();
		Teacher teacher=null;

		try
		{
			teacher=session.get(Teacher.class, 2);
			if(teacher!=null)
			{
				System.out.println("Record before any modification"+teacher);
				System.in.read();
				session.refresh(teacher);
				System.out.println("Record after doing some modification in database"+teacher);
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
	}

}
