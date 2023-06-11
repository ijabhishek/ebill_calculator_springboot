# Project README

This project contains a controller class named `EbillController` which handles the calculations for an electricity bill. The controller is implemented using the Spring Framework and is responsible for processing the bill calculation form and generating the result.

## Controller Mapping

The controller class is mapped to the root URL ("/") and has two methods mapped to different endpoints:

1. `showForm()`: This method handles the GET request to the root URL ("/"). It returns the view name "bill-form" which corresponds to the bill calculation form.

2. `calculateBill()`: This method handles the POST request to the "/calculate" endpoint. It receives various request parameters from the bill calculation form, performs the necessary calculations, and passes the results to the "result" view.

## Request Parameters

The `calculateBill()` method receives the following request parameters from the bill calculation form:

- `room1_new_bill_reading`: The new bill reading for room 1.
- `room1_old_bill_reading`: The old bill reading for room 1.
- `room2_new_bill_reading`: The new bill reading for room 2.
- `room2_old_bill_reading`: The old bill reading for room 2.
- `room3_new_bill_reading`: The new bill reading for room 3.
- `room3_old_bill_reading`: The old bill reading for room 3.
- `motar_new_bill_reading`: The new bill reading for the motor.
- `motar_old_bill_reading`: The old bill reading for the motor.
- `total_bill_amount`: The total bill amount.
- `water_bill_amount`: The water bill amount.
- `other_expenses`: The amount of other expenses.
- `due_date`: The due date for the bill.

## Calculation Logic

The `calculateBill()` method performs the following calculations:

1. Calculate the units consumed by each person based on the old and new bill readings.
2. Calculate the total units consumed.
3. Calculate the average bill amount per unit consumed.
4. Calculate the bill amount for the motor based on its units consumed and the total bill amount.
5. Calculate the bill amount per person for the motor, water bill, and other expenses, rounding to three decimal places.
6. Calculate the bill amount for each room by adding the individual room's unit consumption portion of the total bill amount with the motor, water bill, and other expenses.
7. Pass the necessary data to the "result" view using the `Model` object.

## Views

The controller returns two views:

1. "bill-form": This view corresponds to the bill calculation form and is displayed when accessing the root URL ("/"). It allows users to enter the required information for the bill calculation.

2. "result": This view displays the calculated bill amounts and other details. It receives the necessary data from the `calculateBill()` method via the `Model` object and presents it to the user.