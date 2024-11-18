# T01G05: Arkanoid
Arkanoid is an arcade game from the 1980s, in which the player controls a Space Vessel called the Vaus, that sends a ball upwards in order to collide with the bricks above and destroy them.
This project consists in the development of a game similar to the original Arkanoid in Java and was developed by **Catarina Sousa** (up202306419), **João Marques** (up202307389) and **Pedro Coelho** (up202306714) for LDTS 2024/25.
## Table of Contents
- [Introduction](#introduction)
- [List of Features](#list of features)

## Introduction
The Vaus (a paddle in practice) has an horizontal movement and is the only controllable feature available to the player. The Vaus spawns at the centre of the movable line and can be set at any other position for three seconds, before lauching the ball. As it hits a surface (be it the lateral and upper limits or a brick) it deflects in various angles. The aim is to clear the block of bricks while not letting the ball cross the lower limits of the playfield.
The bricks might be disposed in diverse ways, according to the level (we intend to implement 5). There are different brick colors, having each one of them different points associated. Some bricks drop a power-up, affecting either the Vaus (in the size) or the ball (in the speed or the number, for instance).
