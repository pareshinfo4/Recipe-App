# Recipe-App

Description : Recipe api for Recipe management

Technologies Used :

1) Spring Boot : 2.5.5
2) Java Version : 11
3) H2 Database
4) Postman

Swagger URL: http://localhost:9393/swagger-ui.html

H2 Console: http://localhost:9393/h2-console/

JDBC URL: jdbc:h2:mem:pareshh2

DB Name : H2db

Tables: 

a). RECIPE 
b). INGREDIENT 

Authentication Endpoint :


Recipe Endpoints:

1.For getting all the recipe details.

API Endpoint2: http://localhost:9393/recipes

Method : GET


2. For getting single recipe details by specific recipe id.

API Endpoint3: http://localhost:9393/recipe/1

Method : GET


3. For CREATE new recipe.

API Endpoint4: http://localhost:9393/addRecipe

Method : POST

Body: 

{
        
        "creationDate": "2021-10-20",
        "isVeg": true,
        "name": "Patato curry",
        "servings_no": 4,
        "ingredientList": [
            {
               
                "name": "Patato"
            },
            {
               
                "name": "oil"
            }
        ],
        "cookingInstructions": "cook patato in oil"
    }


4. For UPDATE an existing recipe details.

API Endpoint5: http://localhost:9393/updateRecipe/1

Method : PUT

Body: 

{
        "recipeId": 1,
        "creationDate": "2021-10-20",
        "isVeg": true,
        "name": "Tamato curry",
        "servings_no": 4,
        "ingredientList": [
            {
                "id": 1,
                "name": "tamato"
            },
            {
                "id": 2,
                "name": "oil"
            }
        ],
        "cookingInstructions": "cook tamato in oil"
    }

5. For DELETE a existing recipe details.

API Endpoint6 : http://localhost:9393/deleteRecipe/2

Method : DELETE