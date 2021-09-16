package EShop.entityservices.converter.xlstoentity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Oferta;
import src.exception.RS3Exception;
import src.inter.IServiceLocator;


@RequestScoped
public class OfertaXlsToEntityConverter extends AbstractXlsToEntityConverter<Oferta> {

	@Override
	public Oferta rowToEntity(Row row, IServiceLocator serviceLocator) {
		DataFormatter formatter = new DataFormatter();
		Oferta ofer = serviceLocator.getOfertaServices().getTransferObject();
		
		String errorMsg = new Date() + " - ->  OfertaXlsToEntityConverter.rowToEntity() - ERRORLIST: ";
		Boolean bAlgunError = false;
		/*
		 * ID - primary key
		 * NAME - not null
		 * PRECIO - not null
		 * STOCK - not null
		 * ARTICULO - not null
		 */
		
		
		
		// ID
		String sid = formatter.formatCellValue(row.getCell(0));
		Integer id = null;
		if(sid != null && !sid.isEmpty()) {
			try {
				id = Integer.parseInt(sid);
			}catch(Throwable t) {
				errorMsg += "ID value = " + sid + " / ";
				bAlgunError = true;				
			}
		}

		
		// NAME
		String name = formatter.formatCellValue(row.getCell(1));
		if(name.isEmpty() || name == null) {			
			errorMsg += "name is mandatory" + " / ";
			bAlgunError = true;
		}
		
		// PRECIO
		String sprecio = null;
		Float precio = null;
		try {
			sprecio = formatter.formatCellValue(row.getCell(3));
			precio = Float.valueOf(sprecio);
		}catch(Throwable t) {
			errorMsg += "PRECIO is mandatory - format like -> 0.00 - current: " + sprecio + " / ";
			bAlgunError = true;			
		}		
		
		// STOCK
		String sstock = null;
		Integer stock = null;
		try {
			sstock = formatter.formatCellValue(row.getCell(4));
			stock = Integer.valueOf(sstock);
		}catch(Throwable t) {
			errorMsg += "STOCK is mandatory - current: " + sstock + " / ";
			bAlgunError = true;	
		}
		
		if(bAlgunError) {
			throw new RS3Exception(errorMsg);
		}
		
		
		// ARTICULO
		String sArticulo_id = formatter.formatCellValue(row.getCell(5));
		if(sArticulo_id != null && !sArticulo_id.isEmpty()) {
			try {
				Integer articulo_id = Integer.valueOf(sArticulo_id);
				if(articulo_id != null) {
					Articulo arti = serviceLocator.getArticuloServices().read(articulo_id);
					ofer.setArticulo(arti);
				}
			}catch(Throwable t) {
			
			}
		}
		
		
		// ALL OTHER		
		
		ofer.setName(name);
		ofer.setDescripcion(formatter.formatCellValue(row.getCell(2)));
		ofer.setPrecio(precio); 
		ofer.setStock(stock);
		ofer.setUrlImage(formatter.formatCellValue(row.getCell(6)));
		ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(7)));
		try {
			ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(8))));
		}catch(Throwable t) {
			
		}

		return ofer;
	}

}
