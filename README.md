**Utility Bill Calculator**
This project is a utility bill calculator that calculates the individual bill amount for three rooms and a motor based on the provided bill readings and other parameters. It is implemented using Spring MVC framework with Thymeleaf as the template engine.

**Features**
Calculates the units consumed by each room and the motor.
Calculates the total units consumed.
Calculates the average bill amount per unit.
Calculates the motor bill amount based on its units consumed.
Calculates the bill amount for each room, considering the motor bill, water bill, and other expenses.
Displays the calculation results on the result page.

**Prerequisites**
Java Development Kit (JDK) 8 or higher
Maven
Spring Boot

**Getting Started**
Clone the repository:
bash
Copy code
git clone https://github.com/ijabhishek/ebill_calculator_springboot
Navigate to the project directory:
bash
Copy code
cd utility-bill-calculator

**Build the project:**
Copy code
mvn clean install
Run the application:
arduino
Copy code
mvn spring-boot:run

**Open a web browser and access the application at http://localhost:8080.**
**Usage**
Fill in the required fields on the bill calculation form:

Enter the new and old bill readings for each room and the motor.
Provide the total bill amount.
Specify the water bill amount and other expenses.
Select the due date.
Click the "Calculate" button.

The application will display the calculation results on the result page, including the unit differences for each room and the motor, total electricity bill amount, average bill amount per unit, motor bill amount, individual bill amounts for each room, and the payable amount.

**Customization**
You can customize the application according to your needs:

Modify the calculation logic in the calculateBill method of the EbillController class to change the bill calculation algorithm.
Adjust the HTML templates (bill-form.html and result.html) in the resources/templates directory to change the look and feel of the user interface.
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request on the project repository.

**License**
This project is licensed under the MIT License.

**
---------------------------------------------------------------------------------------**
**Details About the  Files and Project**

**Project README**

This project contains a controller class named EbillController which handles the calculations for an electricity bill. The controller is implemented using the Spring Framework and is responsible for processing the bill calculation form and generating the result.

**Controller Mapping**
The controller class is mapped to the root URL ("/") and has two methods mapped to different endpoints:

showForm(): This method handles the GET request to the root URL ("/"). It returns the view name "bill-form" which corresponds to the bill calculation form.

calculateBill(): This method handles the POST request to the "/calculate" endpoint. It receives various request parameters from the bill calculation form, performs the necessary calculations, and passes the results to the "result" view.

Request Parameters
The calculateBill() method receives the following request parameters from the bill calculation form:

room1_new_bill_reading: The new bill reading for room 1.
room1_old_bill_reading: The old bill reading for room 1.
room2_new_bill_reading: The new bill reading for room 2.
room2_old_bill_reading: The old bill reading for room 2.
room3_new_bill_reading: The new bill reading for room 3.
room3_old_bill_reading: The old bill reading for room 3.
motar_new_bill_reading: The new bill reading for the motor.
motar_old_bill_reading: The old bill reading for the motor.
total_bill_amount: The total bill amount.
water_bill_amount: The water bill amount.
other_expenses: The amount of other expenses.
due_date: The due date for the bill.
Calculation Logic
The calculateBill() method performs the following calculations:

Calculate the units consumed by each person based on the old and new bill readings.
Calculate the total units consumed.
Calculate the average bill amount per unit consumed.
Calculate the bill amount for the motor based on its units consumed and the total bill amount.
Calculate the bill amount per person for the motor, water bill, and other expenses, rounding to three decimal places.
Calculate the bill amount for each room by adding the individual room's unit consumption portion of the total bill amount with the motor, water bill, and other expenses.
Pass the necessary data to the "result" view using the Model object.
Views
The controller returns two views:

"bill-form": This view corresponds to the bill calculation form and is displayed when accessing the root URL ("/"). It allows users to enter the required information for the bill calculation.

"result": This view displays the calculated bill amounts and other details. It receives the necessary data from the calculateBill() method via the Model object and presents it to the user.
