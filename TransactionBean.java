package com.chitfund.Transaction;

import java.util.Date;

public class TransactionBean {
	private int tno;
	private Date date;
	private int amount;
	String fromAccount,toAccount;
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate() {
		this.date= new Date();
	}
	public void setDate(Date date) {
		this.date= date;
	}
}
