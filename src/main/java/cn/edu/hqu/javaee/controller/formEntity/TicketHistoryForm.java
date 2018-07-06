package cn.edu.hqu.javaee.controller.formEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by 凌 on 2018/7/5.
 */
@AllArgsConstructor
@NoArgsConstructor
public class TicketHistoryForm {

    @Getter
    @Setter
    private String identityCard;
    @Getter
    @Setter
    private int ticketId;
    @Getter
    @Setter
    private double price;
}
