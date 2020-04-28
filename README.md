# Auth-API
A **Scala Spring Boot REST API** with **OAuth**, **Role-based Access Control** and **JSON Web Tokens**.

## Purpose
In order to learn more about authentication and authorization, I decided to make a REST API that incorporated some of the most widely used methods and frameworks.

## Role-based Access Control (RBAC)
A user object contains a:

- ID
- Username
- Role

The role determines what a user can access within the system. There are three roles:

- **Admin** - can authenticate and access the _/user/all_ endpoint.
- **User** - can authenticate and cannot access the _/user/all_ endpoint.
- **Banned** - cannot authenticate.

## Authentication
A user is authenticated by hitting the _/authenticate_ endpoint with a User object:
```json
{
    "id": 1,
    "username": "Amy",
    "role": "User"
}
```

_Note: A real authentication system would take a username and password, and verify the password is correct._

If the user exists and is not banned, then the response is given with a JWT that contains a User object.
If the user is banned then an error is returned.

## Authorization
To access the _/user/all_ endpoint, a user must have the Admin role. To make a successful request a user must hit the endpoint with an authorization header containing a JWT token. The JWT token is decoded and a check is made to see if the user is an Admin. If they are then the list of users is returned. If they are not then an error is returned.

## JSON Web Token
This application makes use of [Paul Dijou's Jwt-Scala library](https://github.com/pauldijou/jwt-scala).

_Note: The secret key to encode/decode a JWT is currently hardcoded into the JwtService. A real access token system would not store the value in the application, instead it would store it in a secure key management server. However, as JWTs are not encrypted, no sensitive information should be stored in them._

## Step-by-step Guide
1 :- Fill the User repository with filler data.
```
curl http://localhost:8080/user/fill
```

2 :- Get a user.
```
curl localhost:8080/user/get/2
```
```json
{
    "id": 2,
    "username": "Ben",
    "role": "Admin"
}
```

3 :- Authenticate the user.
```
curl --header "Content-Type: application/json" \
     --request POST \
     --data '{"id":2,"username":"Ben","role":"Admin"}' \
     localhost:8080/authenticate
```
```
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJCZW4iLCJyb2xlIjoiQWRtaW4ifQ.80q1efGYDRFzvNDM8VJ8zbQo4wzsAV5F39TacuL5tLY
```

4 :- Request all users.
```
curl -H "Authorization: Beaer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJCZW4iLCJyb2xlIjoiQWRtaW4ifQ.80q1efGYDRFzvNDM8VJ8zbQo4wzsAV5F39TacuL5tLY" 
     http://www.example.com
```
```json
[
    {
        "id": 1,
        "username": "Amy",
        "role": "User"
    },
    {
        "id": 2,
        "username": "Ben",
        "role": "Admin"
    },
    {
        "id": 3,
        "username": "Charlie",
        "role": "Banned"
    },
    {
        "id": 4,
        "username": "Devon",
        "role": "User"
    },
    {
        "id": 5,
        "username": "Emily",
        "role": "Banned"
    },
    {
        "id": 6,
        "username": "Ffion",
        "role": "User"
    }
]
```