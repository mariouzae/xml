package br.com.mario.entities;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PegaProduto extends DefaultHandler {
	
	private List<Produto> produtos = new ArrayList<>();
	private Produto produto;
	private StringBuilder conteudo = new StringBuilder();
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName.equals("produto")){
			produto = new Produto();
		}
		
		conteudo = new StringBuilder();
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if(qName.equals("produto")){
			produtos.add(produto);
		} else if(qName.equals("nome")){
			produto.setNome(conteudo.toString());
		} else if(qName.equals("preco")){
			produto.setPreco(Double.parseDouble(conteudo.toString()));
		}
	
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		conteudo.append(new String(ch, start,length));

	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

	
}
