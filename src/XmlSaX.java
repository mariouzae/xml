import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.mario.entities.PegaProduto;


public class XmlSaX {

	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		PegaProduto produtos = new PegaProduto(); 
		leitor.setContentHandler(produtos);
		InputStream ips = new FileInputStream("src/pagamento.xml");
		InputSource is = new InputSource(ips);
		leitor.parse(is);
		
		System.out.println(produtos.getProdutos());
		
	}
}
