# Auto Drive Dash

ADD (Auto Drive Dash) is an endless side-scrolling game that focuses on players controlling a vehicle of their choosing through dynamically generated highways filled with obstacles, coins, and power-ups. The goal is to survive as long as possible while collecting rewards and avoiding collisions. The game is designed for casual players who enjoy fast-paced reflex-based games, providing an engaging experience that combines speed, precision, and strategy.

## Major Features

- **User Authentication** - Players can register, log in, and save their progress and high scores securely.
- **Player Control** - Players can move around and accelerate to avoid obstacles and collect powerups using keyboard controls.
- **Score & Progress Tracking** - Keeps track of the player’s score, unlocked vehicles, and highest scores during gameplay.
- **Dynamic Game System** - Generates random obstacles and power-ups with more challenging gameplay as players reach higher scores.
- **Automatic Data Saving** - Automatically stores player progress and high scores in a database after each session, allowing players to continue from where they left off without manual saving.

## Technologies Used

#### Frameworks/Libraries

- `JavaFX/FXGL`
- `MySQL Connector/J`

#### Architecture

- `ECS` (Entity-Component-System)
- `MVC` (Model-View-Controller)

#### Tools

- `VS Code` - IDE
- `Git/Github` - Version Control
- `SceneBuilder` - UI Builder
- `Piskel` - Pixel Art
- `Canva` - Design/Layouts
- `MySQL` - Database
- `Lucidchart` - Database schemas and relations

#### Project Structure

```
app/                                  # Main App folder
├── build.gradle.kts                  # Build file with dependencies
└── src/main/
    ├── resources/                    # Assets folder containing images, styles, ui, etc.
    └── java/                         # Java folder containing source code
        └── autodrivedash/            # Main package folder
            └── App.java              # Entry File with main method and static methods
```
