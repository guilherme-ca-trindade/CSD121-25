# Reflections

### Reflection 2.5: Why can you change the type of the returned value in promptForPlayer without changing the return type in the function signature?
It is possible to change value of promptForPlayer due to the concepts of Generalization, Polymorphism and Inheritance, as seen in class and lecture.The promptForPlayer have this structure:
> public static Player promptForPlayer(PlayerToken whichPlayer) { ... }

Inheritance consists on this hierarchy between classes,with a Superclass, Player. All the other class that extends from this are their subclasses, like HumanPlayer, RandyPlayer, and OmolaPlayer.That's why the superclass Player must contain the abstract keyword in their code, and the subclass must contains in the class definition as for this lab:
> public abstract class Player // Player Superclass
> 
> public class OmolaPlayer extends Player //OmolaPLayer Subclass

Or, for more general concept:
> public abstract class PokemonType 
> 
> public class EletricType extends PokemonType

Therefore, the OmolaPlayer is a subclass of Player and the EletricType is a subclass of PokemonType, and they inherit all the variables and behaviour defined in the superclass.

So, it is possible change the value of promptForPlayer, because it returns a object that is a Player, and any class that extends from it, it still be valid.

---
### Reflection 2.9: Explain why the error occurred initially and why adding the abstract method signature fixes the error. (HINT: What is the type of the ‘whoseTurn’ variable in TicTacToeGame.doNextTurn?)
This error happens because the variable that whoseTurn belongs to. If we hover hte mouse over this, it is possible to see that is a Player variable.
So, to call this method the class Player must be abstract and the pickNextMove method must be abstract also. 

Adding the abstract keyword guarantee that all subclasses must implement this method too and the compiler will understand that Player and their subclasses has this method.

---
### Reflection 5: Explain in detail (using the terminology we have discussed in class) how it is possible that neither our main method nor our TicTacToeGame class need change at all when adding new Player types to our game. Your discussion must include an explanation of how the single call to pickNextMove in TicTacToeGame.doNextTurn works correctly no matter whose turn it is or which types the players are.
It is not necessary to change the Main or the TicTacToeGame even if it's added more players due to the magic concept of Polymorphism, seen in class and implemented in this lab.
The Polymorphism allows us to add new players that are subclasses of this class, therefore, they are treated as supertype instances.

The Polymorphism allows this abstract classes to generalize the interface of the superclass, and requiring no implementation, since it'll be provided by their subclasses. This is a important feature/concept for the OOP (Object-Oriented Programming). That helps the life of the programmer, because if not you would need to change TicTacToeGame and Main, focusing only in the need subclasses you are creating, since the object is still the same, Player!

This also follows the Open/Closed Principles seen in class, that says:
>Software component should be...
> >Open for extension
> 
> >Close for modification

That way we can *Extend* the game by adding new Player, but not *Modifying* the core logic.
