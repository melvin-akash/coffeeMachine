# coffeeMachine

# Coffee Machine Project

## Overview
The Coffee Machine is a Java-based console application that simulates the functionality of a real coffee vending machine. Users can buy different types of coffee, refill ingredients, clean the machine, and check its remaining resources.

## Features
- **Buy Coffee**: Users can choose between Espresso, Latte, and Cappuccino.
- **Refill Ingredients**: Add water, milk, coffee beans, and disposable cups.
- **Check Remaining Resources**: View the current status of the machine.
- **Clean Machine**: Clean the machine after usage.
- **Take Money**: Withdraw the collected money from the machine.

## How to Run
1. Clone the repository or download the source code.
2. Compile and run the Java program using:
   ```sh
   javac CoffeeMachine.java
   java CoffeeMachine
   ```
3. Follow the on-screen prompts to interact with the coffee machine.

## Usage
Upon running the program, the user is prompted to enter an action:
```
Write action (buy, fill, clean, take, remaining, exit):
```
### Buying Coffee
```
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
```
- If enough resources are available, the coffee will be prepared.
- If resources are insufficient, a warning message is displayed.

### Refilling Ingredients
```
Write how many ml of water you want to add:
Write how many ml of milk you want to add:
Write how many grams of coffee beans you want to add:
Write how many disposable cups you want to add:
```

### Checking Remaining Resources
```
The coffee machine has:
1150 ml of water
640 ml of milk
154 g of coffee beans
8 disposable cups
$554 of money
```

### Cleaning the Machine
```
I have been cleaned!
```
After multiple uses, the machine may require cleaning before further purchases.

## Error Handling
- The program handles invalid inputs and displays appropriate error messages.
- If cleaning is required, users are prompted to clean the machine before making another purchase.

## Future Enhancements
- Add more coffee options.
- Implement a GUI for better user experience.
- Track user preferences.
