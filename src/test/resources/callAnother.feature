Feature:

  Background:
    * url 'https://suggestions.dadata.ru'

  Scenario: 1
    * def examples =
      """
    function() {
    var ScenarioCases = Java.type('com.bell.ScenarioCases');
    var jd = new ScenarioCases();
    return jd.getCases();
    }
    """
    * json arguments = call examples
    * print arguments
    * def signIn = call read('classpath:called.feature') arguments
    * call signIn