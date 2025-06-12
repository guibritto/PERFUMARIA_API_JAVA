# 💐 Perfumaria API - Gestão Moderna para Comércios de Perfumes

## 🌸 Sobre o Projeto

O **Perfumaria API** nasceu a partir de uma necessidade observada no pequeno comércio brasileiro: a dificuldade de perfumarias organizarem seus catálogos de produtos, categorias e gestão de estoques de forma simples, moderna e acessível.

Inspirado em histórias reais de pequenos empreendedores, como a Dona Lúcia — que há 15 anos mantém sua perfumaria artesanal no interior de São Paulo, mas sempre enfrentou dificuldades para gerenciar seus produtos — desenvolvemos uma solução que alia tecnologia de ponta com a simplicidade que o setor precisa.

Com esta API, perfumarias podem:

- Cadastrar e atualizar produtos com facilidade.
- Organizar produtos por categoria (ex.: Eau de Parfum, Eau de Toilette, Colônia, Óleos, Aromatizantes, etc).
- Gerenciar múltiplas perfumarias de forma centralizada.
- Consultar produtos de forma paginada e eficiente.
- Facilitar a escalabilidade do negócio com integração pronta para aplicações mobile, web e sistemas ERP.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate**
- **Swagger OpenAPI 3 (Documentação automática)**
- **Banco de Dados Relacional (MySQL, Oracle ou PostgreSQL compatível)**
- **Bean Validation (Jakarta Validation)**
- **Arquitetura em camadas (Controller, Service, Repository, DTO, Mapper)**

---

## 📦 Funcionalidades Principais

### 🔧 Endpoints de Perfumarias (`/perfumarias`)

- **Criar perfumaria**  
  `POST /perfumarias`

- **Listar todas perfumarias**  
  `GET /perfumarias`

- **Buscar perfumaria por ID**  
  `GET /perfumarias/{id}`

- **Atualizar perfumaria**  
  `PUT /perfumarias/{id}`

- **Deletar perfumaria**  
  `DELETE /perfumarias/{id}`  
  (Protegido contra exclusão de perfumarias com produtos vinculados)

- **Listar produtos de uma perfumaria específica**  
  `GET /perfumarias/{id}/produtos`

- **Listar produtos de uma perfumaria por categoria**  
  `GET /perfumarias/{id}/produtos/categoria/{categoria}`

- **Buscar produto específico de uma perfumaria**  
  `GET /perfumarias/{id}/produtos/{idProduto}`

---

### 🧴 Endpoints de Produtos (`/produto`)

- **Cadastrar produto individualmente**  
  `POST /produto`

- **Cadastrar múltiplos produtos em lote**  
  `POST /produto/lote`

- **Listar produtos paginados**  
  `GET /produto?pageNumber={page}`

- **Listar produtos por categoria**  
  `GET /produto/categoria/{categoria}`

- **Buscar produto por ID**  
  `GET /produto/{id}`

- **Atualizar produto existente**  
  `PUT /produto/{id}`

- **Deletar produto**  
  `DELETE /produto/{id}`

---

## 📄 Exemplos de Requisições (Swagger/Postman)

No arquivo `teste_api_java_cp2 3.txt` (disponível neste repositório) você encontra exemplos práticos de requisições JSON para todos os endpoints da API. Utilize esses exemplos para facilitar seus testes no **Swagger UI** ou importar no **Postman**.

- Exemplos de criação, atualização, consulta e deleção de perfumarias e produtos.
- Estruturas prontas para copiar e colar nos campos de requisição do Swagger ou Postman.

Assim, você pode validar rapidamente o funcionamento da API e acelerar o desenvolvimento de integrações!

---

## 📝 Documentação Interativa com Swagger

A API conta com documentação automática via **Swagger UI**. Após rodar a aplicação, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Como Executar Localmente

1️⃣ Clone o projeto:

```bash
git clone https://github.com/seu-usuario/perfumaria-api.git
cd perfumaria-api
```

2️⃣ Configure o application.properties com suas credenciais de banco de dados.

3️⃣ Execute o projeto:

```bash
./mvnw spring-boot:run
```

4️⃣ Pronto! A aplicação estará rodando em http://localhost:8080.

## 🎯 Público-Alvo

O **Perfumaria API** foi desenvolvido com foco em atender as necessidades específicas de negócios do setor de fragrâncias e cosméticos, proporcionando organização e escalabilidade para:

- **Perfumarias artesanais e boutiques de nicho** que desejam digitalizar seu catálogo de produtos e processos de gestão.
- **Redes de franquias de perfumaria**, facilitando o controle de múltiplas lojas com centralização dos dados.
- **Lojas físicas e e-commerces de cosméticos e aromatizantes** que buscam integrar catálogos e estoques de forma eficiente.
- **Desenvolvedores e startups SaaS** que desejam incorporar soluções prontas para o segmento de beleza e perfumaria.

## 🤝 Sobre o Desenvolvimento

Este projeto foi construído como um case acadêmico com aplicação prática para o mercado, unindo conceitos sólidos de engenharia de software com foco no ecossistema real de pequenos e médios empreendedores.

- **Desenvolvedor Back-End:** [Seu Nome]
- **Instituição:** FIAP - Análise e Desenvolvimento de Sistemas

## 💡 Possíveis Evoluções

O projeto foi estruturado pensando em fácil expansão, com várias possibilidades futuras, tais como:

- Integração com módulos de **pagamento online, emissão de notas fiscais e controle financeiro**.
- Implementação de **controle de validade, lotes e vencimentos de estoque**.
- Criação de **relatórios gerenciais e dashboards analíticos** para acompanhamento de vendas, estoque e desempenho.
- Exposição de **API pública** para integração com marketplaces de beleza e plataformas multicanal.
- Integração futura com módulos de **fidelização de clientes, cupons de desconto e programas de pontos**.

### Integrantes do Grupo:

- [Guilherme Britto](https://github.com/guibritto)
- [Thiago Mendes](https://github.com/Offiline26)
