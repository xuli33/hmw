package cn.edu.hqu.javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ticketHistory")
public class TicketHistory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//注意@Column中的name如果采用驼峰写法会映射到数据库列时会自动转换成下划线写法
	//比如postedTime会被映射到数据库的posted_Time，如果不小心就会发生数据库列找不到的问题
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="ticketId")
	private Integer ticketId;
	@Getter
	@Setter
	@NotEmpty
	@Column(name="buyTicketTime")
	private Timestamp buyTicketTime;

	@Getter
	@Setter
	@NotEmpty
	@Column(name="identityCard")
	private String identityCard;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TicketHistory that = (TicketHistory) o;

		if (!id.equals(that.id)) return false;
		if (!ticketId.equals(that.ticketId)) return false;
		if (!buyTicketTime.equals(that.buyTicketTime)) return false;
		return identityCard.equals(that.identityCard);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + ticketId.hashCode();
		result = 31 * result + buyTicketTime.hashCode();
		result = 31 * result + identityCard.hashCode();
		return result;
	}
}
