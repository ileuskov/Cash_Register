Hello there! This is another small pet project of mine. Some call it coin changer, some money changer, I have decided to call it Cash Register.

The idea came to me while I was in the shop and waiting in the line. I was watching a shop assistant working with a cash register. I always wondered how exactly do they know how much money to give back in the most optimal way? 
Well it easy to know how much money a shop assistant should give back, but the math problem I saw here is how to do it the most effecient way. Which is by giving the minimum amout of notes and coins back. So for the 30€ change you expect to get one 20€ note and one 10€ note and not 30 coins of 1€, right?

That's why I created this small implementation of this problem. The programm calculates the most optimal (= the least) amount of notes and coins to be given back to customer.

I saw a lot of people solving this problem by using double or long values. But the problem is that computers use a format (binary floating-point) that cannot accurately represent a number like 0.1, 0.2 or 0.3 at all. And since I am handling a monetary calculation here, I have decided to use the Big Decimal class in my program. 

The current programm has 2 features:

1. a user can see which notes and coins he gets back and how many of them
2. all the notes and coins that are used for the change are added up into a single amount of money in the end. This amount is compared with user's at the start. If everything is correct the user gets a congratulation!


Please let me know if I have made any mistakes or my code could be refactored in a more efficient way. Thanks in advance!
