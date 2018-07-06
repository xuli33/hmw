package cn.edu.hqu.javaee.controller.formEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TicketForm {
	@Getter
	@Setter
	String destinate;
	@Getter
	@Setter
	String startTime;

};
