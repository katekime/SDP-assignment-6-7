Project Readme Report: Hero Battle System Architecture
This report outlines the design and architectural patterns used in the Java implementation of a simple Hero Battle System. The project is designed for maintainability and flexibility using object-oriented principles and established behavioral design patterns.

1. Core System Structure
The application simulates combat rounds between two different types of Heroes. The system is divided into several clear packages based on functionality:

Heroes: Contains the abstract Hero class, which manages core statistics (Health, Level, Damage) and includes methods for managing experience (earnExp, levelUp) and receiving damage (attacked).

Strategy (attack): Holds the different attack behaviors (e.g., PhysicalAttack, MagicAttack).

ObserverImplementations: Contains all monitoring and output classes (BattleLogger, GameAnnouncer, HealthMonitoring).

2. Behavioral Design Patterns
The code heavily relies on two behavioral patterns to achieve loose coupling and dynamic behavior:

A. Strategy Pattern (Attack Logic)
The Strategy pattern is used to define a family of interchangeable attack algorithms.

How it Works: The Hero class maintains a reference to a Strategy object (attackStrategy). When a hero attacks, it delegates the actual combat logic to the current strategy object.

Benefit: This allows different hero types (like an Archer and a Warrior) to share the same behavior interface while implementing unique attack logic in their specific strategy classes. Crucially, the system can dynamically swap a hero's entire attack style using the changeStrategy() method at runtime (e.g., if a hero uses a temporary buff or potion).

B. Observer Pattern (Event and Logging System)
The Observer pattern is essential for separating the core game logic from reporting and monitoring functionality.

How it Works: The Hero acts as the Subject (or observable). Other objects like the GameAnnouncer and BattleLogger act as Observers, registering themselves with the Hero via the addObserver() method.

Notifications: When a significant event occurs within the Hero (such as levelUp(), receiving damage via attacked(), or gaining experience), the Hero calls notifyObservers(). This method sends a message, formatted using a clear protocol (e.g., LEVELUP|name|level|...), to all subscribed observers.

Benefit: The Hero remains completely unaware of how its events are being displayed or logged. The logging classes can be modified, replaced, or expanded without ever needing to touch the central Hero class logic.

3. Game Mechanics and Communication
All communication between the Hero and the Observer components relies on a standardized message protocol (e.g., EXP|..., DEFEAT|...). Observers use string parsing (split("|") and trim()) to filter and process the specific event data they are responsible for.

The automatic system for gaining experience (earnExp) and leveling up (levelUp) is encapsulated within the Hero class, providing seamless character progression based on actions taken in battle.
