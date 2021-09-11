package EShop.entityservices.dao.entityloader.loader;

import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;

public interface IProductLoaderFacade {
	
	public void setProductFileName(String productFileName);
	public String getProductFileName();
	public void setArticuloFileName(String articuloFileName);
	public String getArticuloFileName();
	public void setOfertaFileName(String ofertaFileName);
	public String getOfertaFileName();
	
	public void loadProductFromFile();
	public void loadArticulosFromFile();
	public void loadOfertasFromFile();
	
	
	public Product getSelectedProduct();
	public void setSelectedProduct(Product selectedProduct);
	public Articulo getSelectedArticulo();
	public void setSelectedArticulo(Articulo selectedArticulo);
	public Oferta getSelectedOferta();
	public void setSelectedOferta(Oferta selectedOferta);
	
	public void bindArticulosListToParentProduct();
	public void bindOfertasListToParentArticulo();
	
	public void createProducts();
	public void createArticulos();
	public void createOfertas();
	
	public IEntityLoader<Product, Product> getProductLoader();
	public IEntityLoader<Articulo, Product> getArticuloLoader();
	public IEntityLoader<Oferta, Articulo> getOfertaLoader();

}
