# study-JavaEE

Revisão De Assuntos Java referentes a JAVA EE7 e JakartaEE8

	Criando Um CRUD Simples sem Front End Para realização de Testes Unitários
		- Crud de Usuários 
			- Implementando Com um Servlet e JSTL
			- Usando JDBC 4.2
			- Conectando a objetos usando Datasource
			- Usando Pool de Conexão Servidor (Wildfly15)

	Técnicas de JPA
		- Básicas
			- Implementando um CRUD de JPA
			- Implementando um CRUD de JPA em um projeto Java EE
			- Utilizando o EntityManger para Gerenciar os Estados
				- Managed
				- Transient
				- Detached

			- Utilização das Estratégias para criação de Chave Primária
				- Auto = Escolha do Hibernate
				- Identity = Criação de CP por ID
				- Sequence = Criação de CP por sequence
				- Table = Criação de tabela de referência, resultado na tabela de historico 

			- Troca de Estados no JPA
				- método find = traz o estado para managed
				- método merge = força insert e update



	Implementação de Exemplos Simples de Padrões de Projetos JAVA EE

		-	Camada de Apresentação
			- Intercepting Filter
			- Front Controller
			- Context Object
			- Application Controller
			- View Helper
			- Composite View
			- Service to Worker
			- Dispatcher View

		- Camada de Negócio
			- Bussiness Delegate
			- Service Locator
			- Session Facade
			- Application Service
			- Bussiness Object
			- Composity Entity
			- Transfer Object
			- Transfer Object Assembler
			- Value List Handler

		- Camada de Integração
			- Data Access Object
			- Service Activator
			- Domain Store
			- Web Service Broker
