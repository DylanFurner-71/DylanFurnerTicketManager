# DylanFurnerTicketManager

To execute this code, download the file, navigate to the directory the source code is in using the terminal/command line and then simply call 
				$ java Main


My largest assumption that I have made is, by far, trusting the user to keep track of if they have entered the proper number of seats before entering “-1” as a trigger to break out of a loop. This can be found in my userVenue.java class in the void buyTickets() function. This program is case-sensitive when input is given by the user when the user decides the time they would like to watch the movie and when they enter the name of the movie they would like to watch. 

This program can keep track of multiple orders of tickets and match them to their seat at a local movie theater.

Class UserVenue handles the vast majority of this code, acting as the driver to create the menu and allowing for user interaction with the program. 

Class venue contains the information related to the theater and creates the tickets and showings objects used throughout the program.


