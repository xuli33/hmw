package cn.edu.hqu.javaee.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.hqu.javaee.controller.formEntity.TicketForm;
import cn.edu.hqu.javaee.entity.Ticket;
import cn.edu.hqu.javaee.entity.TicketHistory;
import cn.edu.hqu.javaee.entity.VTicketHistory;
import cn.edu.hqu.javaee.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class TicketRepositoryImpl implements TicketRepository {

	private static final String SQL_getTicket = "select distinct destinate from ticket";
	private static final String SQL_getTicketByDestinateAndStartTime = "select * from ticket where parsedatetime(startTime,'yyyy-MM-dd')=? and destinate=?";
	private static final String SQL_getTicketByTicketId = "select * from ticket where id=?";
	private static final String SQL_saveTicketHistory = "insert into ticketHistory (ticketId,buyTicketTime,identityCard) values(?,?,?)";
	private static final String SQL_searchTicketHistoryByIdentityCard = "select * from  v_ticketHistory WHERE identityCard=?";

	@Autowired
	private JdbcOperations jdbcOperations;

	@Override
	public List<String> getTicket(){
		List<String> list=new ArrayList<String>();
		list=jdbcOperations.query(SQL_getTicket, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("destinate");
			}

		});
		return list;
	}
	@Override
	public List<Ticket> getByDestinateAndStartTime(TicketForm ticketForm){
		List<Ticket> list=new ArrayList<Ticket>();

		list=jdbcOperations.query(SQL_getTicketByDestinateAndStartTime, new RowMapper<Ticket>() {
			@Override
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setDestinate(rs.getString("destinate"));
				ticket.setPrice(rs.getDouble("price"));
				ticket.setStartTime(rs.getTimestamp("startTime"));
				ticket.setEndTime(rs.getTimestamp("endTime"));
				ticket.setTicketNumber(rs.getInt("ticketNumber"));
				ticket.setTrainNumber(rs.getString("trainNumber"));
				return ticket;
			}
		}, ticketForm.getStartTime(),ticketForm.getDestinate());

		return list;
	}

	@Override
	public Ticket getTicketByTicketId(Integer id) {
		List<Ticket> list = new ArrayList<Ticket>();
		list = jdbcOperations.query(SQL_getTicketByTicketId, new RowMapper<Ticket>() {

			@Override
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt("id"));
				ticket.setDestinate(rs.getString("destinate"));
				ticket.setPrice(rs.getDouble("price"));
				ticket.setStartTime(rs.getTimestamp("startTime"));
				ticket.setEndTime(rs.getTimestamp("endTime"));
				ticket.setTicketNumber(rs.getInt("ticketNumber"));
				ticket.setTrainNumber(rs.getString("trainNumber"));
				return ticket;
			}

		}, id);

		if (list.size() >= 1) {
			return list.get(0);
		} else{
			return null;
		}
	}
	@Override
	public void saveTicketHistory(TicketHistory ticketHistory){
		jdbcOperations.update(SQL_saveTicketHistory, ticketHistory.getTicketId(), ticketHistory.getBuyTicketTime(), ticketHistory.getIdentityCard());
	}

	@Override
	public List<VTicketHistory> searchTicketHistoryByIdentityCard(String identityCard){
		List<VTicketHistory> list=new ArrayList<VTicketHistory>();
		list=jdbcOperations.query(SQL_searchTicketHistoryByIdentityCard, new RowMapper<VTicketHistory>() {

			@Override
			public VTicketHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
				VTicketHistory ticket=new VTicketHistory();
				ticket.setId(rs.getInt("id"));
				ticket.setDestinate(rs.getString("destinate"));
				ticket.setPrice(rs.getDouble("price"));
				ticket.setStartTime(rs.getTimestamp("startTime"));
				ticket.setEndTime(rs.getTimestamp("endTime"));
				ticket.setTrainNumber(rs.getString("trainNumber"));
				ticket.setIdentityCard(rs.getString("identityCard"));
				return ticket;
			}

		}, identityCard);
		return list;
	}

}
