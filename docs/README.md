# T01G05: Arkanoid
Arkanoid is an arcade game from the 1980s, in which the player controls a Space Vessel called the Vaus, that sends a ball upwards in order to collide with the bricks above and destroy them.
This project consists in the development of a game similar to the original Arkanoid in Java and was developed by **Catarina Sousa** (up202306419), **João Marques** (up202307389) and **Pedro Coelho** (up202306714) for LDTS 2024/25.
## Table of Contents
1. [Introduction](#introduction)
2. [List of Features](#list-of-features)
3. [Controls](#controls)<br>
   -[Desired Game Controls](#desired-game-controls)<br>
   -[Implemented Main Menu Controls](#implemented-main-menu-controls)<br>
4. [Screenshots](#screenshots)

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

##Notes about features
Until this submission we focused on the viewer part in order to develop the mockups for the game. We tried to understand how strong could Lanterna GUI be and come in a conclusion that it has a lot of potencial since it can read PNGs pixel by pixel which allows to draw more fun and good-looking elements on the Screen. This way our code is way far from the pattern we want to implement (Controller-Model-View) since its all implemented in the same classe. As example we can take the MainMenu.java class which contains the "processkey()" method that checks for user input to change menu options which should be in a MainMenuController class and the "draw()" method that places all the Main Menu visual elements which should be implemented in a MainMenuViewer class.


## Screenshots
![](https://i.imgur.com/ekAYUPW.png)
Main menu
![](https://i.imgur.com/GVFOo90.png)
Playfield screen
