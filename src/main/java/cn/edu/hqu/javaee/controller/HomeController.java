package cn.edu.hqu.javaee.controller;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	TicketService ticketService;

	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String home(Model model) {
		List<String> destinateList=new ArrayList<>();

		destinateList=ticketService.getTicket();
		List<Ticket> list=new ArrayList<Ticket>();
		Ticket ticket=new Ticket();
		for (int i = 0; i < destinateList.size(); i++) {
			ticket.setDestinate(destinateList.get(i));
//			System.out.println(ticket.getDestinate());
			list.add(ticket);
		}
		System.out.println("------------"+destinateList);
		model.addAttribute("destinateList",destinateList);
		model.addAttribute("ticketForm",new TicketForm());
		return "index";
	}
}
