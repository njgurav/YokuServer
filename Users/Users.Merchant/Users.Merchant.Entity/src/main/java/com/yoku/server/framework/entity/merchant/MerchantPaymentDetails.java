package com.yoku.server.framework.entity.merchant;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yoku.server.framework.entity.core.IEntity;

/**
 * Merchant Entity to Persist into database.
 */
@Entity
@Table(name = "mer_reg_payment")
public class MerchantPaymentDetails implements IEntity {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -3747671207544989201L;

	/**
	 * Merchant Key
	 */
	@EmbeddedId
	@AttributeOverride(name = "registrationId", column = @Column(name = "registration_id") )
	private MerchantKey key;

	/**
	 * Company Pan number
	 */
	@Column(name = "company_pan_number")
	private String companyPanNumber;
	/**
	 * Merchant Beneficiary name.
	 */
	@Column(name = "beneficiary_name")
	private String beneficiaryName;
	/**
	 * Merchant Account number.
	 */
	@Column(name = "account_number")
	private String accountNumber;
	/**
	 * Merchant Bank.
	 */
	@Column(name = "bank")
	private String bank;
	/**
	 * Merchant Bank Branch.
	 */
	@Column(name = "bank_branch")
	private String bankBranch;
	/**
	 * Merchant Bank IFSC Code.
	 */
	@Column(name = "bank_ifsc_code")
	private String bankIFSCCode;

	/**
	 * @return the key
	 */
	public MerchantKey getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(MerchantKey key) {
		this.key = key;
	}

	/**
	 * @return the companyPanNumber
	 */
	public String getCompanyPanNumber() {
		return companyPanNumber;
	}

	/**
	 * @param companyPanNumber
	 *            the companyPanNumber to set
	 */
	public void setCompanyPanNumber(String companyPanNumber) {
		this.companyPanNumber = companyPanNumber;
	}

	/**
	 * @return the benefeciaryName
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	/**
	 * @param beneficiaryName
	 *            the benefeciaryName to set
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
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
	 * @param bank
	 *            the bank to set
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
	 * @param bankBranch
	 *            the bankBranch to set
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
	 * @param bankIFSCCode
	 *            the bankIFSCCode to set
	 */
	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantPaymentDetails [key=" + key + ", companyPanNumber=" + companyPanNumber + ", benefeciaryName="
				+ beneficiaryName + ", accountNumber=" + accountNumber + ", bank=" + bank + ", bankBranch=" + bankBranch
				+ ", bankIFSCCode=" + bankIFSCCode + "]";
	}

}
