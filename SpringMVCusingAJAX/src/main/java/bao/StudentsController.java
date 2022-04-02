package bao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Student;

@Controller
public class StudentsController {
	@RequestMapping("/stu")
	public ModelAndView stuLoad() {
		return new ModelAndView("stuview","command",new Student());
	}
	@RequestMapping("/stulogic")
	public ModelAndView stuLogic(@ModelAttribute("jobportal") Student s) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(s);
		tx.commit();
		sess.close();
		ModelAndView mv = new ModelAndView("stuview","command",new Student());
		mv.addObject("key", "Student registered successfully");
		return mv;
	}
	@RequestMapping("/studisplay")
	public ModelAndView stuDisplayRecord()
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Query q = (Query) sess.createQuery("from Student s");
		ModelAndView obj= new ModelAndView("studisplayview");
		obj.addObject("lst",q.list());
		return obj;
	}
	@RequestMapping("/EditRec")
	public ModelAndView stuEditRecord(HttpServletRequest request)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Student s = (Student)sess.load(Student.class,Integer.parseInt(request.getParameter("q")));
	
		ModelAndView obj= new ModelAndView("stufindview","command",s);
		
		return obj;
	}
	@RequestMapping("/stuupdate")
	public ModelAndView stuUpdate(@ModelAttribute("jobportal")Student s)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(s);
		tx.commit();
		sess.close();
		return new ModelAndView("redirect:studisplay.html");
	}
	@RequestMapping("/DeleteRec")
	public ModelAndView stuDeleteRecord(HttpServletRequest request)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Student s = (Student)sess.load(Student.class,Integer.parseInt(request.getParameter("q")));
	
		ModelAndView obj= new ModelAndView("studentdeleteview","command",s);
		
		return obj;
	}
	@RequestMapping("/studelete")
	public ModelAndView stuDelete(@ModelAttribute("jobportal")Student s)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(s);
		tx.commit();
		sess.close();
		return new ModelAndView("redirect:studisplay.html");
	}
}
