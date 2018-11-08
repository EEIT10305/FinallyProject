package controller.staff;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class StaffLogoutController {

	@RequestMapping("staffLogoutController")
	public String processStaffLogout(SessionStatus  sessionMVC, HttpSession session) {
		System.out.println("有沒有跑到清理session的controller");
		System.out.println(session.getAttribute("test"));
	    sessionMVC.setComplete();//根本刪除不瞭
		session.invalidate();
		
		return "/Login.jsp";
	}
	
}
