package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class MerchantRegistrationDTO extends BaseRequestDTO{
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -495263875084772187L;
	/**
	 * Registration Id.
	 */
	private String registrationId;
	/**
	 * Merchant company name.
	 */
	private String companyName;
	/**
	 * Merchant email id.
	 */
	private String emailId;
	/**
	 * Password to access application.
	 */
	private String password;
	/**
	 * Merchant phone number.
	 */
	private String phoneNumber;
	/**
	 * Merchant business type.
	 */
	private String businessType;
	/**
	 * Merchant Address
	 */
	private String merchantAddress;
	/**
	 * Merchant name
	 */
	private String merchantName;
	/**
	 * Business_category 
	 */
	private String businessCategory;
	/**
	 * Company display name.
	 */
	private String companyDisplayName;
	/**
	 * Business description.
	 */
	private String businessDescription;
	/**
	 * Merchant outlet city.
	 */
	private String city;
	/**
	 * Merchant outlet postal code.
	 */
	private String zipcode;
	/**
	 * Merchant company registration certificate number.
	 */
	private String companyRegistrationCertificateNumber;
	/**
	 * Merchant allows bargaining.
	 */
	private Boolean isBargainAllowed;
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
	 * @return the registrationId
	 */
	public String getRegistrationId() {
		return registrationId;
	}
	/**
	 * @param registrationId the registrationId to set
	 */
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * @return the merchantAddress
	 */
	public String getMerchantAddress() {
		return merchantAddress;
	}
	/**
	 * @param merchantAddress the merchantAddress to set
	 */
	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	/**
	 * @return the businessCategory
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}
	/**
	 * @param businessCategory the businessCategory to set
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	/**
	 * @return the companyDisplayName
	 */
	public String getCompanyDisplayName() {
		return companyDisplayName;
	}
	/**
	 * @param companyDisplayName the companyDisplayName to set
	 */
	public void setCompanyDisplayName(String companyDisplayName) {
		this.companyDisplayName = companyDisplayName;
	}
	/**
	 * @return the businessDescription
	 */
	public String getBusinessDescription() {
		return businessDescription;
	}
	/**
	 * @param businessDescription the businessDescription to set
	 */
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the companyRegistrationCertificateNumber
	 */
	public String getCompanyRegistrationCertificateNumber() {
		return companyRegistrationCertificateNumber;
	}
	/**
	 * @param companyRegistrationCertificateNumber the companyRegistrationCertificateNumber to set
	 */
	public void setCompanyRegistrationCertificateNumber(String companyRegistrationCertificateNumber) {
		this.companyRegistrationCertificateNumber = companyRegistrationCertificateNumber;
	}
	/**
	 * @return the isBargainAllowed
	 */
	public Boolean getIsBargainAllowed() {
		return isBargainAllowed;
	}
	/**
	 * @param isBargainAllowed the isBargainAllowed to set
	 */
	public void setIsBargainAllowed(Boolean isBargainAllowed) {
		this.isBargainAllowed = isBargainAllowed;
	}
	/**
	 * @return the companyPanNumber
	 */
	public String getCompanyPanNumber() {
		return companyPanNumber;
	}
	/**
	 * @param companyPanNumber the companyPanNumber to set
	 */
	public void setCompanyPanNumber(String companyPanNumber) {
		this.companyPanNumber = companyPanNumber;
	}
	/**
	 * @return the benefeciaryName
	 */
	public String getBenefeciaryName() {
		return benefeciaryName;
	}
	/**
	 * @param benefeciaryName the benefeciaryName to set
	 */
	public void setBenefeciaryName(String benefeciaryName) {
		this.benefeciaryName = benefeciaryName;
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
	/**
	 * For Logging.
	 */
	@Override
	public String toString() {
		return "MerchantRegistrationDTO [registrationId=" + registrationId + ", companyName=" + companyName
				+ ", emailId=" + emailId + ", password=" + password + ", phoneNumber=" + phoneNumber + ", businessType="
				+ businessType + ", merchantAddress=" + merchantAddress + ", merchantName=" + merchantName
				+ ", businessCategory=" + businessCategory + ", companyDisplayName=" + companyDisplayName
				+ ", businessDescription=" + businessDescription + ", city=" + city + ", zipcode=" + zipcode
				+ ", companyRegistrationCertificateNumber=" + companyRegistrationCertificateNumber
				+ ", isBargainAllowed=" + isBargainAllowed + ", companyPanNumber=" + companyPanNumber
				+ ", benefeciaryName=" + benefeciaryName + ", accountNumber=" + accountNumber + ", bank=" + bank
				+ ", bankBranch=" + bankBranch + ", bankIFSCCode=" + bankIFSCCode + "]";
	}
	
	
	
	

}
