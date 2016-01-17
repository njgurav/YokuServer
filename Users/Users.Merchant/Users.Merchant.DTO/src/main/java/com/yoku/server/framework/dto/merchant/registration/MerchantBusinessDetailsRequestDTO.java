package com.yoku.server.framework.dto.merchant.registration;

import com.yoku.server.framework.dto.BaseRequestDTO;

public class MerchantBusinessDetailsRequestDTO extends BaseRequestDTO {
	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5576165598905745264L;
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
	 * For logging
	 */
	@Override
	public String toString() {
		return "MerchantBusinessDetailsRequestDTO [merchantAddress=" + merchantAddress + ", merchantName="
				+ merchantName + ", businessCategory=" + businessCategory + ", companyDisplayName=" + companyDisplayName
				+ ", businessDescription=" + businessDescription + ", city=" + city + ", zipcode=" + zipcode
				+ ", companyRegistrationCertificateNumber=" + companyRegistrationCertificateNumber
				+ ", isBargainAllowed=" + isBargainAllowed + "]";
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

	

}
