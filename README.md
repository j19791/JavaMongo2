# JavaMongo
Projeto do Curso de Java com MongoDB da Alura

## Conectando com Mongo 
### subir o servidor do MongoDB e iniciar o banco de dados da aplicação
C:\Program Files\MongoDB\Server\3.2\bin>mongod --dbpath "C:/Users/CORE I5/Desktop/reciclagem/java com mongo/db" --storageEngine=mmapv1

### acessando o MongoDB 
mongo

### driver
conector que possibilite o Java a se comunicar com o banco de dados

```
<dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver</artifactId>
        <version>3.4.3</version>
    </dependency>
</dependencies>
```

## Usando o Mongo
### criando uma coleção
```
db.createCollection("alunos");
```

### inserindo um objeto
```
db.alunos.insert({
    "nome": "Felipe",
    "data_nascimento": new Date(1994, 02, 26),
    "curso": {
        "nome": "Sistemas de informação"
    },
    "notas": [10.0, 9.0, 4.5],
    "habilidades": [{
        "nome": "inglês",
        "nível": "avançado"
    }, {
        "nome": "taekwondo",
        "nível": "básico"
    }]
})
```

### trazendo os objetos inseridos
```
db.alunos.find()
db.alunos.find({}).pretty()
```

### removendo um objeto inserido anteriormente
```
db.alunos.remove({
    "_id" : ObjectId ("56cb0002b6d75ec12f75d3b5")
})
```

### outros comandos
```
show databases
```




















