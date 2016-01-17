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
import com.yoku.server.framework.dto.BaseDTO;
import com.yoku.server.infra.constants.Constants;
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
	public ResponseEntity<BaseDTO> readAllProducts(@PathVariable String merchantId /*HttpServletRequest httpRequest*/) {
		ProductService service = new ProductService();                                                                             
		MerchantProductListingResponseDTO response= service.readAllProductsForMerchant(merchantId);
		return super.buildResponse(HttpStatus.ACCEPTED, response);    
	}                       
                                 
	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/category/{category}/all", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> readCategoryAll(@PathVariable String merchantId, @PathVariable String category, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();
		service.readCategoryAll(merchantId, category);
		return null;
	}
	
	/**
	 * Read Endorsed products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return MerchantID and BusinessCategory
	 */
	@RequestMapping(value = "/endorsedBusiness", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getEndorsedBusiness(@PathVariable String merchantId, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();                                                                             
		EndorsedProductResponseDTO response= service.getEndorsedBusiness(merchantId);
		return super.buildResponse(HttpStatus.ACCEPTED, response);    
	}   
	
	
	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @param businessCategory
	 * @return List of subcategory for that business category
	 */
	@RequestMapping(value = "/{businessCategory}/subCategory", method = RequestMethod.GET, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> getSubCategoryForEndorsedProduct(@PathVariable String businessCategory, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();                                                                             
		MerchantProductSubCategoryResponseDTO response= service.getSubCategoryForEndorsedProduct(businessCategory);
		return super.buildResponse(HttpStatus.ACCEPTED, response);    
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
			@RequestBody ProductDetailsRequestDTO request /*HttpServletRequest httpRequest*/) {
		ProductService service = new ProductService();                               
		ProductDetailsResponseDTO response=service.addProductDetails(merchantId, businessCategory, request);
		return super.buildResponse(HttpStatus.ACCEPTED, response);
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
	public ResponseEntity<BaseDTO> readproductDetails(@PathVariable String merchantId, @PathVariable String productId, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();
		ProductSpecificDetailsResponseDTO response= new ProductSpecificDetailsResponseDTO();
		response=service.readProductDetails(merchantId, productId, response);
		return super.buildResponse(HttpStatus.ACCEPTED, response);
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
		ProductService service = new ProductService();
		service.update(merchantId, productId, request);
		return null;
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
	public ResponseEntity<BaseDTO> deleteProduct(@PathVariable String merchantId, @PathVariable String productId,@PathVariable String businessCategory, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();
		ProductDetailsResponseDTO response=service.deleteProduct(merchantId, productId, businessCategory);
		return super.buildResponse(HttpStatus.ACCEPTED, response);
	}
	
	/**
	 * Delete all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteAll(@PathVariable String merchantId, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();
		service.deleteAll(merchantId);
		return null;
	}
	
	/**
	 * Delete all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@RequestMapping(value = "/category/{category}/all", method = RequestMethod.DELETE, produces = Constants.APPLICATION_JSON)
	public ResponseEntity<BaseDTO> deleteCategoryAll(@PathVariable String merchantId, @PathVariable String category, HttpServletRequest httpRequest) {
		ProductService service = new ProductService();
		service.deleteCategoryAll(merchantId, category);	
		return null;
	}



}