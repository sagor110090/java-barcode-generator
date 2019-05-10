import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Main {
	public void barcode(String s,int x) {
		try {
			  
			  Code128Bean code128 = new Code128Bean();
		        code128.setHeight(15f);
		        code128.setModuleWidth(0.3);
		        code128.setQuietZone(10);
		        code128.doQuietZone(true);

		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 400, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		        code128.generateBarcode(canvas,s);
		        canvas.finish();

		//write to png file
		        FileOutputStream fos = new FileOutputStream("barcode.png");
		        fos.write(baos.toByteArray());
		        fos.flush();
		        fos.close();

		//write to pdf
		        Image png = Image.getInstance(baos.toByteArray());
		        png.setAbsolutePosition(0, 705);
		        png.scalePercent(25);

		        Document document = new Document(new Rectangle(PageSize.A4));
		        
		        PdfPTable table = new PdfPTable(4);
		        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		        for (int aw = 0; aw < x; aw++) {
		            Paragraph p = new Paragraph();
		            p.add("\n        Price:500");
//		            p.add(createImageCell(png));
		            PdfPTable intable = new PdfPTable(1);
		            intable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		            intable.addCell(p);
		            intable.addCell(png);
		            intable.getDefaultCell().setBorder(0);
		            
		            table.addCell(intable);
		        }
		        
		        
		        
		        
//		        table.setBorder(Border.NO_BORDER);
		        Paragraph p = new Paragraph();
		        p.add("\nPrice:500");
		        p.add(png);
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c://"+s+".pdf"));
				 
		       
		        document.open();
//		        document.add();
		        document.add(table);
		        document.close();
 
				

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}


