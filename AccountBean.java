package com.chitfund.Account;

import com.chitfund.Person.PersonBean;

public class AccountBean {
	String accountNumber;
	String bankname;
	public AccountBean()
	{
		accountNumber="12345";
		bankname="icici";
		balance=10000;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	int balance;
	PersonBean persondetails;
	public PersonBean getPersondetails() {
		return persondetails;
	}
	public void setPersondetails(PersonBean persondetails) {
		this.persondetails = persondetails;
	}
}
