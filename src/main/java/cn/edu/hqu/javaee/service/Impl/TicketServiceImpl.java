package cn.edu.hqu.javaee.service.Impl;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.entity.TicketHistory;
import cn.edu.hqu.javaee.entity.VTicketHistory;
import cn.edu.hqu.javaee.repository.TicketRepository;
import cn.edu.hqu.javaee.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
    TicketRepository ticketRepository;

	@Override
	public List<String> getTicket(){
		return ticketRepository.getTicket();
	}
	@Override
	public List<Ticket> getTicketByDestinateAndStartTime(TicketForm TicketForm) {
		return ticketRepository.getByDestinateAndStartTime(TicketForm);
	}
	@Override
	public Ticket getTicketByTicketId(Integer id) {
		return ticketRepository.getTicketByTicketId(id);
	}
	@Override
	public void saveTicketHistory(TicketHistory ticketHistory){
		ticketRepository.saveTicketHistory(ticketHistory);
	}
	@Override
	public List<VTicketHistory> searchTicketHistoryByIdentityCard(String identityCard){
		return ticketRepository.searchTicketHistoryByIdentityCard(identityCard);
	}
}
