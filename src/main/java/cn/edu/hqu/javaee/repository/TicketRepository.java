package cn.edu.hqu.javaee.repository;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.entity.VTicketHistory;
import org.springframework.stereotype.Repository;
import cn.edu.hqu.javaee.entity.TicketHistory;

import java.util.List;

@Repository
public interface TicketRepository{
    public List<String> getTicket();
    public List<Ticket> getByDestinateAndStartTime(TicketForm TicketForm);
    public Ticket getTicketByTicketId(Integer id);
    public void saveTicketHistory(TicketHistory ticketHistory);
    public List<VTicketHistory> searchTicketHistoryByIdentityCard(String identityCard);
}
