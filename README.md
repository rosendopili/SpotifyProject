# SpotifyProject
An app that mimics spotify

There are 5 Separate packages within the main project package. 

Within these packages, the project is broken down into 5 major categories.  JWT/Security, User, Song, User Role and User Profile. 

They are broken down as follows: 
  
  CONFIG: 
  
  Contains JWT implementation in three files. 

  1) JwtRequestFilter- This file is meant to generate token headers with each request and will throw exceptions for unauthorized requests. 
  2) JwtUtil- This file sets the length of validity for the JWT and will generate the token itself after user validation. 
  3) SecurityConfig- Responsible for assigning levels of necessary authentication based on user role and the end point they are attempting to access.  
  
  MODELS:
  
  This package mostly contains the blueprint for the project data tables.  Breaking out each table into a separate file made for better organization.  

    1) JwtResponse- The only file in the models package that does not generate a datatable.  Through the JwtResponse method, we are able to return generated tokens for specific endpoint access requests (namely log-in and signup). 
    2) Song- the song model generates a song datatable that includes a generated ID, title, length, artist and genre.  The song Data Table is referenced by the user_songs data table by way of song_id.  The file also contains setter and getter methods for all the generated columns in addition to a Song Object method to be referenced later on. 
    3) User- the user model initiates the users datatable that includes a generated ID, username & password.  The users Data Table is referenced by the user_profile table by way of user_profile_id in addition to the user_role table by way of user_role_id and user_songs table by way of user_songs_id.  
    The user model includes a user object method, user getter and setter methods as well as an add song method, which places added songs into an array list specific to each user. 
    4) UserProfile- The userprofile model includes a generated ID and an email address field.  It references the users data table by way of user_profile_id. 
    5) UserRole- The UserRole model creates the user_role data table which a user_role field entitled 'name' and a generated ID. 
    
    REPOSITORY: 
    
    The repository package includes interfaces for the Song, User Profile, User Role and User modules. Each relative interface extends the Spring's CRUD repository to take advantage of the built in create, read, update and delete functionalities embedded within the programming model.  These all contain methods meant to make the data searchable by profile, user, role or song.  
    
    SERVICE: 
    
    The service pacakge contains service and service iplementation files for User, Song, User Profile and User Role.
    
    Each service file is an interface that is referenced by the implentation file.  
    
    The User service implementation file contains most of the user functionality including login, create user, list users, find user by name, and granting authorities to users based on role. 
    
    CONTROLLER: 
    
    The controller class contains the mapped out end points for User, Song, User Role and User Profile.  Each endpoint has a defined fetch request(get, put, post delete) as well as the expected return values when accessing those endpoints successfully.  
    
    FUNCTIONALITY: 
    
    Based on postman testing, I am still having issues with getting a successful user signup or a valid JWT to populate.  Unfortunately, because of this, functionality such as search by username, add user songs, add role, list users and get profile is not currently available. 
    
    CHALLENGES: 
    
    The project is an ongoing challenge due to the current lack of functionality.  Resolving the signup issue and generating a token have, however, been the most difficult hurdles to overcome thus far.  
    
    CONCLUSION: 
    
    My biggest takeaway was gaining a better understanding of how an API works, specifically in conjunction with a database.  Having used an API for a previous front-end development, this experience has made a lot of the process clearer, specifically in reference to MVC design.  
    
