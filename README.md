spawning-pool
=============

A framework for genetic algorithms in Scala

This framework enables the search and generation of solutions encoded into some chromosome type `A` over a landscape defined by some ordinal fitness `B` (usually `Int` or `Double`), all in a generic manner, typical of Scala libaries.

For performance, this framework uses *futures* to effect evolution concurrently.

This framework also features helper classes for chromosomes that are homogenous collections of some type (i.e. a string of characters or a tour of cities).

References
----------
* [Essentials of Metaheuristics](http://cs.gmu.edu/~sean/book/metaheuristics/) by Sean Luke
* [Watchmaker Framework](http://watchmaker.uncommons.org/)

Colophon
--------

In the *StarCraft* video game series, one of the foundational structures for the Zerg is the **Spawning Pool**.
