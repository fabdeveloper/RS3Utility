package EShop.entityservices.dao.xls.excel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import EShop.entityservices.converter.xlstoentity.IXlsToEntityConversor;
import src.entity.Articulo;
import src.entity.Oferta;
import src.exception.RS3Exception;
import src.inter.IServiceLocator;

//@RequestScoped
//@Alternative
public class OfertaDaoExcel implements IXlsToEntityConversor<Oferta> {
	


	@Override
	public Oferta rowToEntity(Row row, IServiceLocator serviceLocator) {
		DataFormatter formatter = new DataFormatter();
		Oferta ofer = serviceLocator.getOfertaServices().getTransferObject();
		try {		
			ofer.setName(formatter.formatCellValue(row.getCell(1)));
			ofer.setDescripcion(formatter.formatCellValue(row.getCell(2)));
//			ofer.setPrecio(Float.valueOf(formatter.formatCellValue(row.getCell(3)))); 
			ofer.setPrecio((float)row.getCell(3).getNumericCellValue()); 
			ofer.setStock(Integer.valueOf(formatter.formatCellValue(row.getCell(4))));
			Articulo arti = serviceLocator.getArticuloServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(5))));
			ofer.setArticulo(arti);
			ofer.setUrlImage(formatter.formatCellValue(row.getCell(6)));
			ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(7)));
			try {
				ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(8))));
			}catch(Throwable t) {
				
			}
//			String cellString = formatter.formatCellValue(row.getCell(8));			
//			if(cellString.length() > 0) { ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(cellString)); }	
			
			ofer.setCreationDate(new Date());
			
		}catch(Throwable t) {	
			String msg = "OfertaDaoExcel.rowToEntity() - ERROR - msg= " + t.getMessage();
			throw new RS3Exception(msg);			
		}
		return ofer;
	}

	@Override
	public Row entityToRow(Oferta entity, Row row) {
		// TODO Auto-generated method stub
		return null;
	}
}