package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa1 {
	
	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.println("Digite o numero de produtos: ");
		int numero = sc.nextInt();
		
		for(int i=1; i<=numero; i++) {
			System.out.println("\nDados do produto #"+i);
			System.out.println("\nComum, Usado ou Importado? (c/u/i)");
			String resposta = sc.next();
			System.out.println("\nNome:");
			String nome = sc.next();
			System.out.println("\nPreco:");
			double preco = sc.nextDouble();
			if(resposta.equals("i")) {
				System.out.println("\nTaxa Alfandega:");
				double alfandega = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, alfandega));  
				
			}
			else if(resposta.equals("c")) {
				list.add(new Produto(nome, preco));
			}
			else {
				System.out.println("\nData de Fabricacao (DD/MM/YYYY):");
				Date fabricacao = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome, preco, fabricacao));
			}
		}
		
		System.out.println();
		System.out.println("ETIQUETA:\n");
		for(Produto prod: list) {
			System.out.println(prod.etiqueta());
			
		}
		
		sc.close();

	}

}
