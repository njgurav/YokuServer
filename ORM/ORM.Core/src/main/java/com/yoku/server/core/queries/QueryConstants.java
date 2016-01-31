package com.yoku.server.core.queries;

/**
 * Contains all the sql queries used in the application.
 */
public final class QueryConstants {

	/**
	 * Check if all registration tables have merchant registration data.
	 * <ul>
	 * <li>mer_reg_master</li>
	 * <li>mer_reg_primary</li>
	 * <li>mer_reg_business</li>
	 * <li>mer_reg_payment</li>
	 * </ul>
	 * <br><br>
	 * PlaceHolders :
	 * <ol>
	 * <li>reg_id : Merchant Registration Id</li>
	 * </ol>
	 */
	public static final String FETCH_MERCHANT_DATA_IF_REG_SUCCESS = "SELECT m.registration_id,s.merchant_name,y.email_id,y.phone_number "
			+ "FROM mer_reg_master m join mer_reg_primary y "
			+ "on (m.registration_id = y.registration_id and m.registration_id=:reg_id) JOIN mer_reg_business s "
			+ "on (m.registration_id = s.registration_id ) JOIN mer_reg_payment t"
			+ "on (m.registration_id = t.registration_id)";

	/**
	 * Fetches nearby merchants details from <b>mer_reg_primary</b> table and
	 * <b>merchant_master</b> table; if the address stored for the merchant in
	 * <b>tbl_address</b> table and the latitude and longitude stored in
	 * <b>tbl_location</b> satisfies the condition that the merchant lies within
	 * the specified radius. In query <i>user_type</i> in tbl_address table is set to
	 * <b>'MERCHANT'</b> for fetching merchant data.
	 * <br><br>
	 * PlaceHolders :
	 * <ol>
	 * <li>cur_lat : Current customer location latitude</li>
	 * <li>cur_long : Current customer location longitude</li>
	 * <li>radius : Radius for the query</li>
	 * </ol>
	 */
	public static final String FETCH_NEARBY_MERCHANTS = "select m.merchant_id , p.company_name ,p.phone_number , p.business_type "
			+ "from merchant_master m, mer_reg_primary p  where( m.merchant_id in( "
			+ "select a.user_id from tbl_address a	where (	a.id in(select loc.id from tbl_location loc where ("
			+ "ceil((IFNULL(1,0) * ACOS((sin(IFNULL(:cur_lat,0) / 57.29577951) * SIN(IFNULL(loc.latitude,0) / 57.29577951)) +	"
			+ "(COS(IFNULL(:cur_lat,0) / 57.29577951) * COS(IFNULL(loc.latitude,0) / 57.29577951) * COS(IFNULL(loc.longitude,0) / 57.29577951 "
			+ "- IFNULL(:cur_long,0)/ 57.29577951))))*6371.39) <= :radius)) and a.user_type = 'MERCHANT'))"
			+ " and m.registration_id=p.registration_id)";
}
