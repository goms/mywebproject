create table accountdetail(accountnumber integer,balance integer,bankname varchar(20),pid integer,primary key(accountnumber));

insert into accountdetail values(1212121212,15000,'icici',25880);

insert into accountdetail values(3232323232,15000,'sbi',12899);
insert into accountdetail values(9090909090,20000,'sbi',14165);

insert into accountdetail values(7676767676,30000,'cub',20886);

ALTER TABLE accountdetail
MODIFY accountnumber varchar(15);

alter table accountdetail add accnum varchar(20);
update accountdetail set accnum=accountdetail.accountnumber where bankname='cub';
select * from accountdetail;

alter table accountdetail drop primary key;
alter table accountdetail add primary key(accnum);
alter table accountdetail drop column accountnumber;


describe accountdetail;


insert into accountdetail values(40000,'icici',1,56783214);

