# Pets
### Modelo do dado
***_Class_***

```kotlin
data class Pet(
        @Id
        var _id:ObjectId = ObjectId.get(),
        var name:String = "",
        var species:String = "", //cat, dog, bird and go on
        var breed:String = ""
)
```

***_JSON_***
```json
{
    "id": "5cfeb673e6682862496872b1",
    "name": "Salem Saberhagen",
    "species": "cat",
    "breed": "American Shorthair"
}
```

### Test API
#### _save_
```sh
$ curl -X POST "http://localhost:8080/pet/save/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": \"5cfeb673e6682862496872b1\", \"name\": \"Salem Saberhagen\", \"species\": \"cat\", \"breed\": \"American Shorthair\"}"
```

#### _list_
```sh
$ curl -X GET "http://localhost:8080/pet/" -H "accept: */*"
```

#### _get_
```sh
$ curl -X GET "http://localhost:8080/pet/get/?id=5cfeb673e6682862496872b1" -H "accept: */*"
```

#### _update_
```sh
$ curl -X PUT "http://localhost:8080/pet/update/?id=5cfeb673e6682862496872b1" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Scooby\", \"species\": \"dog\", \"breed\": \"Great Dane\"}"
```

#### _delete_
```sh
$ curl -X DELETE "http://localhost:8080/pet/delete?id=5cfeb673e6682862496872b1" -H "accept: */*"
```