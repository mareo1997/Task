Here is the spec for the first step in their process:

Please create an empty Spring Boot project.

Add the following REST API endpoints

GET /tasks <- Returns all tasks
GET /tasks/:id <- Returns Task by ID

POST/tasks <- Creates a Task
PUT  /tasks/:id <- Updates a Task by ID

Task model should include:

title: String
description: String
completed: Boolean
createDate: Date
completed: Date


Store the task data in memory for retrieval and updates, no database required

Please commit the code to a git platform of your choice (github/gitlab/bitbucket/etc) and share the link with us.

Team will pull and run the code to test the API so ensure Readme include all details required to start the project.

----------------------------------------------------------------------------------------------------------------------

The application runs on port 8080. 

To test in postman run the urls. 

I was unable to run the springboot application properly due to differences in Java Runtime version but the methods and classes should be working correctly.

GET

http://localhost:8080/tasks

Should return the list of all tasks in in JSON format due to using RESTController annotation. 

If there is no content or is null then status code returned is 204 otherwise 200.

GET

http://localhost:8080/tasks/?id=1

Should return the JSON format on the id if it exists. The @PathVariable takes id to 

Uses a try catch method for nullpointer and indexoutofbounds exceptions. If there is no content or is null then status code returned is 204 otherwise 200.


POST

http://localhost:8080/tasks

Takes input in JSON format. Below is an example of a format that should be accpted. If the task is created then the message REGISTRATION SUCCESSFUL and 200 will return if not then INVALID FORM DATA and 400.

{
  "title": "Star Wars",
  "description": "Sci fi genre",
  "completed": false,
  "createDate": "1976-10-20",
  "completed": "1999-10-20"  
}

PUT

http://localhost:8080/tasks/?id=1

Takes input in JSON format. Below is an example of a format that should be accpted. If the task is updated then the message UPDATE SUCCESSFUL and 200 will return if not then INVALID FORM DATA and 400.

{
  "id": 1,
  "title": "Star Wars",
  "description": "Fantasy genre",
  "completed": true,
  "createDate": "1976-10-20",
  "completed": "2020-05-04"  
}




