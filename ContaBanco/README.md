
# Conta Banco

Projeto desenvolvido como exercício do módulo de Sintaxe do curso de Java básico da DIO.

O programa recebe pelo terminal os dados de uma conta bancária e exibe uma mensagem confirmando a criação da conta.

## Informações solicitadas

- Número da conta
- Agência
- Nome do cliente
- Saldo inicial

## Tecnologias

- Java
- Classe `Scanner` para entrada de dados pelo terminal
- Classe `Locale` para leitura de valores decimais

## Como executar

É necessário ter o Java instalado e configurado no `PATH`.

No terminal, a partir da pasta do projeto, execute:

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
Por favor, digite o número da conta:
1021
Por favor, digite o número da agência:
067-8
Por favor, digite o nome do cliente:
MARIO ANDRADES
Por favor, digite o saldo da conta:
237.48

Olá MARIO ANDRADES, obrigado por criar uma conta em nosso banco, sua agência é 067-8, conta 1021 e seu saldo 237.48 já está disponível para saque
```

## Estrutura do projeto

```text
ContaBanco/
├── src/
│   ├── App.java
│   └── ContaTerminal.java
├── bin/
└── README.md
```
