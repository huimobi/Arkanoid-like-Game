# T01G05: Arkanoid
Arkanoid is an arcade game from the 1980s, in which the player controls a Space Vessel called the Vaus, that sends a ball upwards in order to collide with the bricks above and destroy them.
This project consists in the development of a game similar to the original Arkanoid in Java and was developed by **Catarina Sousa** (up202306419), **João Marques** (up202307389) and **Pedro Coelho** (up202306714) for LDTS 2024/25.
## Table of Contents
- [Introduction](#introduction)
- [List of Features](#list-of-features)

## Introduction
The Vaus (a paddle in practice) has an horizontal movement and is the only controllable feature available to the player. The Vaus spawns at the centre of the movable line and can be set at any other position for three seconds, before lauching the ball. As it hits a surface (be it the lateral and upper limits or a brick) it deflects in various angles. The aim is to clear the block of bricks while not letting the ball cross the lower limits of the playfield.
The bricks might be disposed in diverse ways, according to the level (we intend to implement 5). There are different brick colors, having each one of them different points associated. Some bricks drop a power-up, affecting either the Vaus (in the size) or the ball (in the speed or the number, for instance).

## List of Features
**Paddle movement** - The player can control the horizontal movement through the left and right arrowkey. The movement is constrained by the edge of the playfield.

**Ball mechanics** - The ball is launched from the paddle at the start and has a trajectory that follows from the collisions with bricks, paddle and walls. Its speed is adjustable to the gameplay progression.

**Brick layouts** - The bricks have different colours and points associated. Different levels have different arrangements.

**Scoring system** - Points are achieved by destroying bricks. The score counter is showed on the right margin of the game screen.

**Lives system** - The player starts the game with 3 lives, which he loses by letting a ball fall below the paddle. There is a life bar at the top right game screen.

### Screenshots
