package com.master.page.servlet;

import java.util.List;

public class Usern {
	private String lrno;
	private String consigner;
	private String consignee;
	private String item;
	private String amount;
	
	public String getLrno() {
		return lrno;
	}
	public void setLrno(String lrno) {
		this.lrno = lrno;
	}
	public String getConsigner() {
		return consigner;
	}
	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
	    return "Usern [lrno=" + lrno + ", consigner=" + consigner + ", consignee=" + consignee + ", item=" + item + ", amount=" + amount + "]";
	}


}
