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
User can input the item name in the json file. If the item not found, it will show a not with "item not found".
