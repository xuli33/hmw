package cn.edu.hqu.javaee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

/**
 * Created by 凌 on 2018/7/3.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="v_ticketHistory")
public class VTicketHistory {
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

        VTicketHistory that = (VTicketHistory) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!trainNumber.equals(that.trainNumber)) return false;
        if (!startTime.equals(that.startTime)) return false;
        if (!endTime.equals(that.endTime)) return false;
        if (!destinate.equals(that.destinate)) return false;
        if (!buyTicketTime.equals(that.buyTicketTime)) return false;
        return identityCard.equals(that.identityCard);
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
        result = 31 * result + buyTicketTime.hashCode();
        result = 31 * result + identityCard.hashCode();
        return result;
    }
}
