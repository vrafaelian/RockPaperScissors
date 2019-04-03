# RockPaperScissors

Game was made as a final semester 1 project for the Advanced Topics Computer Science course at Immaculate Heart High School.

## Rules
Allow transitions to finish before interacting with program. 
Click directly on text and images to progress.
Game will purposefully quit if player chooses same item as computer.

## Design Document
**3-5 sentences summarising game concept, gameplay and win/loss conditions.**
The game concept is a simple rendition of the classic rock, paper, scissors game, but instead as a computer program. The three objects will be displayed as floating images, and the scores will be kept on the left and right side, color coded as red and green based on whether the computer or the user is winning. The user will be asked to click on a “Click for Next Round” button in order to enter any round above the first one, as any round that ends in a tie will result in the program shutting itself down. Once either the computer or the user reach three points, the game ends, and a win/loss message is displayed. (I am not sure whether I will actually be able to finish this last part). 

**What data structures/variables will be used? Why?**
All of my underlying information is stored in either boolean or integer variables, while javafx specific objects such as imageviews and text are used for display. 

**What algorithm(s) will be used (what is your code doing)?**
At first, I will use a helper method to create all of the text that is meant to appear on screen, and will include all images in the starter method. I will use some animations, such as FadeTransition and TranslateTransition to make the text and images on screen more interesting to look at. Secondly, I will have created a helper method that generates a computer choice between the three objects by using Math.Random. After calling this helper method, I will make three separate eventHandlers for the three objects to make sure that the user can click on one of them, and therefore voice his/her choice to the computer. In each of these eventHandlers, I will later compare the choice of the computer and the user using an if statement. Right below this code, I will use another if statement to portray the scores on the sides of the screen, green being a point in the user’s favor, and red being a point in the computer’s program. I will be using a button that the user clicks on in order to reset choices and begin the next rounds instead of using a loop. At last, I will create a final helper method that, once either win or lose = 3, meaning either the computer has reached three points or the user has reached three points, displays a win or lose message. I will call this method in the eventHandlers where either win or lose = 3 is being checked. As a little bonus, I will create a third option that prepares for a tie, and once a tie has occurred, the game will shut itself down. 

**Discuss at least three things covered in classes/projects/quizzes/etc that you see yourself using in this project.**
I will be attempting to properly make use of if statements through most of the program. They will be required for the choosing between the three items, rock, paper and scissors. The if statement will also be useful when comparing the choice of the user, and the choice of the computer. I will also attempt to make use of the while loop when trying to get the game to play through more than one round. The loop will continue until either lose or win equal three, and once those requirements are reached, the program will move on to code below where the inevitable end of the program awaits. (This was my original idea, but due to creating infinite loops and an error that resulted in even the javafx stage not showing, I decided against the loop. Instead, I used an eventHandler, which is the third thing that I planned on using, and ended up implementing). Thirdly, I plan on using eventHandlers that allow the player to click on the three objects, and therefore communicate their choice to the program. I will also make use of helper methods inside of the program, most likely creating two that focuses on the computer choice and the user choice. (I ended up creating only a helper method for the computer, as the helper method meant to encompass the user’s choice did not run). Finally, I will be using Math.Random when creating a method that allows the computer to choose a number from 0 to 1, and based on that number, choose between rock, paper, and scissors. I will make use of Platform.exit(), and quit the game whenever the choices between the user and the computer result in a tie. 

## Future Plans/Summary
**What went well? What didn’t?**
The actual inclusion of all images and text went rather well, and the computer did not protest my many uses of Platform.exit(), and closed gracefully when I requested it too. I actually got rather used to the strange coordinate system that Java operates with, and did not have a hard time making images show up, and found it easy to animate them using transitions. The if statements also mostly worked, an example being the compChooseObject() helper method does its job correctly, and was not that difficult to create.

On the other hand, I ran into a lot of obstacles when creating this game. As mentioned earlier, the idea of a while loop, or even a for loop, was an initial failure, and was cut entirely from the final project. At first, helper methods would not work when created in eventHandlers, which is where I needed them to be placed. To overcome this problem, I created my helper methods elsewhere and called them inside of the eventHandlers I had created. I had a very hard time understanding why the program would suddenly run through the code one too many times after the first round, and then realized it was because of the multiple eventHandlers. Removing these eventHandlers also proved to be in vain, as the removeeventHandler line would not work. However, eventually I realized, that if I were to simply remove the addition of a point to either win or lose in the second set of eventHandlers, then the game would work properly. Overall, this game proved difficult and at times, mind bending to work on, but in the end I managed to finish it. 

**Discuss at least one internet search you conducted to help solve a sticking point/bug in your design process/code. Where did you find solutions? How did you evaluate them?**
When I first started using Java, I was not used to the program looking through the entire code at once and running everything simultaneously. I wished for a function that would slow the program down and make it wait a few seconds when I wished for things to pop up on screen in a certain order. At first, I found the thread.sleep() function, but after talking with my instructor, found that use of it was slightly dangerous, and could mess up the code and the timeline in its entirety. Instead, I stumbled upon the .setOnFinished() function on the Oracle JavaFX 2.0 page. This function would allow me to force the program to wait until an eventHandler has finished conducting an event before running the code inside of the set.OnFinished() function. I have implemented this command in multiple parts of the program, and it has proved very beneficial to the program’s timing generously. I also found other things that were quite useful on this page, an example being the setCycleCount(INDEFINITE) command. Using this, I managed to get the animations of the three objects “floating” to last forever. 

**What would you change or improve given more time?**
There are undoubtedly ways to exploit this game. I would spend most of my time making sure that if the player chooses one object, all other objects are pushed off screen instead of just turning invisible to make sure that the user can’t click on them. I would also make sure that if the user clicks on an object, all objects are unclickable for a moment, to give the game time to comprehend what has happened.

I would also definitely work on the timing of the transitions. Though they do their job, some of them are a little awkward in terms of their length and in regards to the other transitions happening on screen, and are a little bit boring. I would mess around with flashier transitions if I had the time. I would also perhaps add an animated background to this game, if the program would allow it. Instead of having a drab black background, which sort of works but is, once again, a little bit boring, I could make some kind of animated screen. I would also, perhaps, add a little introductory screen where one can choose “begin game” in order to start the game. Additionally, I would most probably replace the images with drawn ones that I have created. Lastly, I would add music to make this game more lively. Let’s be honest, music makes everything better. 



## Photo Attributions
