package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class MerchantPaymentDetailsRequestDTO extends BaseRequestDTO {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -6210143653714418731L;
	/**
	 * Company Pan number 
	 */
	private String companyPanNumber;
	/**
	 * Merchant Beneficiary name.
	 */
	private String benefeciaryName;
	/**
	 * Merchant Account number.
	 */
	private String accountNumber;
	/**
	 * Merchant Bank.
	 */
	private String bank;
	/**
	 * Merchant Bank Branch.
	 */
	private String bankBranch;
	/**
	 * Merchant Bank IFSC Code.
	 */
	private String bankIFSCCode;
	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "MerchantPaymentDetailsRequestDTO [comapnyPanNumber=" + companyPanNumber + ", beneficiaryName="
				+ benefeciaryName + ", accountNumber=" + accountNumber + ", bank=" + bank + ", bankBranch=" + bankBranch
				+ ", bankIFSCCode=" + bankIFSCCode + "]";
	}
	/**
	 * @return the comapnyPanNumber
	 */
	public String getCompanyPanNumber() {
		return companyPanNumber;
	}
	/**
	 * @param companyPanNumber the comapnyPanNumber to set
	 */
	public void setComapnyPanNumber(String companyPanNumber) {
		this.companyPanNumber = companyPanNumber;
	}
	/**
	 * @return the beneficiaryName
	 */
	public String getBenefeciaryName() {
		return benefeciaryName;
	}
	/**
	 * @param beneficiaryName the beneficiaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.benefeciaryName = beneficiaryName;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * @return the bankBranch
	 */
	public String getBankBranch() {
		return bankBranch;
	}
	/**
	 * @param bankBranch the bankBranch to set
	 */
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	/**
	 * @return the bankIFSCCode
	 */
	public String getBankIFSCCode() {
		return bankIFSCCode;
	}
	/**
	 * @param bankIFSCCode the bankIFSCCode to set
	 */
	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}
	
	
	
}
