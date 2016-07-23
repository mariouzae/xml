import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.mario.entities.PegaProduto;


public class LeitorXML extends DefaultHandler {
	
	public static void main(String[] args) throws Exception {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		PegaProduto produtos = new PegaProduto();
		
		reader.setContentHandler(produtos);
		
		
	}

}
