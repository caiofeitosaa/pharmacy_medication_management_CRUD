# Pharmacy Medication Management

A desktop application for managing pharmacy medications, with product registration, editing, and stock control. Built with Java and JavaFX, following the MVC architecture, with MySQL persistence through JDBC.

## Features

- Register medications
- Edit existing medications
- Stock control for products
- List all registered medications
- Delete medications <!-- [confirm] keep only what the project actually does -->

## Technologies

| Technology | Purpose |
|---|---|
| Java 17 | Main language |
| JavaFX + Scene Builder | Graphical user interface |
| JDBC | Database connection |
| MySQL | Data storage |
| Git and GitHub | Version control |

## Getting Started

### Prerequisites

- JDK installed
- MySQL installed and running
- YOUR preferred IDE
- JavaFX SDK configured in the project

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/caiofeitosaa/pharmacy_medication_management_CRUD.git
   ```
2. Create the database in MySQL:
   ```sql
   CREATE DATABASE crud_pharmacy;
   ```
3. Run the table creation script:
   ```sql
   USE crud_pharmacy;

   CREATE TABLE IF NOT EXISTS medication (
    id         INT            NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100)   NOT NULL,
    quantity   INT            NOT NULL DEFAULT 0,
    batch      VARCHAR(50),
    unityPrice DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id));
   ```
4. Configure the database connection (user, password, and URL) in:
   ```java
    private final String databaseLink = "jdbc:mysql://localhost:3306/crud_pharmacy"; 
    private final String username = System.getenv("DB_USERNAME"); // use getenv if you are using a local variant on your windows
    private final String password = System.getenv("DB_PASSWORD"); // use getenv if you are using a local variant on your windows
   ```
5. Open the project in your IDE and run the main class.

## How to Use

### Registering a medication
- Fill in all the fields in the form: name, quantity, batch, and unit price.
- Click Add medication.
- The medication is saved to the database and automatically receives an id.
- If you add a medication with an existing name and batch number, its quantity is updated.

### Searching a medication
- For updating and deleting a medication the ID for that medication is needed.
- Use the search function, searching by name or batch.
- Click it on the medication on the table.

### Updating a medication
- After clicking on a medication, alter the component you want it.
- Remember, the ID is required.
  
### Deleting a medication
- Deletion is done by the medication's id. To find the id:
- Use the Search field, typing the medication's name or batch.
- Find the medication in the results and note its id.
- Enter the id and confirm the deletion.

## What I Learned

- Applying the MVC pattern to separate the interface, logic, and data access
- Connecting a Java application to a MySQL database using JDBC
- Building user interfaces with JavaFX and Scene Builder
- Implementing complete CRUD operations

## Author

**Caio Roberto Caldas Feitosa**
Systems Analysis and Development student – UNIFOR

[LinkedIn](https://www.linkedin.com/in/caiofeitosaa/) | [GitHub](https://github.com/caiofeitosaa)
