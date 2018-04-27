package com.jm.cms.jms.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Transaction.java" is the root-element of our example
@XmlRootElement(name="transaction", namespace = "com.jm.cms.jms.jaxb")
public class TransactionBinding {
	    
		//XmlElement sets the name of the entities
		//@XmlElement(name = "referenceNumber")
    	private String referenceNo;
    	private String amount;
		private String accountNumber;
	    private String productCode;
	    private String quantity;	    
	    private String tranDate;
	    
		public String getReferenceNo() {
			return referenceNo;
		}
		public void setReferenceNo(String referenceNo) {
			this.referenceNo = referenceNo;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getTranDate() {
			return tranDate;
		}
		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
		}


}
