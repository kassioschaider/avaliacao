## Avaliação de Codificação Java com Spring
 
### Descrição

API REST para gerenciar patrimônios de uma empresa.

### Como instalar

O projeto foi desenvolvido usando Spring Boot 2.3.4 e Java 1.14 para uma API Rest.
Importe o back-end da pasta "avaliacao" para a sua IDE a partir do pom.xml (InteliJ)

Foram utilizados do Spring Boot os módulos Starter JPA, DevTools, Starter Web, Starter Security, Starter Test.
Além do Json Web Token, JUnit, Jakarta Validation, Hibernate Validator e as bibliotecas MapStruct e Lombok.

O banco de dados utilizado foi o PostgreSQL e H2 (para testes). 
Para executar o sistema e banco de dados, siga um dos passos abaixo:

Opção 1 (Docker):
 - Execute o comando "docker-compose up -d" na pasta do projeto para subir um contêiner do Postgre e o Adminer;
 - Execute o comando "docker inspect avaliacao_db_1" para inspecionar o contêiner;
 - Copie o IPAddress do contêiner (logo ao fim do arquivo Json que será exibido),
    em geral, ele seŕá "172.18.0.3" ou "172.18.0.2", dependendo de como rede do contêiner est distribuída;
 - Substitua o "localhost" pelo IPAddress do ocntẽiner na url de conexão (spring.datasource.url) no arquivo appication.properties;
 - Importe todas as depências do projeto;
 - Ao subir o sistema as tabelas serão criadas;
 - Execute o script abaixo no banco de dados para ter um usuário com login "admin@admin.com" e senha "admin".

  INSERT INTO usuario(email, nome, senha) VALUES('admin@admin.com', 'admin', '$2a$10$Xoiyu2cEaD7.KaDHZwS1auotpZQXz4DMFH8dhBCXPsh4O9ej8CQV2');

Opção 2 (caso você já tenha o Postegre instalado na máquina):
 - Criar um banco de dados com o nome "avaliacao";
 - Substituir pelo o seu nome do usuário e senha no arquivo application.properties (username e password)
 - Além disso, caso utilize a porta padrão a url de conexão com banco de dados estar pronta, 
      caso seja outra porta utilizada pelo Postegre, insira ela em "spring.datasource.url" logo após o "localhost";
 - Importe todas as depências do projeto;
 - Ao subir o sistema as tabelas serão criadas;
 - Execute o script abaixo no banco de dados para ter um usuário com login "admin@admin.com" e senha "admin":

  INSERT INTO usuario(email, nome, senha) VALUES('admin@admin.com', 'admin', '$2a$10$Xoiyu2cEaD7.KaDHZwS1auotpZQXz4DMFH8dhBCXPsh4O9ej8CQV2');
 
### Endpoints de dados da API
 
- A API REST possui os seguintes endpoints e todos recebem e devolvem dados no formato JSON, sendo que é utilizado um 
ResponseEntity e ResponseUtil (implementado) para gerar as respostas dos endpoints, além disso todas as requisições passam
pelo Handler de validação, gerando uma resposta amigável ao front-end no formato "campo" e "erros" (ErroFormularioDTO):

 - `GET /api/marcas`: obtém todas as Marcas cadastradas.
 - `GET /api/marcas/:id`: obtém a Marca referente ao id.
 - `GET /api/patrimonios`: obtém todas os Patrimonios cadastrados.
 - `GET /api/patrimonios/:id`: obtém o Patrimonio referente ao id.
 
 - `POST /api/marcas`: O endpoint processa uma requisição de cadastro de Marca, 
    no corpo da requisição deve conter obrigatoriamente o campo "nome", sendo entre 3 e 50 caracteres.
    O "nome" de uma marca é obrigatoriamente único.
 - `POST /api/patrimonios`: O endpoint processa uma requisição de cadastro de Patrimonio,
    no corpo da requisição deve conter obrigatoriamente os campos "nome" (3 a 50 caracteres) e "idMarca".
    É gerado um "número de tombo" a partir do momento (Timestamp) em que ele foi cadastrado.
 
 - `PUT /api/marcas`: O endpoint processa uma requisição de edição da Marca.
 - `PUT /api/patrimonios`: O endpoint processa uma requisição de edição da Patrimonio, 
    sendo que não é possível alterar o Número do Tombo.
 
 - `DELETE /api/marcas/:id`: O endpoint processa uma requisição de exclusão de uma Marca a partir do id,
    sendo que não é possível excluir uma Marca com algum Patrimonio relacionado com ela.
 - `DELETE /api/patrimonios/:id`:  O endpoint processa uma requisição de exclusão de um Patrimonio a partir do id.

### Endpoint de Autenticação da API

 - `POST /auth`: O endpoint de autenticação de usuário. Deve conter no corpo da requisição os campos "email" e "senha" do usuário.
 Ao fazer login com sucesso, o usuário recebe um token de autenticação que permanece ativo por 1 dia (valor que pode ser alterado 
 no application.properties em "avaliacao.jwt.expiration").
 
### Endpoint do Exercício 1

 - `POST /exercicio/:numero`: O endopoint processa uma requisição e devolve como inteiro o maior "número irmão" do numero passado
 como parãmetro. Caso o resultado exceda 100.000.000, o endpoint retorna -1.

### Arquitetura

O projeto a seguinte estrutura:

 - Packs:
   - configuration: filtro de validação de dados e implementações de segurança com WebToken. Contém os pacotes "security" e "validation".
   - controller: todos os RestControllers da API.
   - model: as classes de domínio da API, sendo que são utilizados as anotações do Lombok para gerar Getters, Setters, Contrucutors, Equals e HashCode.
     Além disso também são os objetos persistidos no banco de dados, portanto também possuem anotações do Javax Persistence.
   - repository: todos os repositórios da API, sendo que estes implementam os métodos da JpaRepository.
   - service: todas as classes Services da API. Contém os pacotes:
     - dto: para os os DTOs da API, incluindo os DTOs de Patrimonio (Form para cadastro), o DTO do Token para devolvem na requisição de acesso autenticado.
     - impl: implementação dos métodos definidos nas interfaces Service.
     - mapper: para as classes de mapeamento de conversão de DTO para Entity e Entity para DTO. Aqui é utilizado o EntityMapper para obter uma estrutura padrão
       das interfaces mapper. É utilizado a biblioteca MapStruct para o mapeamento.
   - util: pacotes com as classes e interfaces de suporte a API.
