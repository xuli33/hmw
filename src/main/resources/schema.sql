drop view if exists v_ticketHistory;
drop table if exists ticketHistory;
drop table if exists ticket cascade;
create table ticket (
  id integer auto_increment PRIMARY KEY,
  trainNumber varchar(4) not null,
  startTime datetime not null,
  endTime datetime not null,
  destinate varchar(25) not null,
  price double  not null,
  ticketNumber int not null
)AUTO_INCREMENT=1;

create table ticketHistory (
  id integer auto_increment primary key,
  ticketId integer,
  buyTicketTime datetime not null,
  identityCard varchar(20) not null,
  foreign key(ticketId) references ticket(id)
)AUTO_INCREMENT=1;

create view v_ticketHistory AS
  select ticket.id as id,
  ticket.trainNumber as trainNumber,
  ticket.startTime as startTime,
  ticket.endTime as endTime,
  ticket.destinate as destinate,
  ticket.price as price,
  ticketHistory.buyTicketTime as buyTicketTime,
  ticketHistory.identityCard as identityCard
  FROM ticket left join ticketHistory on ticket.id = ticketHistory.ticketId;