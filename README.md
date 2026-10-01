# 🕵️ MurderMystery

**MurderMystery** is a 2D interactive mystery game developed using **Java and JavaFX**. Players explore different rooms of a house, investigate suspects, collect clues, and use the available evidence to solve the mystery.

The project was developed collaboratively by **Khansa Aimen** and **Areej Maryam** as a Java Object-Oriented Programming project.

---

## 🎮 About the Game

MurderMystery places the player in an investigation where a murder has taken place inside a house.

The player explores different locations, examines information related to the case, and investigates multiple suspects. Each room contributes to the investigation and helps the player move closer to identifying the murderer.

The game combines exploration, storytelling, suspect investigation, visual scenes, and background music to create an interactive mystery experience.

---

## 🎯 Game Objective

The main objective is to:

- Explore the available rooms
- Investigate the circumstances surrounding the murder
- Examine clues and evidence
- Learn about the suspects
- Connect information discovered during the investigation
- Identify the murderer

---

## ✨ Features

- 🕵️ Interactive murder mystery investigation
- 🏠 Multiple explorable rooms
- 👥 Multiple suspects
- 📖 Story and backstory presentation
- 🔎 Clue-based investigation
- 🎭 Suspect selection system
- 🖼️ Custom room and character visuals
- 🎵 Background music
- 🔄 Navigation between different game scenes
- 🎨 JavaFX-based graphical user interface
- 🧩 Modular object-oriented Java structure

---

## 🏠 Locations

Players can explore several areas of the house during the investigation, including:

- 🛏️ Bedroom
- 🛁 Bathroom
- 🍳 Kitchen
- 🛋️ Living Room
- 📚 Study Room

Each location forms part of the investigation and provides a different environment for the player to explore.

---

## 👥 Suspects

The investigation involves multiple suspects, including:

- Husband
- Best Friend
- Influencer
- Maid

The player must consider the information available about the suspects before reaching a conclusion.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java** | Core game logic and object-oriented programming |
| **JavaFX** | Graphical user interface and scene management |
| **Maven** | Project configuration and dependency management |
| **FXML** | JavaFX interface definition |
| **CSS / JavaFX Styling** | User-interface presentation |
| **IntelliJ IDEA** | Development environment |
| **Git** | Version control |
| **GitHub** | Collaboration and source-code hosting |

---

## 📁 Project Structure

```text
MurderMystery/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── com/example/hellofx/
│       │       ├── BackstoryScreen.java
│       │       ├── Bathroom.java
│       │       ├── Bedroom.java
│       │       ├── FrontScreen.java
│       │       ├── HelloApplication.java
│       │       ├── HelloController.java
│       │       ├── Kitchen.java
│       │       ├── Launcher.java
│       │       ├── LivingRoom.java
│       │       ├── Main.java
│       │       ├── MusicManager.java
│       │       ├── RoomSelectionScreen.java
│       │       ├── StudyRoom.java
│       │       └── SuspectScreen.java
│       │
│       └── resources/
│           ├── sounds/
│           │   └── music.mp3
│           ├── bathroom.png
│           ├── bedroom.png
│           ├── bestfriend.png
│           ├── frontscreen.jpeg
│           ├── husband.png
│           ├── influencer.png
│           ├── kitchen.jpeg
│           ├── living room.jpeg
│           ├── maid.png
│           └── studyroom.jpeg
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🧩 Main Components

### `Main.java`
Acts as one of the main entry points for launching the application.

### `FrontScreen.java`
Displays the initial game screen and provides access to the game experience.

### `BackstoryScreen.java`
Introduces the player to the story and establishes the context of the murder investigation.

### `RoomSelectionScreen.java`
Allows the player to navigate between the different locations available for investigation.

### Room Classes
The following classes represent the major explorable locations:

- `Bedroom.java`
- `Bathroom.java`
- `Kitchen.java`
- `LivingRoom.java`
- `StudyRoom.java`

### `SuspectScreen.java`
Handles the suspect-related portion of the investigation.

### `MusicManager.java`
Manages background music used by the application.

---

## ▶️ How to Run

### Prerequisites

Make sure you have:

- Java Development Kit (JDK)
- IntelliJ IDEA or another Java IDE
- Maven support
- JavaFX dependencies configured through the project

### Running with IntelliJ IDEA

1. Clone the repository.
2. Open the project in **IntelliJ IDEA**.
3. Allow Maven to load the dependencies from `pom.xml`.
4. Make sure the required JDK is configured.
5. Locate the main application class.
6. Run the application.
7. The MurderMystery game window should open.

---

## 🎮 Gameplay Flow

```text
Start Game
    ↓
Front Screen
    ↓
Story / Backstory
    ↓
Room Selection
    ↓
Explore Locations
    ↓
Investigate Evidence
    ↓
Review Suspects
    ↓
Identify the Murderer
```

---

## 🧠 Object-Oriented Programming Concepts

The project applies important OOP and software-development concepts, including:

- **Classes and Objects** — separate classes represent screens, rooms, and game functionality.
- **Encapsulation** — game functionality is organized into dedicated components.
- **Modularity** — individual screens and features are separated into different Java classes.
- **Separation of Concerns** — music, navigation, rooms, and investigation functionality are handled independently.
- **Code Reusability** — shared functionality can be reused across different parts of the application.

---

## 🤝 Collaboration

MurderMystery was developed collaboratively using **Git and GitHub**.

The project maintains a structured commit history showing contributions from both developers. Development work was divided across game screens, room implementations, application components, visual assets, configuration, and documentation.

### Developers

**Khansa Aimen**  
BS Computer Science  
COMSATS University

**Areej Maryam**  
BS Computer Science  
COMSATS University

---

## 🚀 Possible Future Improvements

Potential improvements for future versions include:

- More rooms and investigation locations
- Additional suspects
- More complex clue combinations
- Evidence inventory system
- Improved animations and transitions
- Sound effects for interactions
- Multiple possible endings
- Difficulty levels
- Save and resume functionality
- Enhanced user interface
- Expanded storyline and character interactions

---

## 📌 Project Purpose

This project demonstrates practical application of:

**Java programming • Object-Oriented Programming • JavaFX • GUI development • Maven • Git • GitHub collaboration**

It was developed as an academic project while also providing hands-on experience in designing and implementing an interactive desktop application.

---

## 👩‍💻 Authors

**Khansa Aimen & Areej Maryam**

Developed collaboratively as part of our Computer Science coursework.

---

⭐ If you find this project interesting, feel free to explore the repository and its implementation.