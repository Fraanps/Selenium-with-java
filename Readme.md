# Projeto de Aprendizado do Selenium com Java

Este repositório foi criado com o objetivo de praticar e aprender os conceitos básicos da ferramenta **Selenium** utilizando a linguagem **Java**. Ele não representa um projeto de produção, mas sim um ambiente para explorar funcionalidades essenciais do Selenium, como:

- Localização de elementos na página (XPath, CSS Selectors, etc.).
- Interações com elementos (cliques, preenchimento de formulários, seleção de opções em dropdowns, etc.).
- Validação de comportamentos e estados de elementos.
- Implementação do padrão **Page Object Model (POM)** para organização do código.

## Funcionalidades Implementadas

- **Localização de Elementos:** Uso de diferentes técnicas para encontrar elementos HTML, incluindo XPath e CSS Selectors.
- **Validação de Elementos:** Confirmação da presença, visibilidade e estados dos elementos na página.
- **Page Object Model:** Estruturação do projeto para separar responsabilidades entre elementos de página e testes.
- **Interação com Elementos:** Automção de tarefas como cliques, preenchimento de campos, navegação entre páginas e captura de valores dinâmicos.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal.
- **Selenium WebDriver:** Ferramenta para automação de navegadores.
- **Maven:** Gerenciador de dependências e construção do projeto.
- **JUnit:** Framework de testes para escrita e execução dos casos de teste (opcional).

## Estrutura do Projeto

O projeto segue a seguinte organização:

```
projeto-selenium-java/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- pages/       # Classes representando as páginas (Page Object Model)
|   |-- test/
|       |-- java/
|           |-- tests/       # Classes de teste
|-- pom.xml                  # Configuração do Maven
```

## Como Executar o Projeto

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/seu-usuario/projeto-selenium-java.git
   cd projeto-selenium-java
   ```

2. **Configure o Ambiente:**
    - Certifique-se de ter o **Java JDK** instalado.
    - Instale o **Maven**.
    - Baixe o driver do navegador apropriado (ex.: ChromeDriver para Google Chrome) e coloque-o no PATH do sistema.

3. **Instale as Dependências:**

   ```bash
   mvn clean install
   ```

4. **Execute os Testes:**

   ```bash
   mvn test
   ```

## Referências

- [Documentação Oficial do Selenium](https://www.selenium.dev/documentation/)
- [Tutorial de XPath](https://www.w3schools.com/xml/xpath_intro.asp)
- [Page Object Model](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

