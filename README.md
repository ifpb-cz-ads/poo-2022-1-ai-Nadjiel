# Imagine Engine

## Sobre

Imagine Engine é uma engine construida em Java que auxilia na criação de jogos 2D nessa linguagem. Sua construção foi realizada tendo como principal intuito o aprendizado da linguagem de programação em questão e do paradigma de Programação Orientada a Objetos.

Essa Engine foi produzida originalmente no repositório [github.com/Nadjielse/imagine-engine](https://github.com/Nadjielse/imagine-engine) e posteriormente movida para este repositório para melhor acesso do professor.

Além da engine em si, este repositório também contém um protótipo de jogo - nomeado protozelda - feito utilizando a Imagine para exemplificar seu uso e provar seu funcionamento adequado.

## Como usar

Para usar a Engine basta fazer o download da pasta `imagine` e deixá-la na raíz do seu projeto; assim você deve ser capaz de importar as classes nela presentes.

Já para rodar o protótipo de jogo incluso deve-se compilá-lo com o comando:

```
javac Main.java
```

E posteriormente usar o seguinte comando para rodá-lo:

```
java Main
```

Ambos os comandos devem ser inseridos enquanto na pasta raíz desse repositório.

## Estrutura das Classes

A seguir está uma imagem mostrando o Diagrama de Classes da Imagine Engine para proporcionar uma visão mais detalhada de sua implementação:

![Diagrama de Classes da Imagine Engine](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/diagrama/Imagine%20Engine.png)

## Aplicação da POO

Como dito anteriormente, esse projeto foi feito utilizando o paradigma da Orientação a Objetos e seu objetivo principal foi trazer aprendizado sobre tal assunto. Assim, a seguir serão pontuados como conceitos da OO foram aplicados na Imagine Engine.

### Encapsulamento

O Encapsulamento é usado em praticamente toda a Engine para possibilitar a abstração de conceitos complexos e prevenir outros programadores de modificar trechos de código desnecessários. Esse uso é feito através dos modificadores de acesso disponíveis na linguagem Java e, muitas vezes, também por meio dos _getters_ e _setters_.

### Herança

A Herança de classes foi implementada nesse projeto por muitas vezes com o intuito de evitar a repetição de código e melhorar o relacionamento entre elas, além de possibilitar o Polimorfismo. Exemplos desse uso são facilmente observados no Diagrama de Classes disponível aqui no README e podem ser exemplificados pela herança entre as classes [`GameElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/game/GameElement.java), [`StageElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/stage/StageElement.java) e [`AnimatableStageElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/stage/AnimatableStageElement.java).

### Herança Múltipla

A Herança Múltipla (realizada através da implementação de interfaces) tem seu uso nesse projeto concretizado para proporcionar uma melhor organização e estruturação do código, além de permitir o Polimorfismo. Polimorfismo esse realizado, por exemplo, com a interface [`CameraType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/camera/type/CameraType.java), ou também, com a interface [`ScenarioType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/scenario/type/ScenarioType.java).

### Polimorfismo

Sendo um conceito muito importante da Orientação a Objetos, não foi deixado de fora na implementação da Imagine Engine. Exemplos de suas aplicações são as realizadas pela a interface [`CameraType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/camera/type/CameraType.java) ou pela interface [`ScenarioType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/scenario/type/ScenarioType.java).

## Aplicação dos tópicos das etapas semanais

Todos os assuntos estudados no decorrer das etapas do projeto tiveram suas aplicações realizadas em inúmeras partes do projeto:

- As **declarações de variáveis** são usadas nos campos das classes do projeto e também nos corpos de métodos para guardar diversas informações. Além disso, as **operações aritméticas e lógicas** são usadas, respectivamente, para cálculos diversos e para tarefas como validações de valores de variáveis.

- As **estruturas condicionais** são usadas por diversas vezes juntamente das operações lógicas para ações como as validações de variáveis, além da lógica geral do programa.

- As **estruturas de repetição** estão presentes nos momentos em que a engine itera sobre os diversos elementos de uma fase; ou também na estrutura principal do seu controle de fluxo, a qual regula o FPS dos jogos.

- **Classes abstratas** tem seu uso exemplificado pelas classes [`GameElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/game/GameElement.java), [`StageElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/stage/StageElement.java) e [`AnimatableStageElement`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/stage/AnimatableStageElement.java), como dito anteriormente. Essas classes são a base dos demais elementos dos jogos feitos com essa engine.

- As **Interfaces** estão presentes na forma das classes [`GameFluid`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/flow/GameFluid.java), [`ScenarioType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/scenario/type/ScenarioType.java) e [`CameraType`](https://github.com/ifpb-cz-ads/poo-2022-1-ai-Nadjiel/blob/main/imagine/camera/type/CameraType.java) que são implementadas por outras diferentes classes.