Feature: Customer

  Background:
    * url "http://admin:builders@localhost:8080/customers"

  Scenario: create, index, retrieve, modify and destroy customers
    Given request
      """
      {
          "fullName": "João Correia",
          "birthDate": "1998-07-02",
          "email": "me@castanhocorreia.com",
          "addresses": [
            {
              "streetName": "Dorival Caymmi",
              "city": "Salvador",
              "postCode": "41635150",
              "state": "BA",
              "country": "BR"
            }
          ]
      }
      """
    When method POST
    Then status 201
    And match response.age == "#notnull"

    * def id = response.id
    * def address = response.addresses[0].id

    When method GET
    Then status 200
    And match response.content == "#[1]"

    Given path id
    When method GET
    Then status 200
    And match response.age == "#notnull"
    And match response.birthDate == "1998-07-02"
    And match response.email == "me@castanhocorreia.com"
    And match response.addresses == "#[1]"

    Given request
      """
      {
        "id": "#(id)",
        "fullName": "João Castanho Correia",
        "addresses": [
            {
                "id": "#(address)",
                "state": "Bahia",
                "country": "Brazil"
            }
        ]
      }
      """
    When method PUT
    Then status 200
    And match response.fullName == "João Castanho Correia"
    And match response.addresses[0].state == "Bahia"
    And match response.addresses[0].country == "Brazil"

    Given path id
    When method DELETE
    Then status 200

    Given path id
    When method GET
    Then status 404

  Scenario: retrieve customers page based on parameters
    Given request
      """
      {
          "fullName": "Alejandra Callisti",
          "birthDate": "1984-11-22",
          "email": "me@alejandracallisti.com",
          "addresses": [
            {
              "streetName": "Juan de Garay",
              "city": "Buenos Aires",
              "postCode": "C1150",
              "country": "Argentina"
            }
          ]
      }
      """
    When method POST
    Then status 201

    Given param fullName = "Callisti"
    When method GET
    Then status 200
    And match response.content == "#[1]"

    Given param fullName = "Paiva"
    When method GET
    Then status 200
    And match response.content == "#[0]"

    Given param fullName = "Callisti"
    Given param birthDate = "1984-11-22"
    When method GET
    Then status 200
    And match response.content == "#[1]"

    Given param postCode = "C1150"
    When method GET
    Then status 200
    And match response.content == "#[1]"

    Given param postCode = "13418110"
    When method GET
    Then status 200
    And match response.content == "#[0]"

  Scenario: create customers with invalid information
    Given request {}
    When method POST
    Then status 400
    And match response.addresses == "must not be null"
    And match response.birthDate == "must not be null"
    And match response.fullName == "must not be blank"
    And match response.email == "must not be null"

  Scenario: retrieve and destroy customers with invalid id
    Given path '00000000-0000-0000-0000-000000000000'
    When method GET
    Then status 404

    Given path '00000000-0000-0000-0000-000000000000'
    When method DELETE
    Then status 404