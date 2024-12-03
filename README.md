# Tech Challenge - Sistema de Controle de Clientes

O sistema tem como intuito de cadastramento e busca de clientes.

## Integrantes do Grupo
- RM354032 - Alysson Gustavo Rodrigues Maciel
- RM355969 - Vinicius Duarte Mendes Nepomuceno
- RM354090 - Lucas Pugliese de Morais Barros
- RM353273 - Felipe Pinheiro Dantas

## Event Storming do Projeto
```url
https://miro.com/app/board/uXjVKSt4Gq8=/?share_link_id=968579577663
```

## Para acessar o swagger e realizar os testes
Rota para acessar Swagger
```url
http://localhost:8081/swagger-ui
```
Rota para acessar Swagger.yml
```url
http://localhost:8081/api-docs
```
Dentro do Projeto no diretório "postman" há um arquivo com uma collection postman com todas as rotas mapeadas para teste
```
./postman - client.postman_collection.json
```

## Cadastrar um cliente

Para cadastrar um novo cliente deve se chamar a rota POST /clientes como usando o curl abaixo.

```url
curl --location 'http://localhost:8081/clientes' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "teste",
    "email": "email",
    "cpf": "34369533856"
}'
```

O retorno com sucesso será:

```url
{
    "id": 1,
    "nome": "teste",
    "email": "email",
    "cpf": "34369533856"
}
201 created
```

## Buscar cliente pelo CPF

Para localizar um cliente usando o CPF basta chamar a rota GET /clientes com o curl abaixo.

```url
curl --location 'http://localhost:8081/clientes?cpf=34369533856'
```

O retorno com sucesso será:

```url
{
    "id": 1,
    "nome": "teste",
    "email": "email",
    "cpf": "34369533856"
}
200 OK
```