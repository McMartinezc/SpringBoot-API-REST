# S05T01N02MartinezMCarmen
 
 Tenim una entitat anomenada FlorEntity, que disposa de les següents propietats:

-          Integer pk_FlorID

-          String nomFlor

-          String paisFlor

 També tenim una DTO anomenada FlorDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:

-          String tipusFlor.

Aquesta propietat, en funció del país d'origen de la flor, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat FlorEntity a una base de dades MySQL, seguint el patró MVC.

El consell és que FlorDTO la facis servir al Controller, i FlorEntity al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

La classe ubicada al paquet controllers (FlorController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

http://localhost:9001/flor/add

http://localhost:9001/flor/update

http://localhost:9001/flor/delete/{id}

http://localhost:9001/flor/getOne/{id}

http://localhost:9001/flor/getAll
 
 Recursos utilitzats:
 
 https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 
 https://www.tutorialspoint.com/spring_boot/spring_boot_enabling_swagger2.htm
 
 https://howtodoinjava.com/swagger2/swagger-spring-mvc-rest-example/
 
 https://www.coderearth.net/swagger-java-spring-boot-rest-api/

https://codingnconcepts.com/spring-boot/how-to-configure-swagger/#:~:text=How%20to%20configure%20Swagger%20in%20spring%20boot%201,7%20Generate%20REST%20Client%20with%20Swagger%20Codegen%20

https://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services
