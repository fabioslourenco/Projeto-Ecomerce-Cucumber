Feature: Cadastro de um novo usuário

  EU como Analista de Qualidade
  QUERO garantir a qualidade do serviço de cadastro
  PARA usuários acessarem e realizar compras online

  Background: Usuário deve acessar tela inicial de serviço de cadastro
    Given que acessei a aplicação
    And cliquei em sign in


  Scenario: Usuário deve acessar serviço de cadastro com sucesso
    When digitar endereço de email_NãoCriado
    And clicar em create an account
    Then usuario é direcionado para tela de cadastro


  Scenario: Aplicação deve exibir msg de erro quando usuario tentar acessar serviço de cadastro sem email
    When clicar em create an account
    Then aplicação exibe msg de erro


  Scenario: Aplicação deve apresentar msg de erro quando usuario colocar email invalido
    When digitar endereço invalido
    And clicar em create an account
    Then aplicação acusa erro


  Scenario: Usuário deve se cadastrar com sucesso na aplicação
    When digitar endereço de email_NãoCriado
    And clicar em create an account
    And cadastrar meus dados obrigatórios
    Then aplicação exibe msg de confirmação

  Scenario: Aplicação deve exibir erro ao usuário digitar email já cadastrado
    When digitar endereço de email_criado
    And clicar em create an account
    Then Aplicação acusa email ja cadastrado


  Scenario Template: Aplicação deve exibir msg de erro após inclusão de nome incorreto
    Given digitar endereço de email_NãoCriado
    And clicar em create an account
    When digitar "<name>"
    And digitar outros dados obrigátorios
    Then aplicaçao exibe "<mensagem>"

  Examples:
    | name   | mensagem               |
    | f+abio | firstname is invalid.  |
    |        | firstname is required. |
    | f3b1o  | firstname is invalid.  |

  Scenario Template: Aplicação deve exibir msg de erro após inclusão de sobrenome incorreto
    Given digitar endereço de email_NãoCriado
    And clicar em create an account
    When digitar o "<lastName>"
    And incluir outros dados
    Then aplicaçao acusa "<mensagem>"

  Examples:
    | lastName   | mensagem              |
    |            | lastname is required. |
    | l+ourenço  | lastname is invalid.  |
    | lo3urenc4o | lastname is invalid.  |


  Scenario Template: Aplicação deve exibir msg de erro após inclusão de endereço incorreto
    Given digitar endereço de email_NãoCriado
    And clicar em create an account
    When digitar meu "<endereço>"
    And dados demais dados obrigatorios
    Then aplicação mostra "<mensagem>"

  Examples:
    | endereço                | mensagem              |
    | str@et woodfiel+ dr 523 | address1 is invalid.  |
    |                         | address1 is required. |

  Scenario Template: Aplicação deve exibir msg de erro após inclusão de cidade incorreta
    Given digitar endereço de email_NãoCriado
    And clicar em create an account
    When complemento de dados
    And digitar cidade "<cidade>"
    Then "<mensagem>" é exibida

  Examples:
    | cidade | mensagem          |
    | a@rb+n | city is invalid.  |
    |        | city is required. |

  Scenario: Aplicação deve exibir erro ao selecionar o Estado incorreto
    And digitar endereço de email_NãoCriado
    And clicar em create an account
    When cadastrar informaçoes
    And selecionar estado
    Then msg de erro é apresentada

  Scenario Template: Aplicação exibe erro com zipCode no formato incorreto
    And digitar endereço de email_NãoCriado
    And clicar em create an account
    When cadastrar informaçoes sem zipCode
    And cadastrar "<zipeCode>"
    Then aplicação apresent "<mensagem>" erro zipCode

  Examples:
    | zipeCode | mensagem                                                                         |
    | 38414446 | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
    | 384      | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
    |          | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
    | 38@4-    | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
    | 8 5 8    | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
