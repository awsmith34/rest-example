# REST Example

### Prerequisites

Java 8
Maven 3

### Building

The project can be built with the default Maven settings, using the install lifecycle (clean can be included when rebuilding).

```
mvn clean install
```

## Running the Application

The application can be run from a terminal using the java command below.

```
java -jar target/rest-example-0.0.1-SNAPSHOT.jar
```

Alternatively, the application can be run from the terminal using Maven.

```
mvn spring-boot:run
```

## Testing with curl

### Greeting Endpoint
The greeting endpoint responds to a GET request with a simple greeting.

```
curl http://localhost:8080/greeting
```

Output

```
Hello world
```

### Paragraphs Endpoint
The paragraphs endpoint performs a single procedure that receives a paragraph as input, and returns the list of unique words within the paragraph. A word is defined by any consecutive alpha-numeric characters. In addition, the special characters apostrophe, underscore, and hyphen are included as valid characters within a word. Case is ignored when comparing words for equality, and the returned words will all be in lower-case.

```
curl -H "Content-Type: application/json" -X POST -d '{ "content": "The ineffective applicant rips the bicycle. Can the untidy temper tack our agenda? Should your schedule blink in the destined bias? Throughout the expanding hydrogen abides a latter temple. Rip the bicycle." }' http://localhost:8080/paragraphs/count-words
```

Output

```
[{"word":"a","count":1},{"word":"abides","count":1},{"word":"agenda","count":1},{"word":"applicant","count":1},{"word":"bias","count":1},{"word":"bicycle","count":2},{"word":"blink","count":1},{"word":"can","count":1},{"word":"destined","count":1},{"word":"expanding","count":1},{"word":"hydrogen","count":1},{"word":"in","count":1},{"word":"ineffective","count":1},{"word":"latter","count":1},{"word":"our","count":1},{"word":"rip","count":1},{"word":"rips","count":1},{"word":"schedule","count":1},{"word":"should","count":1},{"word":"tack","count":1},{"word":"temper","count":1},{"word":"temple","count":1},{"word":"the","count":6},{"word":"throughout","count":1},{"word":"untidy","count":1},{"word":"your","count":1}]
```

### Numbers Endpoint
The numbers endpoint performs a single procedure that takes a single number n as input and returns the first n Fibonacci numbers. Due to the slow performance of the implementation, the number must be between 0 and 48 inclusively. If the number is out of the range, the endpoint will respond with a bad request message.

```
curl -X POST http://localhost:8080/numbers/fibonacci/12
```

Output

```
[1,1,2,3,5,8,13,21,34,55,89,144]
```

### Threads Endpoint
The threads endpoint consists of a single procedure that creates and detects a deadlock condition between two threads. The response will indicate whether or not the deadlock was detected.

```
curl -X POST http://localhost:8080/threads/deadlock
```

Output

```
Deadlock occurred in threads 34 and 33
```

### Posts Endpoint
The posts endpoint calls the remote service at https://jsonplaceholder.typicode.com/posts and returns the contents of the response. The output is a list of JSON objects.

```
curl http://localhost:8080/posts
```

### Cars Endpoint
The cars endpoint manages a automobile repository.

Create
```
curl -H "Content-Type: application/json" -X POST -d '{ "make":"Acura","model":"TL","year":"2012","color":"BLUE" }' http://localhost:8080/cars
```

Update
```
curl -H "Content-Type: application/json" -X PUT -d '{ "make":"Acura","model":"TL","year":"2012","color":"RED" }' http://localhost:8080/cars
```

Get
```
curl http://localhost:8080/cars/2
```

Delete
```
curl -X DELETE http://localhost:8080/cars/4
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Jersey](https://jersey.github.io/)

## Authors

* **Andy Smith**
