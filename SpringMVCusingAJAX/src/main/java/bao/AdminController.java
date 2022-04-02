package bao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.*;
@Controller
public class AdminController {
	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin()
	{
		return new ModelAndView("adminview","command",new Admin());
	}
	@RequestMapping("/adminlogin")
	public ModelAndView stuLogic(@ModelAttribute("jobportal")Admin s, HttpServletRequest request)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		Query q = sess.createQuery("from Admin a where a.uname=? and a.upass=?");
		q.setString(0,s.getUname());
		q.setString(1,s.getUpass());
		List lst = q.list();
		if(lst.size()>0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("uid",s.getUname());
			
			return new ModelAndView("redirect:stu.html");
		}
		sess.close();
		ModelAndView mv= new ModelAndView("adminview","command",new Admin());
		mv.addObject("error","invalid userid and password");
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView adminLogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("uid");
		return new ModelAndView("redirect:adminlogin.html");
	}
	
}
