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
@Table(name = "mer_reg_business")
public class MerchantBusinessDetails implements IEntity {

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
	 * Merchant Address
	 */
	@Column(name = "merchant_address")
	private String merchantAddress;
	/**
	 * Merchant name
	 */
	@Column(name = "merchant_name")
	private String merchantName;
	/**
	 * Business_category
	 */
	@Column(name = "business_category")
	private String businessCategory;
	/**
	 * Company display name.
	 */
	@Column(name = "company_display_name")
	private String companyDisplayName;
	/**
	 * Business description.
	 */
	@Column(name = "business_description")
	private String businessDescription;
	/**
	 * Merchant outlet city.
	 */
	@Column(name = "city")
	private String city;
	/**
	 * Merchant outlet postal code.
	 */
	@Column(name = "zipcode")
	private String zipcode;
	/**
	 * Merchant company registration certificate number.
	 */
	@Column(name = "company_registration_certificate_number")
	private String companyRegistrationCertificateNumber;
	/**
	 * Merchant allows bargaining.
	 */
	@Column(name = "is_bargain_allowed")
	private Boolean isBargainAllowed;

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
	 * @return the merchantAddress
	 */
	public String getMerchantAddress() {
		return merchantAddress;
	}

	/**
	 * @param merchantAddress
	 *            the merchantAddress to set
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
	 * @param merchantName
	 *            the merchantName to set
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
	 * @param businessCategory
	 *            the businessCategory to set
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
	 * @param companyDisplayName
	 *            the companyDisplayName to set
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
	 * @param businessDescription
	 *            the businessDescription to set
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
	 * @param city
	 *            the city to set
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
	 * @param zipcode
	 *            the zipcode to set
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
	 * @param companyRegistrationCertificateNumber
	 *            the companyRegistrationCertificateNumber to set
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
	 * @param isBargainAllowed
	 *            the isBargainAllowed to set
	 */
	public void setIsBargainAllowed(Boolean isBargainAllowed) {
		this.isBargainAllowed = isBargainAllowed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MerchantBusinessDetails [key=" + key + ", merchantAddress=" + merchantAddress + ", merchantName="
				+ merchantName + ", businessCategory=" + businessCategory + ", companyDisplayName=" + companyDisplayName
				+ ", businessDescription=" + businessDescription + ", city=" + city + ", zipcode=" + zipcode
				+ ", companyRegistrationCertificateNumber=" + companyRegistrationCertificateNumber
				+ ", isBargainAllowed=" + isBargainAllowed + "]";
	}

}
