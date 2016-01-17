package com.yoku.server.framework.assembler.common;

import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.framework.entity.common.Address;
import com.yoku.server.framework.entity.common.AddressKey;

/**
 * Address Assembler
 */
public class AddressAssembler {
	/**
	 * Convert entity to data transfer object.
	 * 
	 * @param address
	 *            Address Entity from a persistent store.
	 * @return
	 */
	public AddressDTO fromEntity(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		LocationDTO location = new LocationDTO();
		location.setDescription(address.getDescription());
		location.setLatitude(address.getLatitude());
		location.setLongitude(address.getLongitude());
		location.setPlaceId(address.getPlaceId());
		location.setTitle(address.getTitle());
		addressDTO.setLocation(location);
		addressDTO.setId(address.getKey().getId());
		addressDTO.setCity(address.getCity());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setLandmark(address.getLandmark());
		addressDTO.setState(address.getState());
		addressDTO.setZipcode(address.getZipcode());
		addressDTO.setLine1(address.getLine1());
		addressDTO.setLine2(address.getLine2());

		return addressDTO;
	}

	/**
	 * Create address entity from address DTO to persist to data-store.
	 * 
	 * @param addressDTO
	 * @return
	 */
	public Address toEntity(AddressDTO addressDTO) {
		Address address = new Address();
		AddressKey key = new AddressKey();
		key.setId(addressDTO.getId());
		address.setKey(key);
		address.setCity(addressDTO.getCity());
		address.setCountry(addressDTO.getCountry());
		address.setLandmark(addressDTO.getLandmark());
		address.setState(addressDTO.getState());
		address.setZipcode(addressDTO.getZipcode());
		address.setLine1(addressDTO.getLine1());
		address.setLine2(addressDTO.getLine2());
		address.setPlaceId(addressDTO.getLocation().getPlaceId());
		address.setDescription(addressDTO.getLocation().getDescription());
		address.setLatitude(addressDTO.getLocation().getLatitude());
		address.setLongitude(addressDTO.getLocation().getLongitude());
		address.setTitle(addressDTO.getLocation().getTitle());
		return address;
	}
}
