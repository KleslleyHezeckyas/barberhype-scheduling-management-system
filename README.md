# BarberHype — Barbershop Scheduling & Management System

BarberHype is a full-stack scheduling and management system built for barbershops, designed to simulate a real business workflow rather than a simple CRUD project. It provides a dual-view experience: a clean scheduling interface for clients and an administrative panel for barbershop owners with financial control, service status tracking, and persistent storage.

---

## Project Objectives

This project was developed to demonstrate:

- real-world domain modeling
- separation of concerns between frontend and backend
- REST API architecture using Spring Boot
- SQL database persistence with PostgreSQL
- business logic applied to financial control
- a modern, responsive UI with UX-focused interactions

It is structured to reflect production-ready engineering decisions instead of a purely academic example.

---

## System Architecture

The project is divided into two independent but integrated layers.

### Backend — Java + Spring Boot (Port 8081)

Responsibilities include:

- business rules and service pricing
- appointment registration and validation
- financial aggregation (total revenue)
- persistence in SQL database
- data integrity across sessions

### Frontend — HTML5 + CSS3 + JavaScript

Responsibilities include:

- interactive and lightweight interface
- dynamic rendering without full page reloads
- responsive layout for desktop and mobile
- modern visual identity

Architecture flow:

```
Frontend (HTML + CSS + JavaScript)
        ↓
REST API (Spring Boot)
        ↓
PostgreSQL Database
```

---

## Features

### Client View (Public Mode)

- simple and objective appointment form
- service selection (Haircut, Beard, Combo, etc.)
- real-time appointment listing
- restricted permissions (no deletion or editing of other appointments)

### Owner View (Admin Mode)

Unlocked through a protected admin access action.

Available features:

- daily revenue calculation
- edit appointment
- delete appointment
- mark service as Done (Completed)
- real-time search filter
- structured panel layout for management workflow

This mode simulates real operational control used in a barbershop environment.

---

## UI / UX and Visual Identity

The interface was designed with a modern masculine visual identity:

- dark background (#0a0a0a)
- electric purple and white highlights
- rounded premium-style buttons
- shimmer glass hover effect
- clean visual hierarchy and spacing
- responsive layout for multiple devices

The interface adapts automatically to desktop, tablet, and mobile resolutions.

---

## Data Persistence

The system uses a PostgreSQL database to persist:

- client name
- selected service
- price value
- appointment status (scheduled / done)
- appointment metadata and history

Persistence ensures:

- data remains stored after browser closure
- no dependency on browser storage
- consistent financial information

---

## Tech Stack

Backend  
- Java  
- Spring Boot  
- REST API  
- PostgreSQL  
- Hibernate / JPA  

Frontend  
- HTML5  
- CSS3  
- JavaScript (vanilla)

---

## Running the Project

### Requirements

- Java 17 or higher
- Maven
- PostgreSQL

### Backend Setup

Run:

```
mvn spring-boot:run
```

Backend available at:

```
http://localhost:8081
```

### Frontend Setup

Open the main HTML file in the browser  
or serve it using any static server.

No build tools are required.

---

## Environment Configuration

The application uses environment variables for sensitive credentials:

```
DB_USERNAME
DB_PASSWORD
```

Values are mapped through `application.properties` to avoid hard-coded secrets.

---

## Roadmap (Future Enhancements)

Planned or potential improvements include:

- financial reports by day, week, and month
- color-based service status indicators
- Swagger documentation for the API
- improved UI validation and feedback handling
- appointment history dashboard
- enhanced scheduling conflict detection

---

## Project Relevance

This project demonstrates:

- integration between backend and frontend layers
- real-world business scenario modeling
- persistence and financial computation logic
- production-oriented project structure
- UX-focused interface planning
- operational management workflow

It was developed as a practical and portfolio-oriented system instead of a basic sample application.

---

## License

This project is available for learning, study, and portfolio demonstration purposes.

