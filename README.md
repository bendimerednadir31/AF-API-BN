
# AF API FOR USER REGISTRATION

This Project [AF-API] exposes two services for user registration based on a his specific information, the first service allows to the new user "from France and adult" to register himself and being a new user on the company website, the second service allows to take a look on this user details


## Authors

- [@BENDIMERED](https://github.com/bendimerednadir31)



## AF API references

#### Get all items

```http
  POST /api/v1/auth/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `JSON_BODY` | `JSON` | Http request is http://localhost:8080/api/v1/auth/register |

#### Get item

```http
  GET /api/v1/auth/afUser/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `INTEGER` | **Required** Id of user to fetch. http://localhost:8080/api/v1/auth/afUser/${id}




#UTILS LINKS FOR THE APPLICATION

[OPENAPI-DOCUMENTATION](http://localhost:8080/swagger-ui/index.html#)

[DATABASE H2](http://localhost:8080/h2-afApiUser)


[SECRET_KEY REQUIRED FOR TOKEN GENERATE](https://generate-random.org/encryption-key-generator?count=1&bytes=256&cipher=aes-256-cbc&string=&password=)
