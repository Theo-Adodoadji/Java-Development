package org.example;

//This project is going to need some serious work. I think you still don't quite understand
//the separation of concerns. The DealershipFileManager is the only place where you
//read the file. Nowhere else. The UserInterface just shows data, and the Dealership filters it.
//You can't really do the UserInterface until the Dealership is done. I think you tried to do things
//out of order and that's why you have logic in the UserInterface that has to do with reading a file.
//I'd like you to start at getting the FileManager working first. Then work on the Dealership. ONLY
//when these two are done should you move on to UserInterface.
public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.display();
    }
}