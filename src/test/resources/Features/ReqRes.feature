Feature: Verifying the APIs of ReqRes

Background:

Given I give the base URI and request specifictions

Scenario: Verifying and validating the GET request and response 

When I send the "GET" request with "getData" endpoint

Then I verify "GET" response code should be 200

Scenario: Verifying and validating the POST request and response 

Given I give the base URI and "POST" request body

When I send the "POST" request with "createData" endpoint

Then I verify "POST" response code should be 201

Scenario: Verifying and validating the PUT request and response 

Given I give the base URI and "PUT" request body

When I send the "PUT" request with "updateData" endpoint

Then I verify "PUT" response code should be 200


Scenario: Verifying and validating the DELETE request and response 



When I send the "DELETE" request with "deleteData" endpoint

Then I verify "DELETE" response code should be 204

