package br.com.mario.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.mario.entities.Produto;
import br.com.mario.entities.Venda;

public class MapeaXML {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		
		
		xmlToObject(jaxbContext);
		
		objectToXML(jaxbContext);
		
		
	}

	private static void objectToXML(JAXBContext jaxbContext) throws Exception {
		// TODO Auto-generated method stub
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crédito");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Livro de Java", 56.55));
		produtos.add(new Produto("Livro de JavaScript", 56.55));
		produtos.add(new Produto("Livro de CSS", 56.55));
		venda.setProdutos(produtos);
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(venda, writer);
		
		System.out.println("Conteúdo XML: " + writer.toString());
	}

	private static void xmlToObject(JAXBContext jaxbContext) throws Exception {
		// TODO Auto-generated method stub
		 
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); 
		
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/pagamento.xml"));
		
		System.out.println(venda.toString());
	}

}
