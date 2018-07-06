package cn.edu.hqu.javaee.controller;

import java.sql.Timestamp;
import java.util.List;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.controller.formEntity.TicketHistoryForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.entity.VTicketHistory;
import cn.edu.hqu.javaee.entity.TicketHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.edu.hqu.javaee.service.TicketService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TicketController {
	@Autowired
	TicketService ticketService;

	/*
	 * 通过目的地和开始时间查询车票
	 *
	 * @date 2018/7/3 21:28
	 * @param [ticketForm, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/searchTicketByDestinateAndStartTime", method = RequestMethod.POST)
	public String searchTicketByDestinateAndStartTime(@ModelAttribute TicketForm ticketForm, Model model) {

		List<Ticket> ticketLists=ticketService.getTicketByDestinateAndStartTime(ticketForm);

		model.addAttribute("ticketLists", ticketLists);
		return "ticketList";
	}
	/*
	 * 购买车票跳转页面
	 *
	 * @date 2018/7/3 21:29
	 * @param [ticketId, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/purchase/{ticketId}", method = RequestMethod.GET)
	public String purchaseTicket(@PathVariable String ticketId, Model model) {
		Ticket ticket = ticketService.getTicketByTicketId(Integer.parseInt(ticketId));
		model.addAttribute("ticketHistoryForm",new TicketHistoryForm());
		model.addAttribute("ticketCopy",ticket);
		return "purchaseTicket";
	}

	/*
	 * 保存购买车票记录
	 *
	 * @author 凌
	 * @date 2018/7/3 21:43
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/saveTicketHistory", method = RequestMethod.POST)
	public String saveTicketHistory(@Valid TicketHistoryForm ticketHistoryForm, RedirectAttributes model) {

		Long currenttime=System.currentTimeMillis();
		TicketHistory ticketHistory=new TicketHistory();
		ticketHistory.setBuyTicketTime(new Timestamp(currenttime));
		ticketHistory.setTicketId(ticketHistoryForm.getTicketId());
		System.out.println(ticketHistory.getBuyTicketTime()+"-----------------0");
		ticketHistory.setIdentityCard(ticketHistoryForm.getIdentityCard());
		ticketService.saveTicketHistory(ticketHistory);
		return "redirect:/index";
	}

	@RequestMapping(value = "/searchTicketHistory",method=RequestMethod.GET)
	public String searchTicketHistory( Model model) {
		return "purchaseHistory";
	}
	/*
	 * 通过身份证查看购票记录
	 *
	 * @date 2018/7/3 22:22
	 * @param [identityCard, model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "/purchaseHistoryList", method = RequestMethod.POST)
	public String searchTicketHistoryByIdentityCard(@Valid String identityCard, Model model) {
		List<VTicketHistory> ticketList=ticketService.searchTicketHistoryByIdentityCard(identityCard);
		for (int i = 0; i < ticketList.size(); i++) {
			Long currenttime=System.currentTimeMillis();
			ticketList.get(i).setBuyTicketTime(new Timestamp(currenttime));
		}
		model.addAttribute("ticketLists", ticketList);
		return "purchaseHistoryList";
	}
}
