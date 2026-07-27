# Click Empire

Click Empire is a modern Android Clicker / Idle game developed in Java.

Players earn coins, purchase upgrades, unlock achievements, gain experience, and build their own virtual empire through active clicking and passive income.

---

## Features

- Coin clicking mechanic
- Passive income system
- 20 upgradable items
- 15 achievements
- Player level and experience system
- Detailed game statistics
- Offline income
- Automatic game saving
- Sound effects
- Vibration support
- Reset progress feature
- Game completion system

---

## Technologies

- Java 17
- Android SDK
- AndroidX
- Material Design 3
- View Binding
- RecyclerView
- SharedPreferences
- Gson
- Gradle

---

## Requirements

- Android Studio Meerkat or newer
- JDK 17
- Android API 26+

---

## Architecture

The project follows the **MVC (Model–View–Controller)** architecture.

### Model

Contains the game's data and business logic.

Classes:

- Player
- Upgrade
- Achievement
- Statistics
- Settings

### View

Responsible for the user interface.

Activities:

- MainActivity
- ShopActivity
- AchievementActivity
- StatisticsActivity
- SettingsActivity

### Controller

Handles the game logic and communication between models and views.

Controllers:

- MainController
- ShopController
- AchievementController
- StatisticsController
- GameCompletionController

---

## Project Structure

```
ClickEmpire/
│
├── app/
├── demo/
├── docs/
├── screenshots/
├── README.md
├── LICENSE
└── build.gradle
```

---

## Screenshots

Screenshots are available in the `screenshots/` directory.

```
screenshots/
├── main_screen.png
├── shop.png
├── achievements.png
├── statistics.png
├── settings.png
└── game_completed.png
```

---

## Demo

A gameplay demonstration is available in the `demo/` directory.

🎮 Gameplay video:

```
demo/click_empire_demo.mp4
```

---

## Testing

The project includes unit tests covering:

- Economy calculations
- Upgrade purchasing
- Achievement unlocking
- Offline income calculations
- Player statistics
- Save system

---

## Build

Clone the repository:

```bash
git clone https://github.com/username/ClickEmpire.git
```

Open the project in **Android Studio** and build it using Gradle:

```bash
./gradlew assembleDebug
```

Or simply open the project and click **Run**.

---

## Roadmap

### Version 1.0

- Initial release
- Complete clicker gameplay
- Shop system
- Achievements
- Statistics
- Offline income
- Automatic saving

### Version 1.1

- Additional upgrades
- UI improvements
- Performance optimizations
- Bug fixes

### Version 2.0

- Prestige system
- Daily rewards
- New achievements
- Additional gameplay content

---

## License

This project is licensed under the **MIT License**.
