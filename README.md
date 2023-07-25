# med-api
Simple REST API for CRUD coded using Java 17 and Springboot. For database I used MySql and some other dependencies that you can see in pom.xml.

# Pre-checks
* Make sure you have jdk17, mysql and Insomnia (or Postman) properly installed in your machine. 

# How to run this amazing application that's gonna change your life for real:

1) Clone the repo.
2) Create `medapi_db` database.
3) Go to `application.properties` and change the env vars to what match yours.
4) Wait for it to download all Maven dependencies for the project.
5) RUN `MedApiApplication`. 

# How to make astonishing requests for DOCTOR endpoints

### SignUp
* Send a `post` request to `http://localhost:8080/doctor` with below body:
```
{
	"name": "John Smith",
	"email": "john@med.api",
	"phone": "11984772944",
	"register": "184023",
	"area": "DERMATOLOGY",
	"address": {
		"street": "St. John Rd.",
		"number": "5346",
		"extra": "Room 74",
		"zip": "74839",
		"city": "Dallas",
		"state": "TX"
	}
}
```

### GetDoctors
* Just send a `get` request to `http://localhost:8080/doctor`
* The response is a page containing 10 items ordered by the `name` column. 

### Update
* Send a `put` request to `http://localhost:8080/doctor` with below body:
```
{
	"id": 1,
	"email": "new_email@med.api",
	"address": { 
		"street": "Ant Road" }
}
```
* You can add in the body **only** the fields you'd like to be updated. `id` is the only mandatory key to be added.

### Delete
* Just send a `delete` request to `http://localhost:8080/doctor/{id}`.

# How to make astonishing requests for PATIENT endpoints

### SignUp
* Send a `post` request to `http://localhost:8080/patient` with below body:
```
{
	"name": "John Smith",
	"email": "john@hotmail.com",
	"phone": "1196472819",
	"documentId": "74803829",
	"address": {
		"street": "St. John Rd.",
		"number": "5346",
		"extra": "Flat 102",
		"zip": "74839",
		"city": "Yellowstone",
		"state": "MT"
	}
}
```

### GetPatient
* Just send a `get` request to `http://localhost:8080/patient`
* The response is a page containing 10 items ordered by the `name` column.

### Update
* Send a `put` request to `http://localhost:8080/patient` with below body:
```
{
	"id": 1,
	"email": "new_email@med.api",
	"address": { 
		"street": "Ant Road" }
}
```
* You can add in the body **only** the fields you'd like to be updated. `id` is the only mandatory key to be added.

### Delete
* Just send a `delete` request to `http://localhost:8080/patient/{id}`.

# That's it!
Thanks for reading the documentation! 
