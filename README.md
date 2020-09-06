# spring-boot-rest-employees
Spring boot rest example

# Example URL's
1. GET http://localhost:8083/employees
2. GET http://localhost:8083/employees/1
3. POST http://localhost:8083/employees
{
    "name": "New Employee",
    "status": "Active"
}
4. PUT http://localhost:8083/employees/1
{
    "status": "Inactive"
}
4. DELETE http://localhost:8083/employees/1
