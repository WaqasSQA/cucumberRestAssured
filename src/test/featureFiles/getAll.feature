Feature: Verify GET all from APIs

  Scenario Outline: Get all from APIs
    Given get call to "<url>"
    Then get the "<StatusCode>"

    Examples:
    | url      | StatusCode |
    | /persons | 200        |


  Scenario Outline: Get all from APIs
    Given get call to "<url>"
    Then get the author "<author>"

    Examples:
      | url      | author |
      | /persons | Saleem |