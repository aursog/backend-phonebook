# Phonebook backend project
![Java 11](https://img.shields.io/badge/Java-11-orange)
![framework](https://img.shields.io/badge/SpringBoot-2.7.1-blue)

## Description
Backend for management of Phonebooks. This api works with Java 11 technology and Spring Boot 2.7.1

The routes are the following

| Route                  | Description                                     | Status Code | Method |
|------------------------|-------------------------------------------------|-------------|--------|
| /phonebook/create      | Creation of a new Phonebook registry            | 201         | POST   |
| /phonebook/list        | List of all Phonebook registered                | 200         | GET    |
| /phonebook/delete/{id} | Delete the phonebook with id                    | 200 | DELETE |
| /phonebook/get/{id}    | Get the phonebook with id (not implemented yet) | 200 | GET    |


<details>
    <summary>JSON Object</summary>

#### Creation input JSON Object
```json
{
  "fullname": <String>,
  "phonenumber": <String>
}
```

#### Creation output JSON Object

```json
{
  "id": <Long>,
  "uri": "/phonebook/get/{id}"
}
```

#### List all JSON Object output
```json
[
  {
    "id": <Long>,
    "fullname": <String>,
    "phonenumber": <String>
  }
]
```

#### Delete output Phonebook JSON Object

```json
{
  "message": <String>
}
```
</details>

**Architectural approach**: Clean Architecture / Hexagonal Architecture.

**PR History**: https://github.com/aursog/backend-phonebook/pulls?q=is%3Apr+is%3Aclosed

## Requirements

 * Java 11 OpenJDK
 * Gradle 7.4.2
 * Lombok
 * Spring Boot 2.7.1
 * DB MySQL

## Installation

Strongly recommended the Lombok plugin inside of the IDE.

Install JVM 11

```bash
sdk install java 11.0.2-open
```

Clone the repository and execute:

```bash
./gradlew bootRun 
```

For open on debug mode

```bash
./gradlew bootRun --debug-jvm 
```

For test execution

```bash
./gradlew test 
```

## Authors and acknowledgment

Anggelo Urso @aursog