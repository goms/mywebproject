create table T_XBBNHDC_PersonDetails(PID integer,GID integer,USERNAME varchar(20),NAME varchar(20));
insert into T_XBBNHDC_PersonDetails values(111,1,'goms111','goms');
insert into T_XBBNHDC_PersonDetails values(112,1,'goms112','gomathi');
insert into T_XBBNHDC_PersonDetails values(113,1,'goms113','gomathy');
select * from T_XBBNHDC_PersonDetails;
create table T_XBBNHDC_MonthRate(Month integer,Rate integer);
create table T_XBBNHDC_AccountNumber(PID integer,ACCNO integer);
create table T_XBBNHDC_AccountDetails(ACCNO integer,BANKNAME varchar(40),BALANCE integer);