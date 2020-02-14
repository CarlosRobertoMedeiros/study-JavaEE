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

			- Implementando os mapeamentos
				- Um para Um(OneToOne)
				- Um para Muitos(OneToMany)
				- Muitos Para um (ManyToOne)
				- Muitos Para Muitos(ManyToMany)
			
			- Implementando herança em Entidades
				- Implementando SingleTable
				- Implementando JoinTable
			
			- Implementando Mapeamentos em Enums
			
			- Trabalhando os Estados do JPA
				Ciclo de Vida do EntityManager
					- de New Para Managed
						- persist() e merge()
					- de consulta para Managed
						- find()
					- de Managed para Detached
						- detach()
					- de Managed para Managed
						- merge()
					- de Managed para Removed
						- remove()
					- de Removed para Managed
						- persist() ou merge()
					
				CallBacks JPA	
					- @PrePersist / @PostPersist
					- @PreRemove / @PostRemove
					- @PreUpdate / @PostUpdate
					- @PostLoad
				
			- Implementando Consultas
				- Utilizando JPQL
			
			- Implementando Consultas
				- Utilizando Criteria
			
			- Implementando Cache
				- Cache de Primeiro Nível
				- Cache de Segundo Nível
				- Cache de Coleções
				- Cache de Consulta(Query)
				- Cache com EhCache
				- Cache com Infinity Span, JTA no Wildfly
				
			- Novidades do JPA 2.1
				- Utilizando converters para tipo de dados data
				- Utilizando o Criteria para Update
				- Utilizando o Criteria para Delete
			
			- Novidades do JPA 2.2
				- Implementações do LocalDate resolvidas ....


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
