[![Build Status](https://travis-ci.org/mcanlas/spawning-pool.svg?branch=master)](https://travis-ci.org/mcanlas/spawning-pool)

spawning-pool
=============

A framework for **genetic algorithms** in Scala.

This framework enables the search and generation of solutions encoded as a chromosome over a fitness landscape, all in a generic manner typical of Scala libraries.

Because genetic algorithms are computationally intensive, this framework uses *futures* to perform evolution concurrently.

This framework also features helper classes for chromosomes that are homogenous collections of some type (e.g. a string of characters or a tour of cities).

References
----------
* [Essentials of Metaheuristics](http://cs.gmu.edu/~sean/book/metaheuristics/) by Sean Luke
* [Watchmaker Framework](http://watchmaker.uncommons.org/)

Colophon
--------

The *StarCraft* video game series features the Zerg, an alien species adept at rapid evolution and genetic manipulation. One of the foundational structures for the Zerg is the **Spawning Pool**.
