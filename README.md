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
```

### Paragraphs Endpoint
The paragraphs endpoint performs a single procedure that receives a paragraph as input, and returns the list of unique words within the paragraph. A word is defined by any consecutive alpha-numeric characters. In addition, the special characters apostrophe, underscore, and hyphen are included as valid characters within a word. Case is ignored when comparing words for equality, and the returned words will all be in lower-case.

```
curl -H "Content-Type: application/json" -X POST -d '{ "content": "The ineffective applicant rips the bicycle. Can the untidy temper tack our agenda? Should your schedule blink in the destined bias? Throughout the expanding hydrogen abides a latter temple." }' http://localhost:8080/paragraphs/count-words
```

Output

```
```

### Numbers Endpoint
The numbers endpoint performs a single procedure that takes a single number n as input and returns the first n Fibonacci numbers. Due to the slow performance of the implementation, the number must be between 0 and 48 inclusively. If the number is out of the range, the endpoint will respond with a bad request message.

```
curl -X POST http://localhost:8080/numbers/fibonacci/12
```

Output

```
```

### Threads Endpoint
The threads endpoint consists of a single procedure that creates and detects a deadlock condition between two threads. The response will indicate whether or not the deadlock was detected.

```
curl -X POST http://localhost:8080/threads/deadlock
```

Output

```
```

### Posts Endpoint
The posts endpoint calls the remote service at https://jsonplaceholder.typicode.com/posts and returns the contents of the response.

```
curl http://localhost:8080/posts
```

Output

```
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Andy Smith**
