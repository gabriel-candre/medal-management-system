# Medal Management System
This is a Java-based Medal Management System that allows users to manage and view the medal standings of various countries. The system supports functionalities such as adding or removing countries, updating medals, resetting medals, and displaying rankings.

## Table of Contents
- Features
- Requirements
- Setup
- Usage
- Code Structure
- License
- 
## Features
- Manage Countries: Add or remove countries from the system.
- Manage Medals: Add or update gold, silver, and bronze medals for each country.
- Reset Medals: Reset medals for all countries or specific countries.
- Display Ranking: Show the ranking of countries based on their medal counts.
- List All Countries: List all countries with their medal counts.

## Requirements
- Java Development Kit (JDK) 8 or higher
- A text editor or Integrated Development Environment (IDE) for editing Java code (e.g., IntelliJ IDEA, Eclipse)

## Setup
1. Clone the Repository
   - git clone [https://github.com/your-repository/medal-management-system.git](https://github.com/gabriel-candre/medal-management-system.git)

2. Navigate to the Project repository
   - cd medal-management-system

3. Compile the Project
    - Ensure you are in the project root directory, then compile the Java files:
   javac -d bin src/application/Program.java src/controller/*.java src/entities/*.java src/utils/*.java

4. Run the Application
    - java -cp bin application.Program

## Usage
1. #### Starting the Application

Run the Program class. This will present the main menu where you can choose between managing countries, showing rankings, or listing all countries.

2. #### Manage Countries

- Add Country: Provide the country ID and name.
- Remove Country: Provide the ID of the country you wish to remove.
- Manage Medals: Add or update medals for a specific country.

3. #### Manage Medals

- Add Gold/Silver/Bronze Medals: Enter the country ID and the number of medals.
- Reset Medals: Reset all medals or specific medals for a country.

4. #### Display Rankings

- View the ranking of countries based on their total medal counts.

5. #### List All Countries

- Display a list of all countries along with their medal counts.

## Code Structure
- application/Program.java: Entry point of the application.
- controller/CountryController.java: Handles country and medal management operations.
- controller/Menu.java: Manages the user interface and interactions.
- entities/Country.java: Represents a country with its medal data.
- utils/Ranking.java: Handles the ranking logic and display.

## License
- This project is licensed under the MIT License. See the LICENSE file for details.

## Disclaimer
- This project is object to change at any time.

Feel free to customize the repository URL, license, and any additional instructions as needed. If you have further questions or need assistance, please refer to the project's documentation or contact the project maintainers.
