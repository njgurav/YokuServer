package com.yoku.server.rest.services.merchant.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoku.server.core.services.product.ProductService;
import com.yoku.server.exception.session.LoginSessionException;
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.product.dto.EndorsedProductResponseDTO;
import com.yoku.server.product.dto.MerchantProductListingResponseDTO;
import com.yoku.server.product.dto.MerchantProductSubCategoryResponseDTO;
import com.yoku.server.product.dto.ProductDetailsRequestDTO;
import com.yoku.server.product.dto.ProductDetailsResponseDTO;
import com.yoku.server.product.dto.ProductSpecificDetailsResponseDTO;
import com.yoku.server.rest.services.AbstractRestService;

/**
 * All Product related activities for a merchant
 */
@RestController
@RequestMapping("merchant/{merchantId}/products")
public class MerchantProductController extends AbstractRestService {

	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(MerchantProductController.class);

	/**
	 * Default constructor
	 */
	public MerchantProductController() {
	}

	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/allProducts", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readAllProducts(@PathVariable String merchantId) {
		MerchantProductListingResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = service.readAllProductsForMerchant(merId);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Read all products for the provided merchantId for the provided category.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/category/{category}/all", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readCategoryAll(@PathVariable String merchantId, @PathVariable String category,
			HttpServletRequest httpRequest) {
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			service.readCategoryAll(merId, category);
		} catch (LoginSessionException e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * Read Endorsed products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return MerchantID and BusinessCategory
	 */
	@RequestMapping(value = "/endorsedBusiness", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getEndorsedBusiness(@PathVariable String merchantId,
			HttpServletRequest httpRequest) {
		EndorsedProductResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = service.getEndorsedBusiness(merId);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}

		return super.buildResponse(status, response);
	}

	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @param businessCategory
	 * @return List of subcategory for that business category
	 */
	@RequestMapping(value = "/{businessCategory}/subCategory", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getSubCategoryForEndorsedProduct(@PathVariable String merchantId,
			@PathVariable String businessCategory, HttpServletRequest httpRequest) {
		MerchantProductSubCategoryResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = service.getSubCategoryForEndorsedProduct(merId, businessCategory);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Save Product into the application for the merchant.
	 * 
	 * @param merchantId
	 * @param businessCategory
	 * @return Status of the operation.
	 */
	@RequestMapping(value = "/{businessCategory}/addProducts", method = RequestMethod.POST, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> addProduct(@PathVariable String merchantId, @PathVariable String businessCategory,
			@RequestBody ProductDetailsRequestDTO request) {
		ProductDetailsResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = service.addProductDetails(merId, businessCategory, request);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Read the details of the product on the basis of product id
	 * 
	 * @param request
	 *            product details
	 * @param productId
	 *            product Id of the product to fetch details.
	 * @return Product details for the provided ProductId
	 */
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readproductDetails(@PathVariable String merchantId, @PathVariable String productId,
			HttpServletRequest httpRequest) {
		ProductSpecificDetailsResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = new ProductSpecificDetailsResponseDTO();
			response = service.readProductDetails(merId, productId, response);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Update Product into the application for the merchant.
	 * 
	 * @param request
	 *            product details
	 * @param productId
	 *            product Id of the product to be updated.
	 * @return Status of the operation.
	 */
	@RequestMapping(value = "/{productId}/update", method = RequestMethod.PUT, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> update(@PathVariable String merchantId, @PathVariable String productId,
			@RequestBody ProductDetailsRequestDTO request, HttpServletRequest httpRequest) {
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			service.update(merId, productId, request);
			status = HttpStatus.OK;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, null);
	}

	/**
	 * Delete the product on the basis of product id
	 * 
	 * @param request
	 *            product details
	 * @param productId
	 *            product Id of the product to delete.
	 * @return Status of the operation.
	 */
	@RequestMapping(value = "/{businessCategory}/{productId}/deleteProducts", method = RequestMethod.DELETE, consumes = Constants.APPLICATION_JSON, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteProduct(@PathVariable String merchantId, @PathVariable String productId,
			@PathVariable String businessCategory, HttpServletRequest httpRequest) {
		ProductDetailsResponseDTO response = null;
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			response = service.deleteProduct(merId, productId, businessCategory);
			status = HttpStatus.ACCEPTED;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, response);
	}

	/**
	 * Delete all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteAll(@PathVariable String merchantId) {
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			service.deleteAll(merId);
			status = HttpStatus.ACCEPTED;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, null);
	}

	/**
	 * Delete all products for the provided merchantId and the provided
	 * category.
	 * 
	 * @param merchantId
	 * @param category
	 * @return List of all products.
	 */
	@RequestMapping(value = "/category/{category}/all", method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteCategoryAll(@PathVariable String merchantId, @PathVariable String category) {
		HttpStatus status = null;
		try {
			String merId = super.beginMerchantSession(merchantId);
			ProductService service = new ProductService();
			service.deleteCategoryAll(merId, category);
			status = HttpStatus.ACCEPTED;
		} catch (LoginSessionException e) {
			status = HttpStatus.BAD_REQUEST;
			logger.error(e.getMessage(), e);
		}
		return super.buildResponse(status, null);
	}

}