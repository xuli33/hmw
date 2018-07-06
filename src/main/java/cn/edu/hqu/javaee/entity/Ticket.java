package cn.edu.hqu.javaee.entity;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ticket")
public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@NotEmpty
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Getter
	@Setter
	@NotEmpty
	@Column(name="trainNumber")
	private String trainNumber;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="startTime")
	private Timestamp startTime;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="endTime")
	private Timestamp endTime;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="destinate")
	private String destinate;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="price")
	private double price;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="ticketNumber")
	private int ticketNumber;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Ticket ticket = (Ticket) o;

		if (Double.compare(ticket.price, price) != 0) return false;
		if (ticketNumber != ticket.ticketNumber) return false;
		if (!id.equals(ticket.id)) return false;
		if (!trainNumber.equals(ticket.trainNumber)) return false;
		if (!startTime.equals(ticket.startTime)) return false;
		if (!endTime.equals(ticket.endTime)) return false;
		return destinate.equals(ticket.destinate);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id.hashCode();
		result = 31 * result + trainNumber.hashCode();
		result = 31 * result + startTime.hashCode();
		result = 31 * result + endTime.hashCode();
		result = 31 * result + destinate.hashCode();
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + ticketNumber;
		return result;
	}
}
