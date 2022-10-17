Feature: Project

  Background:
    Given obtengo mi id workspace

  Scenario Outline: Consultar Projectos resultado exitoso
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se valida que el id no sea null
    @Project
    Examples:
      | operation | entity   | jsonName   | status |
      | GET       | PROJECTS | project/rq | 200    |

  Scenario Outline: Consulta Projectos resultado erroneo
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se obtuvo el response esperado en <entity> con el <response>
    @Project
    Examples:
      | operation | entity | jsonName       | response       | status |
      | GET       | ERROR  | project/rq_401 | project/rs_401 | 401    |

  Scenario Outline: Consulta Projecto por id resultado exitoso
    When I perform a '<operation>' to 'PROJECTS' endpoint with the 'project/rq' and ''
    And se obtuvo el status code <status>
    Then se valida que el id no sea null
    Given se toma el id de un projecto '<operation>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    @Project
    Examples:
      | operation | entity  | jsonName             | status |
      | GET       | PROJECT | project/projectId/rq | 200    |


  Scenario Outline: Consulta Projecto por id resultado erroneo
    Given un id invalido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se obtuvo el response esperado en <entity> con el <response>

    Examples:
      | operation | entity | jsonName                 | response                 | status |
      | GET       | ERROR  | project/projectId/rq_400 | project/projectId/rs_400 | 400    |

#  Scenario Outline: Agregar y Eliminar Projectos resultado exitoso
#    When I perform a 'POST' to 'PROJECT' endpoint with the 'project/add/rq' and ''
#    And se obtuvo el status code <201>
#    Given se toma el id de un projecto de la respuesta 'POST'
#    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
#    And se obtuvo el status code <status>
#
#    Examples:
#      | operation | entity  | jsonName             | status |
#      | DELETE    | PROJECT | project/projectId/rq | 200    |

  Scenario Outline: Modificar Projecto
    When I perform a 'GET' to 'PROJECTS' endpoint with the 'project/rq' and ''
    And se obtuvo el status code <status>
    Given se toma el id de un projecto '<operation>'
    And un nombre '<name>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    And se valida que el nombre fue editado '<name>
    @Project
    Examples:
      | operation | entity  | name     | jsonName          | status |
      | PUT       | PROJECT | Project5 | project/update/rq | 200    |
      | PUT       | PROJECT | Project6 | project/update/rq | 200    |
