package EShop.entityservices.dao.entityloader.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;

@SessionScoped
public class ProductLoaderFacade implements IProductLoaderFacade, Serializable  {
	
	@Inject 
	private IEntityLoader<Product, Product> productLoader;
	@Inject
	private IEntityLoader<Articulo, Product> articuloLoader;
	@Inject
	private IEntityLoader<Oferta, Articulo> ofertaLoader;
	
	private Product selectedProduct;
	private Articulo selectedArticulo;
	private Oferta selectedOferta;
	
	

	@Override
	public void setProductFileName(String productFileName) {
		getProductLoader().setFileName(productFileName);
	}

	@Override
	public String getProductFileName() {
		return getProductLoader().getFileName();
	}

	@Override
	public void setArticuloFileName(String articuloFileName) {
		getArticuloLoader().setFileName(articuloFileName);		
	}

	@Override
	public String getArticuloFileName() {
		return getArticuloLoader().getFileName();
	}

	@Override
	public void setOfertaFileName(String ofertaFileName) {
		getOfertaLoader().setFileName(ofertaFileName);		
	}

	@Override
	public String getOfertaFileName() {
		return getOfertaLoader().getFileName();
	}

	@Override
	public void loadProductFromFile() {
		getProductLoader().loadFromXLSFile();		
	}

	@Override
	public void loadArticulosFromFile() {
		getArticuloLoader().loadFromXLSFile();		
	}

	@Override
	public void loadOfertasFromFile() {
		getOfertaLoader().loadFromXLSFile();		
	}

	@Override
	public void bindArticulosListToParentProduct() {
		getArticuloLoader().bindToParentEntity(getSelectedProduct());		
	}

	@Override
	public void bindOfertasListToParentArticulo() {
		getOfertaLoader().bindToParentEntity(getSelectedArticulo());		
	}

	@Override
	public void createProducts() {
		getProductLoader().persistList();		
	}

	@Override
	public void createArticulos() {
		getArticuloLoader().persistList();		
	}

	@Override
	public void createOfertas() {
		getOfertaLoader().persistList();		
	}

	@Override
	public IEntityLoader<Product, Product> getProductLoader() {
		return productLoader;
	}

	@Override
	public IEntityLoader<Articulo, Product> getArticuloLoader() {
		return articuloLoader;
	}

	@Override
	public IEntityLoader<Oferta, Articulo> getOfertaLoader() {
		return ofertaLoader;
	}

	public void setProductLoader(IEntityLoader<Product, Product> productLoader) {
		this.productLoader = productLoader;
	}

	public void setArticuloLoader(IEntityLoader<Articulo, Product> articuloLoader) {
		this.articuloLoader = articuloLoader;
	}

	public void setOfertaLoader(IEntityLoader<Oferta, Articulo> ofertaLoader) {
		this.ofertaLoader = ofertaLoader;
	}

	@Override
	public Product getSelectedProduct() {
		return this.selectedProduct;
	}

	@Override
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	@Override
	public Articulo getSelectedArticulo() {
		return this.selectedArticulo;
	}

	@Override
	public void setSelectedArticulo(Articulo selectedArticulo) {
		this.selectedArticulo = selectedArticulo;
	}

	@Override
	public void setSelectedOferta(Oferta selectedOferta) {
		this.selectedOferta = selectedOferta;
	}

	@Override
	public Oferta getSelectedOferta() {
		return this.selectedOferta;
	}

	@Override
	public String getProductSheetName() {
		return getProductLoader().getSheetName();
	}

	@Override
	public void setProductSheetName(String sheetName) {
		getProductLoader().setSheetName(sheetName);
	}

	@Override
	public String getArticuloSheetName() {
		return getArticuloLoader().getSheetName();
	}

	@Override
	public void setArticuloSheetName(String sheetName) {
		getArticuloLoader().setSheetName(sheetName);		
	}

	@Override
	public String getOfertaSheetName() {
		return getOfertaLoader().getSheetName();
	}

	@Override
	public void setOfertaSheetName(String sheetName) {
		getOfertaLoader().setSheetName(sheetName);		
	}

	@Override
	public void loadProductFromDB() {
		getProductLoader().loadFromDB();		
	}

	@Override
	public void loadArticulosFromDB() {
		getArticuloLoader().loadFromDB();		
	}

	@Override
	public void loadOfertasFromDB() {
		getOfertaLoader().loadFromDB();		
	}



}
