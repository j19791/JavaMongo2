import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Principal {

	public static void main(String[] args) {
		MongoClient cliente = new MongoClient(); //criando cliente para conectar ao bd
		 MongoDatabase bancoDeDados = cliente.getDatabase("test");//selecionar o banco de dados do qual queremos realizar as consultas. 
	        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");//para selecionar a coleção alunos.
	        Document aluno = alunos.find().first();//selecionar o primeiro documento (aluno)
	        System.out.println(aluno);
	        
	        Document novoAluno = new Document("nome", "Joao")
	        		  .append("data_nascimento", new Date(2003, 10, 10)) //demais pares adicionados ao documento 
	        		  .append("curso", new Document("nome", "Historia"))
	        		  .append("notas", Arrays.asList(10, 9, 8))
	        		  .append("habilidades", Arrays.asList(
	        		          new Document().append("nome", "Ingles").append("nível", "Básico"),
	        		          new Document().append("nome", "Espanhol").append("nível", "Básico")));
	        
	        
	        alunos.insertOne(novoAluno); //inserindo o aluno
	        
	        cliente.close();//fechar conexão com o bd
	}

}
