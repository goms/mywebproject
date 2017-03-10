create table transactionDetail(tid integer,fromAccount varchar(20),toAccount varchar(20),tDate date,amount integer);

select * from transactionDetail;

SELECT * from transactionDetail where toAccount = 98745;

SELECT * from transactionDetail where fromAccount = 98745;