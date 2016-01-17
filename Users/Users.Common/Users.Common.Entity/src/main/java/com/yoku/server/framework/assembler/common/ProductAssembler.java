package com.yoku.server.framework.assembler.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.yoku.server.core.assembler.IAssembler;
import com.yoku.server.core.dtos.MerchantListingDTO;
import com.yoku.server.core.dtos.MerchantProductSubCategoryDTO;
import com.yoku.server.framework.entity.common.product.Product;
import com.yoku.server.framework.entity.common.product.ProductFashion;
import com.yoku.server.framework.entity.common.product.ProductGrocery;
import com.yoku.server.framework.entity.common.product.ProductRestaurant;
import com.yoku.server.framework.entity.common.product.ProductSubCategory;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.product.dto.FashionProductDetailsResponseDTO;
import com.yoku.server.product.dto.GorceryProductDetailsResponseDTO;
import com.yoku.server.product.dto.MerchantProductListingResponseDTO;
import com.yoku.server.product.dto.MerchantProductSubCategoryResponseDTO;
import com.yoku.server.product.dto.ProductDetailsRequestDTO;
import com.yoku.server.product.dto.ProductSpecificDetailsResponseDTO;
import com.yoku.server.product.dto.RestaurantProductDetailsResponseDTO;



public class ProductAssembler implements IAssembler{

	/**
	 * Create a new Merchant Entity using the provided registration Id.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(ProductAssembler.class);
	
	public Product productEntity(String productId, String merchantId, String businessCategory, Boolean inStock) {
		Product product = new Product();
		product.setProductId(productId);
		product.setMerchantId(merchantId);
		product.setBusinessCategory(businessCategory);
		product.setInStock(inStock);
		return product;
	}
	
	public ProductFashion productFashionEntity(String productId, ProductDetailsRequestDTO requestDTO) {
		ProductFashion product = new ProductFashion();
		
		product.setProductId(productId);
		product.setCategory(requestDTO.getCategory());
		product.setDescription(requestDTO.getDescription());
		product.setPrice(requestDTO.getPricePerUnit());
		product.setQuantity(requestDTO.getFashionProductDetailsRequestDTO().getQuantity());
		product.setSubCategory(requestDTO.getFashionProductDetailsRequestDTO().getSubCategory());
		product.setSize(requestDTO.getFashionProductDetailsRequestDTO().getFashionProductDimension().getSize());
		product.setTitle(requestDTO.getTitle());
		return product;
	}
	
	public ProductGrocery productGroceryEntity(String productId, ProductDetailsRequestDTO requestDTO) {
		ProductGrocery product = new ProductGrocery();
		product.setProductId(productId);
		product.setCategory(requestDTO.getCategory());
		product.setDescription(requestDTO.getDescription());
		product.setPrice(requestDTO.getPricePerUnit());
		product.setQuantity(requestDTO.getGroceryProductDetailsRequestDTO().getQuantity());
		product.setSubCategory(requestDTO.getGroceryProductDetailsRequestDTO().getSubCategory());
		product.setTitle(requestDTO.getTitle());
		product.setUnit(requestDTO.getGroceryProductDetailsRequestDTO().getUnits());
		return product;
	}
	
	public ProductRestaurant productRestaurantEntity(String productId, ProductDetailsRequestDTO requestDTO) {
		ProductRestaurant product = new ProductRestaurant();
		product.setCategory(requestDTO.getCategory());
		product.setCuisine(requestDTO.getRestaurantProductDetailsRequestDTO().getCuisine());
		product.setDescription(requestDTO.getDescription());
		product.setPrice(requestDTO.getPricePerUnit());
		product.setTitle(requestDTO.getTitle());
		product.setProductId(productId);
		return product;
	}
	                                 
	@SuppressWarnings("unchecked")
	public MerchantProductListingResponseDTO createResponseForMerchantProductFashionListingResponseDTO(List<ProductFashion> products, String businessCategory, MerchantProductListingResponseDTO response)
	{
		List<MerchantListingDTO> productList= new ArrayList();
		
			Iterator<ProductFashion> product = products.iterator();
			                                                                                                 
			while (product.hasNext()) {
				ProductFashion productFashion=(ProductFashion)product.next();
				MerchantListingDTO merchantListingDTO= new MerchantListingDTO();
				merchantListingDTO.setIconURL("EmptyUrl");
				merchantListingDTO.setPrice(productFashion.getPrice());
				merchantListingDTO.setProductCount(products.size());
				merchantListingDTO.setProductID(productFashion.getProductId());
				merchantListingDTO.setTitle(productFashion.getTitle());

				productList.add(merchantListingDTO);
			}
			response.setMerchantListing(productList);
			return response;
		}
	@SuppressWarnings("unchecked")
	public MerchantProductListingResponseDTO createResponseForMerchantProductGroceryListingResponseDTO(List<ProductGrocery> products, String businessCategory, MerchantProductListingResponseDTO response)
	{
		List<MerchantListingDTO> productList= new ArrayList();

		Iterator<ProductGrocery> product = products.iterator();
					                                       
			while (product.hasNext()) {
				ProductGrocery productGrocery=(ProductGrocery) product.next();
				MerchantListingDTO merchantListingDTO= new MerchantListingDTO();
				merchantListingDTO.setIconURL("EmptyUrl");
				merchantListingDTO.setPrice(productGrocery.getPrice());
				merchantListingDTO.setProductCount(products.size());
				merchantListingDTO.setProductID(productGrocery.getProductId());
				merchantListingDTO.setTitle(productGrocery.getTitle());
				productList.add(merchantListingDTO);
			}
			response.setMerchantListing(productList);
			return response;
	}
	
	@SuppressWarnings("unchecked")
	public MerchantProductListingResponseDTO createResponseForMerchantProductRestaurantListingResponseDTO(List<ProductRestaurant> products, String businessCategory, MerchantProductListingResponseDTO response)
	{
			List<MerchantListingDTO> productList= new ArrayList();

		Iterator<ProductRestaurant> product = products.iterator();
                                    
			while (product.hasNext()) {
				ProductRestaurant productRestaurant=(ProductRestaurant) product.next();
				MerchantListingDTO merchantListingDTO= new MerchantListingDTO();
				merchantListingDTO.setIconURL("EmptyUrl");
				merchantListingDTO.setPrice(productRestaurant.getPrice());
				merchantListingDTO.setProductCount(products.size());
				merchantListingDTO.setProductID(productRestaurant.getProductId());
				merchantListingDTO.setTitle(productRestaurant.getTitle());
				productList.add(merchantListingDTO);
			}
			response.setMerchantListing(productList);
			return response;
		}
		
	public MerchantProductSubCategoryResponseDTO createResponseForProductSubCategoryResponseDTO(List<ProductSubCategory> productSubCategories,MerchantProductSubCategoryResponseDTO response)
	{
		List<MerchantProductSubCategoryDTO> subCategoryList= new ArrayList<MerchantProductSubCategoryDTO>();
		
		Iterator<ProductSubCategory> subcategory = productSubCategories.iterator();
        
		while (subcategory.hasNext()) {
			ProductSubCategory productSubCategory=(ProductSubCategory) subcategory.next();
			MerchantProductSubCategoryDTO merchantProductSubCategoryDTO= new MerchantProductSubCategoryDTO();
			merchantProductSubCategoryDTO.setBusinessCategory(productSubCategory.getBusinessCategory());
			merchantProductSubCategoryDTO.setSubCategory(productSubCategory.getSubCategory());
			merchantProductSubCategoryDTO.setDimesion(productSubCategory.getDimension());
		
			subCategoryList.add(merchantProductSubCategoryDTO);
		}
		response.setMerchantProductSubCategoryDTO(subCategoryList);
		return response;
	}
	
	public ProductSpecificDetailsResponseDTO createResponseForMerchantProductFashionDetailsResponseDTO(String merchantID, ProductFashion productFashion, ProductSpecificDetailsResponseDTO response){
		FashionProductDetailsResponseDTO fashionProductDetailsResponseDTO= new FashionProductDetailsResponseDTO();
		
		fashionProductDetailsResponseDTO.setProductId(productFashion.getProductId());
		fashionProductDetailsResponseDTO.setMerchantId(merchantID);
		fashionProductDetailsResponseDTO.setCategory(productFashion.getCategory());
		fashionProductDetailsResponseDTO.setDescription(productFashion.getDescription());
		fashionProductDetailsResponseDTO.setPricePerUnit(productFashion.getPrice());
		fashionProductDetailsResponseDTO.setQuantity(productFashion.getQuantity());
		fashionProductDetailsResponseDTO.setSubCategory(productFashion.getSubCategory());
		fashionProductDetailsResponseDTO.setTitle(productFashion.getTitle());
		fashionProductDetailsResponseDTO.setSize(productFashion.getSize());
		response.setFashionProductDetailsResponseDTO(fashionProductDetailsResponseDTO);
		return response;
	}
	
	public ProductSpecificDetailsResponseDTO createResponseForMerchantProductGroceryDetailsResponseDTO(String merchantID, ProductGrocery productGrocery, ProductSpecificDetailsResponseDTO response){
		
		GorceryProductDetailsResponseDTO gorceryProductDetailsResponseDTO=new GorceryProductDetailsResponseDTO();
		gorceryProductDetailsResponseDTO.setProductId(productGrocery.getProductId());
		gorceryProductDetailsResponseDTO.setMerchantId(merchantID);
		gorceryProductDetailsResponseDTO.setCategory(productGrocery.getCategory());
		gorceryProductDetailsResponseDTO.setDescription(productGrocery.getDescription());
		gorceryProductDetailsResponseDTO.setPricePerUnit(productGrocery.getPrice());
		gorceryProductDetailsResponseDTO.setQuantity(productGrocery.getQuantity());
		gorceryProductDetailsResponseDTO.setSubCategory(productGrocery.getSubCategory());
		gorceryProductDetailsResponseDTO.setTitle(productGrocery.getTitle());
		gorceryProductDetailsResponseDTO.setUnit(productGrocery.getUnit());
		response.setGorceryProductDetailsResponseDTO(gorceryProductDetailsResponseDTO);
		return response;
	}
	
	public ProductSpecificDetailsResponseDTO createResponseForMerchantProductRestaurantDetailsResponseDTO(String merchantID, ProductRestaurant productRestaurant, ProductSpecificDetailsResponseDTO response){
		
		RestaurantProductDetailsResponseDTO restaurantProductDetailsResponseDTO=new RestaurantProductDetailsResponseDTO();
		restaurantProductDetailsResponseDTO.setProductId(productRestaurant.getProductId());
		restaurantProductDetailsResponseDTO.setMerchantId(merchantID);
		restaurantProductDetailsResponseDTO.setCategory(productRestaurant.getCategory());
		restaurantProductDetailsResponseDTO.setDescription(productRestaurant.getDescription());
		restaurantProductDetailsResponseDTO.setPricePerUnit(productRestaurant.getPrice());
		restaurantProductDetailsResponseDTO.setCuisine(productRestaurant.getCuisine());
		restaurantProductDetailsResponseDTO.setTitle(productRestaurant.getTitle());		
		response.setRestaurantProductDetailsResponseDTO(restaurantProductDetailsResponseDTO);
		return response;
	}
	
}
