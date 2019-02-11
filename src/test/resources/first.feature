Feature: first try

  Background:
    * url 'https://suggestions.dadata.ru'
    * def examples_notEmpty = read('classpath:examples.csv')
    * print examples_notEmpty

  Scenario Outline: get org by INN <key>
    Given path 'suggestions/api/4_1/rs/findById/party'
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And header Authorization = "Token 3a7a25d6d5f2b2d5a9729c1f6321a99f32860dd0"
    And request {"query" : "<key>"}
    When method POST
    Then status 200
    And match response.suggestions[0].value == "<value>"
    Examples:
      | read('classpath:examples.csv') |