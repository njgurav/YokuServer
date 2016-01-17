package com.yoku.server.core.services.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yoku.server.core.db.adapter.IRepositoryAdapter;
import com.yoku.server.core.services.AbstractService;
import com.yoku.server.framework.assembler.common.ProductAssembler;
import com.yoku.server.framework.core.orm.factory.RepositoryAdapterFactory;
import com.yoku.server.framework.entity.common.product.MerchantBusinessViewEntity;
import com.yoku.server.framework.entity.common.product.Product;
import com.yoku.server.framework.entity.common.product.ProductFashion;
import com.yoku.server.framework.entity.common.product.ProductGrocery;
import com.yoku.server.framework.entity.common.product.ProductRestaurant;
import com.yoku.server.framework.entity.common.product.ProductSubCategory;
import com.yoku.server.infra.idgeneration.factory.AbstractIdGeneratorFactory;
import com.yoku.server.infra.idgeneration.factory.GeneratorType;
import com.yoku.server.infra.idgeneration.generators.IIdGenerator;
import com.yoku.server.infra.logger.ILogger;
import com.yoku.server.infra.logger.LoggerFactory;
import com.yoku.server.product.dto.EndorsedProductResponseDTO;
import com.yoku.server.product.dto.MerchantProductListingResponseDTO;
import com.yoku.server.product.dto.MerchantProductSubCategoryResponseDTO;
import com.yoku.server.product.dto.ProductCreateAndRegisterRequestDTO;
import com.yoku.server.product.dto.ProductDetailsRequestDTO;
import com.yoku.server.product.dto.ProductDetailsResponseDTO;
import com.yoku.server.product.dto.ProductSpecificDetailsResponseDTO;

/**
 * Core Service for managing Products in the application.
 */
public class ProductService extends AbstractService {
	
	/**
	 * Logger instance.
	 */
	private static final ILogger logger = LoggerFactory.getLogger(ProductService.class);
	
	private final String FASHION_BUSINESS_CATEGORY="FASHION";
	
	private final String RESTAURANT_BUSINESS_CATEGORY="RESTAURANT";

	private final String GROCERY_BUSINESS_CATEGORY="GROCERY";

	/**
	 * RegistrationId for saving details of merchant.
	 */
	private String productRegistrationId;

	/**
	 * Public constructor
	 */

	public ProductService() {

	}

	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	@SuppressWarnings("unchecked")
	public MerchantProductListingResponseDTO readAllProductsForMerchant(String merchantId) {
		
		MerchantProductListingResponseDTO response= new MerchantProductListingResponseDTO();
		MerchantBusinessViewEntity merchantBusinessViewEntity=getMerchantBusinessDetails(merchantId);
		
		 if(FASHION_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory()))
		{
			 
			response=getAllFashionProduct(merchantId,merchantBusinessViewEntity.getBusinessCategory(), response);
		}
		else if(GROCERY_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory())){
			response=getAllGroceryProduct(merchantId,merchantBusinessViewEntity.getBusinessCategory(), response);
		}
		
		else if(RESTAURANT_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory())){
			response=getAllRestaurantProduct(merchantId,merchantBusinessViewEntity.getBusinessCategory(), response);
		}
		
		return response;
	}

	/**
	 * Delete all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	public void deleteAll(String merchantId) {
		return;
	}

	/**
	 * Read all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	public void readCategoryAll(String merchantId, String category) {
		return;
	}

	/**
	 * Delete all products for the provided merchantId.
	 * 
	 * @param merchantId
	 * @return List of all products.
	 */
	public void deleteCategoryAll(String merchantId, String category) {
		return;
	}


	/**
	 * Save Product into the application for the merchant.
	 * 
	 * @param request
	 *            product details
	 * @param productId
	 *            product Id from
	 *            {@link MerchantProduct#create(ProductCreateAndRegisterRequestDTO)}
	 * @return Status of the operation.
	 */
	public ProductDetailsResponseDTO addProductDetails(String merchantId, String businessCategory, ProductDetailsRequestDTO request) {
		ProductDetailsResponseDTO response=new ProductDetailsResponseDTO();
		
		Product product=registerProduct(merchantId,businessCategory);
		
		if(FASHION_BUSINESS_CATEGORY.equals(businessCategory))
		{
			persistFashionProduct(product,request);
		}
		else if(GROCERY_BUSINESS_CATEGORY.equals(businessCategory)){
			persistGroceryProduct(product, request);
		}
		
		else if(RESTAURANT_BUSINESS_CATEGORY.equals(businessCategory)){
			persistRestaurantProduct(product, request);
		}
		
		response.setMerchantId(merchantId);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private void persistFashionProduct(Product product, ProductDetailsRequestDTO request){
		
		ProductFashion productFashion = new ProductAssembler().productFashionEntity(product.getProductId(), request);
		IRepositoryAdapter<Product, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.createAndregister"));
		product.setProductFashion(productFashion);
		productFashion.setProduct(product);
		adapter.save(product);
		logger.info("Fashion Product with product ID: " + product.getProductId() + " persisted");	
	}

	@SuppressWarnings("unchecked")
	private void persistGroceryProduct(Product product, ProductDetailsRequestDTO request){
		
		ProductGrocery productGrocery = new ProductAssembler().productGroceryEntity(product.getProductId(), request);
		IRepositoryAdapter<Product, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.createAndregister"));
		
		productGrocery.setProduct(product);
		product.setProductGrocery(productGrocery);
		adapter.save(product);
		logger.info("Grocery Product with product ID: " + product.getProductId() + " persisted");	
	}

	@SuppressWarnings("unchecked")
	private void persistRestaurantProduct(Product product, ProductDetailsRequestDTO request){
		
		ProductRestaurant productRestaurant = new ProductAssembler().productRestaurantEntity(product.getProductId(), request);
		IRepositoryAdapter<Product, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.createAndregister"));
		
		product.setProductRestaurant(productRestaurant);
		productRestaurant.setProduct(product);
		adapter.save(product);
		logger.info("Restaurant Product with product ID: " + product.getProductId() + " persisted");	
}
	
	@SuppressWarnings("unchecked")
	private MerchantProductListingResponseDTO getAllFashionProduct(String merchantID,String businessCategory, MerchantProductListingResponseDTO response){
		
		String query;
		List<ProductFashion> products = new ArrayList<ProductFashion>();
		IRepositoryAdapter<ProductFashion, ?> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.product.ProductService..readAllProductsForMerchant"));
		
		query = "select productFashion from  ProductFashion productFashion, Product product where product.merchantId = '" + merchantID + "' and product.productId=productFashion.productId";
		products = (List<ProductFashion>) adapter.executeReadQuery(query);
		logger.info("Total product found------" + products.size());
		response = new ProductAssembler().createResponseForMerchantProductFashionListingResponseDTO((List<ProductFashion>) products, businessCategory,response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private MerchantProductListingResponseDTO getAllGroceryProduct(String merchantID,String businessCategory, MerchantProductListingResponseDTO response){
		String query;
		List<ProductGrocery> productGrocery = new ArrayList<ProductGrocery>();
		IRepositoryAdapter<ProductGrocery, ?> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.product.ProductService..readAllProductsForMerchant"));
		
		query = "select productGrocery from  ProductGrocery productGrocery, Product product where product.merchantId = '" + merchantID + "' and product.productId=productGrocery.productId";

		productGrocery = (List<ProductGrocery>) adapter.executeReadQuery(query);
		response = new ProductAssembler().createResponseForMerchantProductGroceryListingResponseDTO((List<ProductGrocery>) productGrocery, businessCategory, response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private MerchantProductListingResponseDTO getAllRestaurantProduct(String merchantID, String businessCategory,MerchantProductListingResponseDTO response){
		String query;
		List<ProductRestaurant> productRestaurant = new ArrayList<ProductRestaurant>();
		IRepositoryAdapter<ProductFashion, ?> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.product.ProductService.readAllProductsForMerchant"));
		
		
		query = "select productRestaurant from  ProductRestaurant productRestaurant, Product product where product.merchantId = '" + merchantID + "' and product.productId=productRestaurant.productId";

		productRestaurant = (List<ProductRestaurant>) adapter.executeReadQuery(query);
		response = new ProductAssembler().createResponseForMerchantProductRestaurantListingResponseDTO((List<ProductRestaurant>) productRestaurant, businessCategory, response);
		return response;                                        
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
	public void update(String merchantId, String productId, ProductDetailsRequestDTO request) {
		return;
	}

	/**
	 * Get Product details.
	 * 
	 * @param response
	 *   
	 * @param productId
	 *            product Id of the product to fetch details.
	 * @param merchantId
	 *            merchantId of the product to fetch details.
	 * @return Product details for the provided ProductId
	 */
	public ProductSpecificDetailsResponseDTO readProductDetails(String merchantId, String productId, ProductSpecificDetailsResponseDTO response) {
		MerchantBusinessViewEntity merchantBusinessViewEntity=getMerchantBusinessDetails(merchantId);

		if(FASHION_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory()))
			{
				response=getFashionProduct(merchantId,productId, response);
			}
			else if(GROCERY_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory())){
				response=getGroceryProduct(merchantId, productId, response);
			}
			
			else if(RESTAURANT_BUSINESS_CATEGORY.equals(merchantBusinessViewEntity.getBusinessCategory())){
				response=getRestaurantProduct(merchantId, productId, response);
			}
		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private ProductSpecificDetailsResponseDTO getFashionProduct(String merchantID,String productId, ProductSpecificDetailsResponseDTO response){
		IRepositoryAdapter<ProductFashion, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.getFashionProduct"));
		
		ProductFashion productFashion = adapter.fetchByID(ProductFashion.class, (Serializable)productId);
		response = new ProductAssembler().createResponseForMerchantProductFashionDetailsResponseDTO(merchantID,productFashion ,response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private ProductSpecificDetailsResponseDTO getGroceryProduct(String merchantID,String productId, ProductSpecificDetailsResponseDTO response){
		IRepositoryAdapter<ProductGrocery, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.getGroceryProduct"));
		
		ProductGrocery productGrocery = adapter.fetchByID(ProductGrocery.class, (Serializable)productId);
		response = new ProductAssembler().createResponseForMerchantProductGroceryDetailsResponseDTO(merchantID,productGrocery ,response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private ProductSpecificDetailsResponseDTO getRestaurantProduct(String merchantID, String productId,ProductSpecificDetailsResponseDTO response){
		IRepositoryAdapter<ProductRestaurant, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.getRestaurantProduct"));
		
		ProductRestaurant productRestaurant = adapter.fetchByID(ProductRestaurant.class, (Serializable)productId);
		response = new ProductAssembler().createResponseForMerchantProductRestaurantDetailsResponseDTO(merchantID, productRestaurant ,response);
		return response;                                 
	}

	/**
	 * Save Product into the application for the merchant.
	 * 
	 * @param request
	 *            product details
	 * @param productId
	 *            product Id of the product to delete.
	 * @return Status of the operation.
	 */
	@SuppressWarnings("unchecked")
	public ProductDetailsResponseDTO deleteProduct(String merchantId, String productId, String businessCategory) {
		ProductDetailsResponseDTO response=new ProductDetailsResponseDTO();
		boolean result=true;
		
		result=deleteProduct(productId);
		if(result==true){
			logger.info("Product Deleted with ID: " + productId);
		}
		response.setMerchantId(merchantId);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	private boolean deleteProduct(String productId){
		IRepositoryAdapter<Product, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.deleteProduct"));
		
		
		return adapter.deleteById(Product.class, (Serializable)productId);
	}
	
	/**
	 * @return the productRegistrationId
	 */
	public String getProductRegistrationId() {
		return productRegistrationId;
	}

	/**
	 * @param productRegistrationId
	 *            the productRegistrationId to set
	 */
	public void setProductRegistrationId(String productRegistrationId) {
		this.productRegistrationId = productRegistrationId;
	}

	@SuppressWarnings("unchecked")
	public MerchantBusinessViewEntity getMerchantBusinessDetails(String merchantId){
		String query;
		List<MerchantBusinessViewEntity> merchantBusinessViewEntity = new ArrayList<MerchantBusinessViewEntity>();
		IRepositoryAdapter<MerchantBusinessViewEntity, ?> adapter = RepositoryAdapterFactory
				.getRepositoryAdapter(super.getORMProvider("com.yoku.server.core.services.product.ProductService.createAndregister"));
		logger.info("New Product Registration initiated. Product Registration ID : " + productRegistrationId + " For the Merchant ID : "
				+ merchantId);
		query="from MerchantBusinessViewEntity merchantBusinessViewEntity where merchantBusinessViewEntity.merchantID='" + merchantId + "'";
		merchantBusinessViewEntity = adapter.executeReadQuery(query);
		return (MerchantBusinessViewEntity) merchantBusinessViewEntity.get(0);
	}
	
	public EndorsedProductResponseDTO getEndorsedBusiness(String merchantID){
		MerchantBusinessViewEntity merchantBusinessViewEntity=getMerchantBusinessDetails(merchantID);
		EndorsedProductResponseDTO response= new EndorsedProductResponseDTO();
		if(merchantBusinessViewEntity!=null){
			response.setBusinessCategory(merchantBusinessViewEntity.getBusinessCategory());
		}
		response.setMerchantID(merchantID);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public MerchantProductSubCategoryResponseDTO getSubCategoryForEndorsedProduct(String businessCategory){
		MerchantProductSubCategoryResponseDTO response=new MerchantProductSubCategoryResponseDTO();
		String query;
		List<ProductSubCategory> productSubCategory = new ArrayList<ProductSubCategory>();
		IRepositoryAdapter<ProductSubCategory, ?> adapter = RepositoryAdapterFactory.getRepositoryAdapter(
				super.getORMProvider("com.yoku.server.core.services.product.ProductService..getSubCategoryForEndorsedProduct"));
		
		query="from ProductSubCategory productSubCategory where productSubCategory.businessCategory = '" + businessCategory + "'";
		productSubCategory = (List<ProductSubCategory>) adapter.executeReadQuery(query);
		response = new ProductAssembler().createResponseForProductSubCategoryResponseDTO((List<ProductSubCategory>) productSubCategory, response);
		return response;
	}
	@SuppressWarnings("unchecked")
	private Product registerProduct(String merchantID, String businessCategory){
		IIdGenerator<String> generator = AbstractIdGeneratorFactory.getIdGenerator(GeneratorType.PRODUCT_ID);
		productRegistrationId = generator.nextId();

		Product product = new ProductAssembler().productEntity(productRegistrationId,merchantID,businessCategory,true);
	
		logger.info("Product persisted with ID : " + product.getProductId());
	
		return product;
	}
}
