package bao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Admin;
import model.Student;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxinsert")
	public ModelAndView ajax()
	{
		return new ModelAndView("stuinsert");
	}
	@RequestMapping("/ajaxlogic")
	public ModelAndView ajaxlogic(HttpServletRequest request)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Student s = new Student();
		s.setRno(Integer.parseInt(request.getParameter("rno")));
		s.setName(request.getParameter("name"));
		sess.save(s);
		tx.commit();
		sess.close();
		return new ModelAndView("success");
	}
}
