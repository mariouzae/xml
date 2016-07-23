package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlParser {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/pagamento.xml");

		NodeList produtos = document.getElementsByTagName("produto");
		
		for (int i = 0; i < produtos.getLength(); i++) {

			Element produto = (Element) produtos.item(i);

			String nome = produto.getElementsByTagName("nome").item(i).getTextContent();
			//String preco = produto.getElementsByTagName("preco").item(i).getTextContent();
			//System.out.println("Nome: " + nome);
			//System.out.println("Preço: " + preco);

		}
		
		//System.out.println("Attribute:" + elemento.getAttribute("moeda"));
	}

}
