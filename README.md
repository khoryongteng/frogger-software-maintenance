# COMP2042_CW_KhorYongTeng
## Frogger Arcade Game
##### Name : Khor Yong Teng
##### Student Id: 20089417

# Prerequisite

1. 	Java is installed.
2.	Maven is installed.
3.	Java and Maven added to PATH.

# Installation

1.	Import project to IDE.
2.	Open console and go to project directory.
3. 	Run maven command: [mvn clean install package] to install dependencies, launch test, and package project into a jar file with dependencies.
4. 	Run maven command: mvn exec:java to launch game.
5. 	Run maven command: mvn javadoc:javadoc to regenerate javadoc.

# Key Changes
 
### Maintenance
1. 	Refactored project by separating java files from resource files.

2.	Refactored certain classes by renaming them to more readable and understandable names.
	- Example: Animal class renamed to Player.
	
3. 	Broke down constructor and methods of all classes down into smaller methods to increase readability and maintainability. 

4. 	Refactored WetTurtle and Turtle classes by adding Rideable abstract subclass for them to inherit from.
	- Reduces code reuse.
	- Enforces open/closed principle with the usage of abstract classes.
	
5.	Broke down Obstacle class into subclasses. Obstacle class changed to abstract class and inherited.
	- Obstacle instantiates too many objects in levels. 
	- Broke down into Car, LongTruck, and ShortTruck classes.
	- Enforces open/closed principle and simplifies code for maintainability and readability.
	
6.	Moved Level creation functionality in main to new dedicated package of classes (frogger.models.levels).
	- Allows for easy creation and modification of levels.
	- Enforces Single-Responsibility Principle.
	- World abstract class used as a base for level creation.
	- MyStage renamed and reused as Level abstract class which contains common objects across levels.
	- Concrete class levels (Level1 etc.) used to instantiate game levels.
	
7. 	Separated functionality of classes into separate classes.
	- Enforces Single-Responsibility Principle.
	- Example: MediaPlayer functionality in MyStage moved to new MusicPlayer Class

9. 	Interfaces introduced.
	- Use in design patterns.
	- Enforce open/closed principle.
	
8. 	Introduced design patterns to the project.
	- MVC pattern
		- Separated functionality of code into Model, view and controller classes.
		- Enforces Single-Responsibility Principle.
		- Manages and improves maintainability of different functionalities easier by separating them according to responsibility.
		- Model consists of Actor classes and World / Level classes.
		- View consist of FXML files used for user interface.
		- Controllers consists of new controller classes in frogger.controllers.
	
	- Singleton pattern
		- Used for GameController object construction to overcome multiple instance issue.
		
	- Factory pattern
		- LevelFactory used for construction of level classes to create loose coupling.
		
	-Mediator pattern
		- GameController acts as mediator between other controllers.
		- Reduce the need of controllers to know about other controllers other than the GameController.

10. SOLID Principles enforced throughout code refactoring through usage of abstract classes, interfaces, and polymorphism.

### Extension
1. 	Added user interfaces in the form of FXML files as views.
	- FXML view files are views adhering to the MVC pattern format.
		- Includes StartScene, InfoScene, EndScene, HighScoreScene.

2.  Added new Actors
	- Spike Obstacle Class
	- Crocodile Rideable Class

3. 	Added additional levels to the game.
	
4. 	Added HighScore display functionality through reading writing from a saved file containing High Scores.
 
5. 	Added JUnit Tests.

6. 	Added Maven to:
	- Manage dependencies.
	- Create .jar build files.
	- Generate Javadoc.
	- Execute game.
	
# Notes
1.	Jar build file with dependency stored in [/build](/build).
2.	Javadoc generated in [/javadoc](/javadoc).
3. 	Class Diagram stored in [/classdiagram](/classdiagram).
