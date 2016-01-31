package com.yoku.server.framework.assembler.common;

import com.yoku.server.core.dto.AddressDTO;
import com.yoku.server.core.dto.LocationDTO;
import com.yoku.server.framework.entity.common.Address;
import com.yoku.server.framework.entity.common.AddressKey;
import com.yoku.server.framework.entity.common.Location;
import com.yoku.server.framework.entity.common.LocationKey;

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
		addressDTO.setDescription(address.getDescription());
		addressDTO.setTitle(address.getTitle());
		addressDTO.setUserType(address.getUserType());
		addressDTO.setId(address.getKey().getId());
		addressDTO.setCity(address.getCity());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setLandmark(address.getLandmark());
		addressDTO.setState(address.getState());
		addressDTO.setZipcode(address.getZipcode());
		addressDTO.setLine1(address.getLine1());
		addressDTO.setLine2(address.getLine2());
		if (address.getLocation() != null) {
			location.setLatitude(address.getLocation().getLatitude());
			location.setLongitude(address.getLocation().getLongitude());
			location.setPlaceId(address.getLocation().getPlaceId());
		}

		addressDTO.setLocation(location);

		return addressDTO;
	}

	/**
	 * Create address entity from address DTO to persist to data-store. If
	 * addressDTO contains location data, create Location entity, and store it
	 * in the address entity.
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
		address.setUserType(addressDTO.getUserType());
		address.setUserId(addressDTO.getUserId());
		address.setCountry(addressDTO.getCountry());
		address.setLandmark(addressDTO.getLandmark());
		address.setState(addressDTO.getState());
		address.setZipcode(addressDTO.getZipcode());
		address.setLine1(addressDTO.getLine1());
		address.setLine2(addressDTO.getLine2());
		address.setDescription(addressDTO.getDescription());
		address.setTitle(addressDTO.getTitle());
		if (addressDTO.getLocation() != null) {
			Location location = new Location();
			location.setKey(key);
			location.setLatitude(
					addressDTO.getLocation().getLatitude() != null ? addressDTO.getLocation().getLatitude() : null);
			location.setLongitude(
					addressDTO.getLocation().getLongitude() != null ? addressDTO.getLocation().getLongitude() : null);
			location.setPlaceId(
					addressDTO.getLocation().getPlaceId() != null ? addressDTO.getLocation().getPlaceId() : null);
			address.setLocation(location);
		}
		return address;
	}
}
