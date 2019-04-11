import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {

	public static void main(String[] args) {
		MongoClient cliente = new MongoClient(); //criando cliente para conectar ao bd
		 MongoDatabase bancoDeDados = cliente.getDatabase("test");//selecionar o banco de dados do qual queremos realizar as consultas. 
	        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");//para selecionar a coleção alunos.
	        Document aluno = alunos.find().first();//selecionar o primeiro documento (aluno)
	        System.out.println(aluno);
	        
	        alunos.deleteOne(Filters.eq("nome", "Joao Silva"));// indicando o documento a ser removido da coleção.
	        
	        cliente.close();//fechar conexão com o bd
	}

}
