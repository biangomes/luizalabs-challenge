# Luizalabs Challenge

O Magalu está expandindo seus negócios e uma das novas missões do time de tecnologia é criar uma funcionalidade de Produtos Favoritos de nossos Clientes, em que os nossos aplicativos irão enviar requisições HTTP para um novo backend que deverá gerenciar nossos clientes e seus produtos favoritos. Esta nova API REST será crucial para ações de marketing da empresa e terá um grande volume de requisições então tenha em mente que a preocupação com performance é algo que temos em mente constantemente.

---

### Requisitos

- JDK 17;
- MySQL;
- Docker;
- Postman

---

### Documentação (Postman)

O link de acesso à documentação gerada pelo Postman é: https://documenter.getpostman.com/view/21879857/2s93RMVvCd

---

### Passo a passo

É necessário ter o MySQL 8.0 instalado em sua máquina, com a devida configuração.

Para **rodar** a aplicação, deve-se executar o seguinte comando:

```bash
docker-compose up
```

Para **parar** a aplicação, deve-se executar o comando abaixo:

```bash
docker-compose down
```



---

### Funcionalidades implementadas (com base nos requisitos)

- [x] Deve ser possível **criar**, **atualizar**, **visualizar** e **remover** ***Clientes***.
  - [x] O cadastro dos clientes deve conter apenas seu **nome** e **endereço de email**.
  - [x] Um cliente não pode se registrar duas vezes com o mesmo endereço de email.
- [x] Cada cliente só deverá ter uma única lista de produtos favoritos.
- [x] Em uma lista de produtos favoritos podem existir uma quantlidade ilimitada de produtos
  - [ ] Um produto não pode ser adicionado em uma lista caso ele não exista
  - [ ] Um produto não pode estar duplicado na lista de produtos favoritos de um cliente
- [ ] O dispositivo que irá renderizar a resposta fornecida por essa nova API irá apresentar o Título, Imagem, Preço e irá utilizar o ID do produto para formatar o link que ele irá acessar. Quando existir um review para o produto, o mesmo será exibido por este dispositivo. Não é necessário criar um frontend para simular essa renderização (foque no desenvolvimento da API).
- [x] O acesso à api deve ser aberto ao mundo, porém deve possuir autenticação e autorização.

### 



