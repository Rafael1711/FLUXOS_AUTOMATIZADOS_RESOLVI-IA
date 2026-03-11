# 📊 Automação de Monitoramento de Usuários — Selenium + Java

## 📌 Sobre o Projeto

Este projeto consiste em uma **automação web desenvolvida em Java utilizando Selenium WebDriver**, responsável por monitorar a quantidade de usuários cadastrados na plataforma **Resolvi.IA** e gerar relatórios automáticos por e-mail para a liderança da empresa.

A automação acessa o painel administrativo da aplicação, coleta a quantidade atual de usuários cadastrados e compara com um valor previamente registrado em um arquivo local. A partir dessa comparação, um relatório é enviado automaticamente informando o status da base de usuários.

Este projeto demonstra habilidades importantes em **automação de testes, manipulação de dados, integração com serviços externos e monitoramento automatizado de sistemas**.

---

# 🎯 Objetivo da Automação

O objetivo da automação é **monitorar variações na quantidade de usuários cadastrados no sistema**, notificando automaticamente os responsáveis técnicos quando houver alteração.

### Fluxo da automação:

1. Acessar a plataforma  
   `https://resolvi.ia.br`

2. Realizar autenticação como **administrador**

3. Navegar até a área de **gerenciamento de usuários**

4. Capturar a **quantidade atual de usuários do sistema**

5. Ler a **quantidade anterior registrada** em um arquivo local

6. Comparar os valores

7. Enviar um **relatório automático por e-mail** com o resultado da análise

---

# 🧰 Tecnologias Utilizadas

- Java  
- Selenium WebDriver  
- Maven  
- Jakarta Mail API  
- ChromeDriver  
- Manipulação de arquivos `.txt`  
- Local Storage Injection  

---

# 🔐 Estratégia de Autenticação

A plataforma utiliza **OAuth do Google** para autenticação. Esse tipo de autenticação normalmente **bloqueia automações Selenium**, pois exige interação humana.

Para contornar essa limitação, foi utilizada a seguinte abordagem:

1. Um **access_token válido** é previamente obtido.

2. Esse token é armazenado em um **arquivo local `.txt`**.

3. Durante a execução da automação:

   - O token é lido do arquivo  
   - Inserido diretamente no **Local Storage do navegador**

4. Após inserir o token, a página é recarregada e o sistema reconhece o usuário como autenticado.

Essa técnica permite que a automação **acesse diretamente a área administrativa sem passar pelo fluxo interativo do OAuth**.

---

# 📊 Lógica de Monitoramento

A automação realiza uma comparação entre dois valores.

## 1️⃣ Quantidade atual de usuários

Obtida diretamente da interface do sistema através da automação **Selenium**.

## 2️⃣ Quantidade anterior de usuários

Lida de um arquivo local

## 3️⃣ Comparação dos valores

A automação compara os valores utilizando três possíveis cenários:

| Condição | Resultado |
|--------|--------|
| Atual > Anterior | Novos usuários foram cadastrados |
| Atual < Anterior | Possível remoção de usuários |
| Atual == Anterior | Nenhuma alteração na base |

---

# 📧 Envio Automático de Relatórios

Após a comparação, a automação envia automaticamente um **relatório por e-mail** para:

- CEO da empresa  
- CTO da empresa  

O envio é realizado utilizando a **Jakarta Mail API**.

Para autenticação no Gmail foi utilizada:

- **Senha de aplicativo de 16 caracteres gerada pelo Google**
- Armazenada em um **arquivo local `.txt`**

Isso garante maior segurança e evita o uso da senha principal da conta.
