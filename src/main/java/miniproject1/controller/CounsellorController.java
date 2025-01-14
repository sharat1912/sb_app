package miniproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import miniproject1.dto.DashboardDto;
import miniproject1.entity.CounsellorEntity;
import miniproject1.entity.EnquiryEntity;
import miniproject1.service.CounsellorService;
import miniproject1.service.EnquiryService;

@Controller
public class CounsellorController {
	
	@Autowired
	private CounsellorService counsellorservice;
	
	@Autowired
	private EnquiryService enquiryservice;
	
	@GetMapping("/registerView")
	public String register(Model model) {
		model.addAttribute("counsellor", new CounsellorEntity());
		return "registerView";
	}
	
	@PostMapping("/registration")
	public String handleRegister(CounsellorEntity c,Model model) {
		boolean status = counsellorservice.saveCounsellor(c);
		if(status) {
			model.addAttribute("smsg","counsellor saved");
		}else {
			model.addAttribute("emsg" ,"Failed to save");
		}
		return "registerView";
		
	}
	
	
	@GetMapping("/counsellorPortal")
	public String login(Model model) {
		model.addAttribute("counsellor",new CounsellorEntity()); //this is used for form binding
		return "index";	
	} 
	
	@GetMapping("/logout")
	public String logOut(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String handleLogin(CounsellorEntity counsellor,HttpServletRequest req ,Model model) {
		CounsellorEntity c = counsellorservice.getCounsellor(counsellor.getEmail(), counsellor.getPwd());
		if(c==null) {
			model.addAttribute("emsg","invalid Credentials");
			model.addAttribute("counsellor", new CounsellorEntity());
			return "index";
		}else {
			HttpSession session = req.getSession(true);//always new session to know who logged in
			session.setAttribute("cid", c.getCounsellorId());
			
			DashboardDto dbinfo = enquiryservice.getDashboard(c.getCounsellorId());
			model.addAttribute("dashboard" ,dbinfo);
			return "dashboard";
		}
		
	}
	
	
}
