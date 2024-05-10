package com.master.page.servlet;

public class FormData {
	 private String lrNo;
     private String consigner;
     private String consignee;
     private String item;
     private String amount;
     
     public FormData(String lrNo, String consigner, String consignee, String item, String amount) {
         this.lrNo = lrNo;
         this.consigner = consigner;
         this.consignee = consignee;
         this.item = item;
         this.amount = amount;
     }

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
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


}
