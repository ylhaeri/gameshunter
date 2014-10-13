Explicação da estrutura e alguns lembretes

Java Resources
		Onde estão todos os recursos da aplicação, as partes web também ficam lá por 
		causa do Maven. Mas apesar de ficar 'aqui', não podemos acessá-lo diretamente
		daqui, é necessário ir até as pastas de verdade, que ficam no src.
	
	src/main/java
		Todas as lógicas devem ficar ai dentro, pode usar normalmente como em qualquer
		outro projeto java.
	
	src/main/resources
		Todos os arquivos que tenham relação com configuração são colocados aqui.
		META-INF do Hibernate também fica aqui, apesar de ser necessário colocá-lo
		 na pasta src, o Maven procura por eles aqui.
		 Mesmo caso para o struts.xml and so on.
	
	
	src/test/java
		Todos os testes devem ser colocados aqui. Só vão funcionar corretamente se
		 estiverem aqui, o Maven só vai executar os testes presentes neste local.
		 Testes em qualquer outro lugar	vão ser até computados nos testes e farão a 
		 code coverage falhar.
		
	libraries
		Libraries, ê. Bem auto-explicativo.
	
	JavaScriptResources
		Recursos do JavaScript. Bem auto-explicativo também.
		
	Depoyled Resources
		Well, não sei, não acho nada pesquisando também. Agradeço se conseguir
		ajuda de alguém pra falar o que é esse diretório.
		
	src
		Pastas reais do projeto, podemos acessar a parte da web aqui.
		src>main>webapp. Fora isso é bem auto-explicativo.
		
	target
		Todas as coisas geradas pelo Maven vão ficar aqui. Javadoc, .jar, .war
		qualquer coisa vem para ca. Vamos acessar muito a pasta 
		target>site por causa do jacoco. Jacoco é a API que implementa o
		Test Coverage da aplicação.
		
	pom.xml
		É o único arquivo de configuração que fica fora do src/main/resources.
		Ele tem que ficar aqui pro Maven poder localizar as coisas.
		Se quiser adicionar novas jars pro projeto é só mexer aqui,
		qualquer dúvida avisa que tento te ajudar.
		
	workspace
		Tem alguma coisa relacionada com o meu workspace. Tem o nome dele e
		algumas coisas que não acho que façam diferença. Ele já deve saber
		lidar com esse nome em qualquer lugar, deve ter virado uma configuração
		ou algo assim. É adicionado quando coloca no git. Deve ser a pasta que deu
		origem ao projeto ou whatever.
		
		
	Eu estou usando o tomcat v8.0. É bom a gente manter a mesma versão de container
	pelo que eu pesquisei. Caso você esteja usando uma mais antiga tenta atualizar
	assim que possível. Caso prefira algum outro, avisa que eu baixo.
	
	
	Inclui alguns arquivos de um projeto de Web do alura para poder ver como vai
	ficar a estrutura geral do diretório webapp. Já inclui o reset.css e JQuery.
	O css.reset que eu escolhi, reseta totalmente tudo, não adiciona nada, como
	alguns outros fazem. Preferi isso pra poder customizar ao máximo. Fica mais legal
	Se achar que falta alguma coisa, inclua.
	Nota: Tudo dai menos o reset.css vai ser deletado, só inclui pra poder ver
	a estrutura e pro git receber os diretórios bem feitos.
	
	
	Tentei já adicionar todos os comandos necessários com a configuração offline mas
	não deu. É necessário fazer em cada workspace, não é configuração do projeto.
	Para fazer: Botão direito no projeto>run as>Maven build... Essa opção te deixa
	escolher qual maven goal deve ser rodada. Lembra de ir na Maven build... A outra
	vai simplesmente executar o último comando do maven.
	Na hora de fazer o novo comando, é só selecionar offline. Você vai precisar do
	goal test.
	
	
	Lembrando: Caso tenha algum arquivo que não queiramos que seja colocado no GIT
	por qualquer motivo, basta clicar com o botão direto>team>ignore.
	Ele vai ser adicionado ao git.ignore com isso. Talvez seja necessário alguma hora.
	
	A anotação de javadoc já é aplicada automaticamente no projeto. Só precisamos
	criar o javadoc quando quisermos colocar em um site bonitinho. Use e abuse disso.
	
	Lembre de SEMPRE criar um novo branch quando chegar em um ponto considerável das
	suas alterações. Não arrisque quebrar tudo por ter incluido uma nova classe
	que por motivos bobos podem foder com tudo. Faça um novo branch quando achar
	que deve e implemente as novas coisas, vai te dar mais segurança. Antes de dar push,
	É só você dar merge no master branch, que é o padrão e que vai ser nossa guide-line.