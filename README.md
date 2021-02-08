Before start - clone this repo and open in your studio;
Install chromedriver;
Install allure locally for reports;
Make import of all dependencies;
To run the tests - go to src.test.java.com.daily.qa.conf and right click on testng.xml file -> click Run;
To see the result of passed tests - use command "allure serve allure-results" in your terminal;


Simple Checklist for DailyTodo.org
Created by Serhii Zinych

Test case 1. Check if application is loaded:
	
	- Test step 1. Go to https://dailytodo.org/;

	Expected Result: Home page of an application should be loaded. Sample image should be displayed."Create your Daily Todo list" button should be displayed and enabled

Test case 2. Check if the user can create new goals:

	- Test step 1. Go to https://dailytodo.org/;
	- Test step 2. Click the "Create your Daily Todo list" 
	- Test step 3. Assert that instructions are displayed;
	- Test step 4. Due to the instructions enter a few goals;
	- Test step 5. Click the "Save" button;
	- Test step 6. Assert that the user is on home page;

	Expected Result: Newly added goals should be displayed on the page in the table format.

Test case 3. Check if the user can mark/unmark the goals as done:

	- Test step 1. Go to https://dailytodo.org/;
	- Test step 2. Click the "Create your Daily Todo list" 
	- Test step 3. Enter some value into the goals field;
	- Test step 4. Click the "Save" button;
	- Test step 5. Assert that the user is on home page;
	- Test step 6. Click the checkbox in the "Today" column
	- Test step 7. Click to unmark the checkbox;
	- Test step 8. Click once more the checkbox in the "Today" column

	Expected Result: In case of marking goal as done - the system should pass the green color to the checkbox icon. User should be able to mark/unmark the goals an unlimited number of times

Test csase 4. Check if the user can edit an existing goal:

	- Test step 1. Go to https://dailytodo.org/;
	- Test step 2. Add some goal and save it;
	- Test step 3. Click the "Edit button" above the goals table on home page; 
	- Test step 4. Assert user is on edit goals page;
	- Test step 5. Make some changes to the goal and save it;

	Expected Result: After editing and saving an existing goal - it should be displayed on the home page instead of the previous one. 

	
Test csase 5. Check that the system doesn't save the edited goal if the user clicked the "Cancel" button:
	
	- Test step 1. Go to https://dailytodo.org/;
	- Test step 2. Add some goal and save it;
	- Test step 3. Click the "Edit button" above the goals table on home page; 
	- Test step 4. Edit the goal and click the "Cancel" button;

	Expected Result: After editing an existing goal and clicking the "Cancel" button - the user should be loaded to the home page and the existing goal should not be changed

Penetration testing :

Test case 1: Check that the user can not pass some XSS through the UI

	- Test step 1. Go to https://dailytodo.org/;
	- Test step 2. Click the "Create your Daily Todo list" 
	- Test step 3. Enter some XSS value into the goals field and click to Save;
	- Test step 4. Assert user is on the Home page
	
	Expected Result: System should sanitize all values, which are storing in DB, and front-end should display XSS value as a simple text

