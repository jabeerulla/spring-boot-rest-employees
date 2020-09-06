# Spring boot rest API samples
* Spring boot rest example with CRUD operations

### Example URL's
* Get all employees  __GET__ http://localhost:8083/employees
```
curl --location --request GET 'http://localhost:8083/employees'
```
* Get employee by id : __GET__ http://localhost:8083/employees/{id}
```
curl --location --request GET 'http://localhost:8083/employees/1'
```
* Create employee : __POST__ http://localhost:8083/employees
```
curl --location --request POST 'http://localhost:8083/employees' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Employee 51",
    "status": "Active"
}'
```

* Update employee : __PUT__ http://localhost:8083/employees/{id}
```
curl --location --request PUT 'http://localhost:8083/employees/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Employee 1 Updated",
    "status": "Inactive"
}'
```
* Delete employee : __DELETE__ http://localhost:8083/employees/{id}
```
curl --location --request DELETE 'http://localhost:8083/employees/1' \
--data-raw ''
```
