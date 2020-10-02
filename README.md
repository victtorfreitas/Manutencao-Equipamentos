<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Projuris_0"></a>Projuris</h1> <p class="has-line-data" data-line-start="2" data-line-end="3">Este projeto é uma API de controle de manutenção de equipamentos, nele controlaremos todos os estágios da execução de um serviço. Nossas funcionalidades são:</p> <ul> <li class="has-line-data" data-line-start="3" data-line-end="4">Listar Clientes</li> <li class="has-line-data" data-line-start="4" data-line-end="5">Cadastrar Cliente</li> <li class="has-line-data" data-line-start="5" data-line-end="6">Listar Ordem de Serviços</li> <li class="has-line-data" data-line-start="6" data-line-end="7">Lista Ordem de Serviços resumida</li> <li class="has-line-data" data-line-start="7" data-line-end="8">Cadastrar Ordem de Serviço</li> <li class="has-line-data" data-line-start="8" data-line-end="9">Cancelar ordem de serviço</li> <li class="has-line-data" data-line-start="9" data-line-end="10">Concluir ordem de serviço</li> <li class="has-line-data" data-line-start="10" data-line-end="11">Iniciar atendimento da ordem de serviço</li> <li class="has-line-data" data-line-start="11" data-line-end="12">Pausar ordem de serviço</li> <li class="has-line-data" data-line-start="12" data-line-end="13">Retomar ordem de serviço</li> <li class="has-line-data" data-line-start="13" data-line-end="14">Filtrar Ordem de Serviço por responsável</li> </ul> <h3 class="code-line" data-line-start=16 data-line-end=17 ><a id="Tecnologias_16"></a>Tecnologias</h3> <p class="has-line-data" data-line-start="18" data-line-end="19">O projeto foi inteiramente desenvolvido na linguagem de programação Java, porém para obter a melhor performance utilizamos alguns frameworks e bibliotecas, são elas:</p> <ul> <li class="has-line-data" data-line-start="19" data-line-end="20">Spring Boot</li> <li class="has-line-data" data-line-start="20" data-line-end="21">Spring Data JPA</li> <li class="has-line-data" data-line-start="21" data-line-end="22">Spring Data JDBC</li> <li class="has-line-data" data-line-start="22" data-line-end="23">Spring Devtools</li> <li class="has-line-data" data-line-start="23" data-line-end="24">SpringFox Swagger</li> <li class="has-line-data" data-line-start="24" data-line-end="25">Lombok</li> <li class="has-line-data" data-line-start="25" data-line-end="26">Flyway</li> <li class="has-line-data" data-line-start="26" data-line-end="27">Querydsl</li> <li class="has-line-data" data-line-start="27" data-line-end="28">ModelMapper</li> </ul> <h3 class="code-line" data-line-start=30 data-line-end=31 ><a id="O_que_voc_precisa_30"></a>O que você precisa</h3> <ul> <li class="has-line-data" data-line-start="32" data-line-end="33">Cerca de 15 minutos</li> <li class="has-line-data" data-line-start="33" data-line-end="34">Um editor de texto ou IDE favorito</li> <li class="has-line-data" data-line-start="34" data-line-end="35">JDK 12 ou posterior</li> <li class="has-line-data" data-line-start="35" data-line-end="37">Maven 3.2+</li> </ul> <h3 class="code-line" data-line-start=37 data-line-end=38 ><a id="Como_comear_37"></a>Como começar</h3> <p class="has-line-data" data-line-start="38" data-line-end="39"><a href="https://github.com/victtorfreitas/Manutencao-Equipamentos/archive/master.zip">Baixe</a> e descompacte o repositório de origem ou clone-o usando o comando:</p> <pre><code class="has-line-data" data-line-start="40" data-line-end="42" class="language-sh">git <span class="hljs-built_in">clone</span> https://github.com/victtorfreitas/Manutencao-Equipamentos.git </code></pre> <p class="has-line-data" data-line-start="42" data-line-end="43">Abra o diretório Manutencao-Equipamentos e execute o comando:</p> <pre><code class="has-line-data" data-line-start="44" data-line-end="46" class="language-sh">mvn spring-boot:run </code></pre> <h3 class="code-line" data-line-start=47 data-line-end=48 ><a id="Documentao_47"></a>Documentação</h3> <p class="has-line-data" data-line-start="48" data-line-end="49">Este projeto foi documentado através do Swagger, para acessar sua documentação você deve inicializar o projeto e logo em seguida acessar o link:</p> <ul> <li class="has-line-data" data-line-start="50" data-line-end="51"><a href="http://localhost:8081/swagger-ui.html">http://localhost:8081/swagger-ui.html</a></li> </ul> <h3 class="code-line" data-line-start=53 data-line-end=54 ><a id="Futuras_melhorias_53"></a>Futuras melhorias</h3> <ul> <li class="has-line-data" data-line-start="55" data-line-end="56">Adicionar a funcionalidade de inserir um resultado sem alterar o status da ordem de serviço;</li> <li class="has-line-data" data-line-start="56" data-line-end="57">Adicionar a funcionaliadde de inserir funcionário;</li> <li class="has-line-data" data-line-start="57" data-line-end="58">Adicionar a funcionaliadde de listar equipamentos por cliente;</li> <li class="has-line-data" data-line-start="58" data-line-end="59">Adicionar a funcionalidade de listar os funcionários sem demanda;</li> <li class="has-line-data" data-line-start="59" data-line-end="60">Adicionar a funcionalidade de atualizar dados cadastrais do cliente;</li> <li class="has-line-data" data-line-start="60" data-line-end="62">Adicionar regra de ao inserir um resultado desabilitar o anterior;</li> </ul> <h3 class="code-line" data-line-start=62 data-line-end=63 ><a id="Desafio_62"></a>Desafio</h3> <p class="has-line-data" data-line-start="64" data-line-end="65">Um dos principais desafios desse projeto foi estruturar de forma modular, ao finalizar o desenvolvimento da primeria versão percebi que a forma que estruturei o projeto não foi a mais adequada e provavelmente mudarei na segunda versão. O problema dessa estrutura é a grande quantidade de separações, mantendo a navegação e o fácil entendimento do projeto um pouco complicado. Tenho em mente manter a arquitetura porém mudar a estruturação de forma que a modulação do projeto não se torne um problema de escalabilidade.</p> <h3 class="code-line" data-line-start=68 data-line-end=69 ><a id="Autor_68"></a>Autor</h3> <ul> <li class="has-line-data" data-line-start="70" data-line-end="72">Victtor Araújo Freitas</li> </ul> <h2 class="code-line" data-line-start=72 data-line-end=74 ><a id="Licena_72"></a>Licença</h2> <p class="has-line-data" data-line-start="75" data-line-end="76">MIT</p> <p class="has-line-data" data-line-start="78" data-line-end="79"><strong>Software Livre, É isto!</strong></p>