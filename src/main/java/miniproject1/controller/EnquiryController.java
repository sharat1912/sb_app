package miniproject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import miniproject1.Impl.EnquiryServiceImpl;
import miniproject1.entity.EnquiryEntity;
import miniproject1.service.EnquiryService;



@Controller
public class EnquiryController {
	
	@Autowired
	private EnquiryService service;
	

	@GetMapping("/addenquiries")
	public String addEnquiry(Model model) {
	model.addAttribute("e",new EnquiryEntity());
		return "addEnq";
	}	
	
	@GetMapping ("/savedenquiries")
	public String viewEnquiries(EnquiryEntity e,HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		int cid = (int) session.getAttribute("cid");
		boolean status = service.addEnquiry(e,cid);
		if(status) {
			model.addAttribute("smsg","Enquiry saved");
		}else {
			model.addAttribute("emsg","Enquiry not saved to databse");
		}
		return "addEnq";	
	}
	
	@GetMapping("/enquiries")
	public String getEnquiries(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		int cid = (int) session.getAttribute("cid");
		List<EnquiryEntity> list = service.getEnquiries(new EnquiryEntity(),cid);
		model.addAttribute("enqs",list);
		model.addAttribute("EmptyEnquiry",new EnquiryEntity()); //page is loaded for first time so thats why empty dropdowns are selected
		return "viewEnquries";
	}
	
	@PostMapping("/filter-enqs")
	public String filterEnquries(EnquiryEntity enq ,HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		int cid = (int) session.getAttribute("cid");
		List<EnquiryEntity> list = service.getEnquiries(enq,cid);
		model.addAttribute("enqs",list);
		return "viewEnquries";
		
	}
	@GetMapping("/edit")
	public String editEnquiry(@RequestParam("enqId") Integer enqId,Model model) {
		EnquiryEntity enquiry = service.getEnquiry(enqId);
		model.addAttribute("enq",enquiry);
		return "addEnq";
	}
}
