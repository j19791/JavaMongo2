import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {

	public static void main(String[] args) {
		MongoClient cliente = new MongoClient(); //criando cliente para conectar ao bd
		 MongoDatabase bancoDeDados = cliente.getDatabase("test");//selecionar o banco de dados do qual queremos realizar as consultas. 
	        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");//para selecionar a cole��o alunos.
	        Document aluno = alunos.find().first();//selecionar o primeiro documento (aluno)
	        System.out.println(aluno);
	        
	        alunos.updateOne(Filters.eq("nome", "Joao"),//filtro que selecionar� o aluno Jo�o. eq: buscamos um aluno em nossa cole��o cujo nome � Joao  
	        			new Document("$set", //o tipo de atualiza��o ($set) para indicar que trata-se de uma atualiza��o parcial
	        			new Document("nome", "Joao Silva")));//novo dado, que ir� substituir o atual:
	        
	        cliente.close();//fechar conex�o com o bd
	}

}
