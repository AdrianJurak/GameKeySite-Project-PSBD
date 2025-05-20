# MVC Game Store [G2A]

## Project Overview

MVC Game Store is a web application based on the Model-View-Controller (MVC) architecture. It allows users to browse
available games, sort and filter them, view detailed information, add games to the cart, and manage subscriptions.

## Features

- **Game List** – The homepage displays a table with all available games, with sorting and filtering options.
- **Game Details** – Clicking a game title opens a page with full details.
- **Shopping Cart** – Users can add games to the cart and complete purchases.
- **Language Switch** – The app supports multiple languages.
- **User Panel** – Shows account details, active subscriptions, and the current cart.
- **Registration & Login** – Users authenticate with a login token valid for 5 minutes.
- **Subscriptions** – Automatic email notifications for active subscriptions.
- **Game Key Delivery** – Purchased game keys are sent via email.

## Technologies

- **Backend**: Spring Boot (Java), ORM (Hibernate)
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Email Service**: JavaMailSender

## Installation & Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/AdrianJurak/GameKeySite-Project-PSBD.git
   cd GameKeySite-Project-PSBD
   ```
2. Configure the database in `application.yml`.
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will be available at `http://localhost:8080`.

## Authors

- Project Creators: Adrian Jurak, Amadeusz Żyła, Sebastian Wróblewski

## License

This project is available under the MIT license.

### MIT License Explained

The MIT License is a permissive open-source license that allows anyone to use, modify, and distribute the software.
It requires that the original license notice is included in all copies or substantial portions of the software.
The license provides flexibility for both personal and commercial use but comes with no warranty or liability
protection.
