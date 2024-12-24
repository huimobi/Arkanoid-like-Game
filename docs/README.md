# T01G05: Arkanoid
Arkanoid is an arcade game from the 1980s, in which the player controls a Space Vessel called the Vaus, that sends a ball upwards in order to collide with the bricks above and destroy them.
This project consists in the development of a game similar to the original Arkanoid in Java and was developed by **Ana Sousa** (up202306419), **João Marques** (up202307389) and **Pedro Coelho** (up202306714) for LDTS 2024/25.
## Table of Contents
1. [Introduction](#introduction)
2. [List of Features](#list-of-features)
3. [Controls](#controls)<br>
   -[Desired Game Controls](#desired-game-controls)<br>
   -[Implemented Main Menu Controls](#implemented-main-menu-controls)<br>
   -[Notes about Design](#notes-about-design)<br>
4. [Design Patterns](#design-patterns)<br>
   - [Model-View-Controller](#model-view-controller)<br>
   - [Game Loop Pattern](#game-loop-pattern)<br>
   - [State Pattern](#state-pattern)<br>
   - [Data Access Object](#data-access-object)<br>
   - [UML schema](#uml-schema)<br>
   - [Notes about Design](#notes-about-design)<br>
4. [Screenshots](#screenshots)
5. [Credits](#credits)

## Introduction
The Vaus (a paddle in practice) has an horizontal movement and is the only controllable feature available to the player. The Vaus spawns at the centre of the movable line and can be set at any other position for three seconds, before lauching the ball. As it hits a surface (be it the lateral and upper limits or a brick) it deflects in various angles. The aim is to clear the block of bricks while not letting the ball cross the lower limits of the playfield.
The bricks might be disposed in diverse ways, according to the level (we intend to implement 5). There are different brick colors, having each one of them different points associated. Some bricks drop a power-up, affecting either the Vaus (in the size) or the ball (in the speed or the number, for instance).

## List of Features
### Implemented
**Main Menu** - Displays four options (play, settings, info, exit), to be acceded through the up and down arrowkey. The proper implementation of all the options, besides play and exit are yet to be done.

**PNG Image Loader** - We used a class that loads PNG images into the game and can represent them pixel by pixel on the screen, using the Lanterna GUI. This is used for all the elements shown on terminal such as the background, paddle, bricks, walls, textures and the ball.

**Font Loader and Write classes** - Classes that cooperate with the PNG image loader class to create our own font for the game characters and print them on the Lanterna GUI given an initial top corner left position.

### To be implemented
**Paddle movement** - The player can control the horizontal movement through the left and right arrowkey. The movement is constrained by the edge of the playfield.

**Ball mechanics** - The ball is launched from the paddle at the start and has a trajectory that follows from the collisions with bricks, paddle and walls. Its speed is adjustable to the gameplay progression.

**Brick layouts** - The bricks have different colours and points associated. Different levels have different arrangements.

**Scoring system** - Points are achieved by destroying bricks. The score counter is showed on the right margin of the game screen.

**Highscore** - The score achieved by each player is compared to the current highscore, updating it when needed.

**Round count** - Indicates the level being played (to be done up to 5). It appears on the right lower screen.

**Lives system** - The player starts the game with 3 lives, which he loses by letting a ball fall below the paddle. There is a life bar at the top right game screen.

**Map designer** - Class to design the map of each level through written text files with specific characters, allowing to generate bricks and to make the layout edition simpler.

## Controls
### Desired Game Controls
`>`: Moves the paddle to the right.

`<`: Moves the paddle to the left.

`ESC`: Press ESC to quit or return to the main menu.

`ENTER`: Press ENTER to select the desired options in the menu.

### Implemented Main Menu Controls
`^`: Go to previews option.

`v`: Go to next option.

`ENTER`: Press ENTER to select the desired option.

## Design Patterns
### Model-View-Controller
To deal with the paddle movement, that is intended to be smooth and responsive to player's inputs, and with ball physics we want to implement MVC.
With this pattern we'll separate the game logic (model), user interface (view), and player inputs (controller).<br>
**Consequences:**
Clear separation of competences, making the code modular and easier to maintain.<br>
Facilitates testing of each component.


### Game Loop Pattern 
The Game Loop Pattern ensures smooth and consistent gameplay (60 FPS) across devices by controlling the update and rendering cycles. It consists of several key components: Input Handling, which captures player actions like moving the paddle; Game State Updates, which manage the positions of the ball and paddle, check for collisions, and update the score; and Rendering, which draws the game frame on the screen. Additionally, the game loop uses a fixed timestep, ensuring consistent game logic updates (e.g., 60 times per second).<br>
**Consequences:**
Ensures predictable and smooth gameplay regardless of hardware performance.<br>
Decouples game logic updates from rendering, making animations and physics consistent.

### State Pattern
We want to manage different game states (the ones showed in the main menu), which can be difficult and error-prone when handled within a single class. To overcome this, the State Patterns helps manage different game states in a clean and efficient way, by separating each state into its own class.<br>
**Consequences:**
The game logic is cleaner because each state is handled independently in its own class.<br>
The game logic is easier to follow and modify with clearly defined states and transitions.<br>
New states can be added without major changes to the existing game logic.

### Data Access Object
We intend to store and retrieve high scores from a file, and to do so we need to implement the DAO Pattern, which abstracts the process. Providing methods to manage the persistance of high scores, the game logic only needs to call these methods.<br>
**Consequences:**
The game logic is decoupled from the specifics of data storage, allowing it to interact with the high scores through simple method calls.

### UML schema
![](https://i.imgur.com/KbjHPH8.jpeg)

### Notes about Design
Until this submission we focused on the viewer part in order to develop the mockups for the game. <br>
We tried to understand how strong could Lanterna GUI be. We came to the conclusion that it has a lot of potencial, since it can read PNGs pixel by pixel which allows to draw funnier and better-looking elements on the Screen. By now, our code is way far from the main pattern we want to follow (Model-View-Controller) as it's all implemented in the same classe. 
An example of a change we can apply, is taking the "processkey()" and "draw()" methods out of the MainMenu.java class. The new classes MainMenuController and MainMenuViewer would check the user input and interchange between menu options and place all the Main Menu visual elements, respectively.

## Screenshots
![](https://i.imgur.com/6T7bR58.png)
Main menu
![](https://i.imgur.com/2WRMSfp.png)
Playfield screen

## Credits
Some of the ideas implemented in this project, such as the UML design, the PNG Loader class and the Map designer features were based on the following project:<br>
**https://github.com/Process-ing/feup-ldts**<br>
AI Generative Tools, namely _ChatGPT_ and _Pixlr_, were used in this project to generate the background image on the Main Menu.
