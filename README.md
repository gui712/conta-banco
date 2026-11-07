
# Conta Banco

Projeto desenvolvido como exercício do curso de Java básico da DIO.

O programa utiliza Programação Orientada a Objetos para cadastrar clientes e contas bancárias pelo terminal.

## Funcionalidades

- Cadastro de clientes com nome, CPF e profissão
- Criação de contas correntes ou contas poupança
- Geração automática de agência e número da conta
- Saldo inicial
- Depósito
- Saque com validação de saldo
- Transferência entre contas
- Cadastro de várias contas durante a execução
- Listagem de todos os clientes e contas ao final

## Tecnologias

- Java
- Programação Orientada a Objetos
- Classes abstratas, herança e interface
- Classe `Scanner` para entrada de dados pelo terminal
- Classe `Locale` para leitura de valores decimais

## Como executar

É necessário ter o Java instalado e configurado no `PATH`.

No terminal, a partir da pasta `ContaBanco`, execute:

```bash
javac -d bin src/*.java
java -cp bin ContaTerminal
```

Também é possível executar pela classe `App`, que encaminha a execução para `ContaTerminal`:

```bash
java -cp bin App
```

## Exemplo de uso

```text
Por favor, digite o nome do cliente:
MARIO ANDRADES
Por favor, digite o CPF do cliente:
12345678900
Por favor, digite a profissão do cliente:
Desenvolvedor
Selecione o tipo de conta:
1 - Conta Corrente
2 - Conta Poupança
1
Por favor, digite o saldo inicial da conta:
237.48

Olá MARIO ANDRADES, obrigado por criar uma conta em nosso banco, sua agência é 1, conta 1 e seu saldo é R$ 237.48
```

Durante o cadastro, o sistema permite realizar depósitos, saques e transferências. Após informar que não deseja criar outra conta, são exibidos todos os clientes e seus respectivos extratos.

## Estrutura do projeto

```text
ContaBanco/
├── src/
│   ├── App.java
│   ├── Banco.java
│   ├── Cliente.java
│   ├── Conta.java
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   ├── IConta.java
│   └── ContaTerminal.java
├── bin/
└── README.md
```
