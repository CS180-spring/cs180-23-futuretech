[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10791016&assignment_repo_type=AssignmentRepo)
# FutureDB-CS180

The Interface: Web UI (Spring boot)
* Feature: The username login in system
  * The user can create a new account.
  * The user can login in with account was created.


To run (in VSCode for now):
While in the document/ folder, run ./mvnw spring-boot:run
Then open localhost:8080 in a browser. Register by clicking on "Click here to register" and submit your Username and Password.
In a new terminal, navigate to the directory in which **items_list.json** is located (document/ which is the same location as where you ran ./mvnw spring-boot:run). With this new terminal open, run the python file **httpserver.py**.


## To start the program
Change directory to document/ and then run **./mvnw spring-boot:run**

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/d84bf8f9-c29b-4cd8-bb69-432e557e45b2)
If everything works correctly, you will see something like this:

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/6c424d17-8956-4d5e-bb8a-0d6985e805b9)

The application is now running on **localhost:8080/**


## To start the server
Navigate to document/ and open the **httpserver.py** file and click on "Run Python File" (it will be near the top-right corner by default):

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/d6fa8fa7-0342-400a-b1e0-07934d7b1de5)

This will run in a new terminal. Press **Ctrl + c** to end the python script and then change directory to document/

**Run Python File** again. Now the server is running (in the same terminal).

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/5d5bfc36-4184-40f4-9407-2bc31bb421f7)


## Using the program
Now everything should be set up correctly. Open a browser and go to **localhost:8080/**
It should look like this:

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/496c2649-a9b9-412f-87d0-b795cab46e9c)

If you are a returning user, click on **Login** and login with your credentials.
If you are a new user, click **Register** and register with a unique username and password. Afterwards, login with your credentials.


## Main Menu
The main menu will look like this:

![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/f5916de8-0f01-40bc-9ad3-f858981f48f6)

**Insert data** to manually insert reviews into one of your documents, **Delete data** to delete an existing review in one of your documents, **View data** to view one of your documents, or **Log out** if you are done.


## Insert data
Select a document to insert reviews into and then fill out the form with the review information, or upload an existing JSON file. **Note: this will only create an empty .json document. The data will have to be manually changed.**
![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/08256063-74f3-4fe6-8092-facfe56bf2e9)


## Delete data
Select a document to remove reviews from. Then, fill out the form with details of the review you want to remove. **Note: all of the fields must be filled out.**
![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/df951364-cfbb-4d29-abc9-127c8121cc2d)


## View data
Select a document to view the contents of.
![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/be96694e-f9a7-414d-8ae2-5e4d829f0633)

It will then look something like this:
![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/343db485-0687-4ab3-b8ca-1bae22eedbe1)

Use the "Quick filter" to quickly filter out reviews. Drag unwanted columns out. Click on columns you want to see using the toolbar on the right. Move columns to the top to group wanted columns together.
![image](https://github.com/CS180-spring/cs180-23-futuretech/assets/56359948/47775cca-1e4f-4c23-908e-361c9e336ba7)




<!-- 
## To run the file "UserLoginRegistration.java"
  User need to download the "src", ".idea", ".gitignore", "Login.iml" files, then you should be able to launch the file. <br>
  When you launch the file, you should see the welcome page of the FutureDB.<br>
You can select your option to register account, login account and visit as guest.<br>
<img width="209" alt="Screen Shot 2023-05-04 at 3 53 44 PM" src="https://user-images.githubusercontent.com/97145998/236347373-327447f7-1aff-4c1a-bb41-9c2a576cc6bb.png"> .<br>
 If you select login account, you can enter your username and password of the username. After that, you can login to the FutureDB.<br>
 <img width="275" alt="Screen Shot 2023-05-04 at 3 54 58 PM" src="https://user-images.githubusercontent.com/97145998/236347610-a9bec7ae-291d-4b5f-b556-07d95e27f3ff.png"> .<br>
 If you select register account, you should enter your username and passowrd. After that you should see that you have register successfully.<br>
<img width="396" alt="Screen Shot 2023-05-04 at 4 02 35 PM" src="https://user-images.githubusercontent.com/97145998/236348177-5c8e37fc-179a-43d7-a7bc-6c536b0a1a15.png"> .<br>
 User can choose the function that wants to use from the menu.<br>

## To run the feature "Keyword searching"
![image](https://user-images.githubusercontent.com/57771700/236345832-dec6a68c-aaca-4888-9232-f6dbd3eeccfb.png)
Once user has upload their file, user can type in a keyword. And then the program will start to search for the keyword in the file and display on the screen. Also, user has option to export the search result into json format and name the file.

## To run insert and delete data
<img width="352" alt="Screen Shot 2023-05-04 at 3 55 16 PM" src="https://user-images.githubusercontent.com/102633438/236347307-4c1d15b8-1745-41e2-9def-a5231ecbac21.png">
User can input the data with the correct data type, and user can input exit to exit the insert data.<br>
<img width="317" alt="Screen Shot 2023-05-04 at 3 52 29 PM" src="https://user-images.githubusercontent.com/102633438/236347436-942fda48-634c-4b32-96f3-f8e75b0316d2.png">
User can input the item name in the json file. If the item not found, it will show a not with "item not found".<br>

## Search and Filter data
User can search the information by user name, language, rating, Item name and time. <br>
User can filter the information by user name, language, rating, Item name and time, and filter will show all the result that match with filter criteria.<br>  -->
