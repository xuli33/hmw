package cn.edu.hqu.javaee.service;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.entity.TicketHistory;
import cn.edu.hqu.javaee.entity.VTicketHistory;

import java.util.List;

public interface TicketService {
	public List<String> getTicket();
	public List<Ticket> getTicketByDestinateAndStartTime(TicketForm TicketForm);
	public Ticket getTicketByTicketId(Integer id);
	public void saveTicketHistory(TicketHistory ticketHistory);
	public List<VTicketHistory> searchTicketHistoryByIdentityCard(String identityCard);
}
