-Single Responsibility Principle
    Violation in Violation package in Utility Class as class contained more
    than one responsibility.
    Utility class was split into a package that contains Input,DefaultOptions and ToDoUtility class.

-Open And Closed Principle
    Violation in ToDoCommands class, it is closely coupled for 3 interactions on a todo model object.
    An enum is passed into a new instance to specify the interactions. This makes it harder to make
    extensions (suppose on a special message before deleting).
    Solution is separate all those actions into separate commands (CreateNewToDoCommand,DeleteToDoCommand,CheckToDoCommand).
    When we can want a special functionality we can inherit that command and override the execute function.

-Liskov Substitution Principle
    Violation of LSP in InfoOptionScreen, as we are doing Runtime casting on back command to get that
    extra polymorphic method execute from that class. The parent class has no idea of the extra function implemented
    in the Subclass.
    Solution write the extra polymorphic method in the abstraction and override it in the subclass that needs
    it.

-Interface Segregation Principle
    Solution to DIP below gave us a new violation, now we are forcing the class implementing the interface to implement
    two methods. InfoOption doesn't need getCommand() .
    Solution is  we create a new separate Interface called ScreenCommand with that method and options that
    need those methods will implement it.


-Dependency Inversion Principle
    Violation from ScreenDataOriginal class, this is lower level module that is used to pass data
    from Command To Screen.DIP says HIGHER and LOWER Level modules should depend on abstraction and
    not directly on each other.We are passing in a String and a Command through it. Some screen data
    don't need a corresponding Command but will be forced to pass a Command while creating an instance of
    ScreenData.
    Solution we use interfaces with those getters. The constructor from the class implementing those
    will take parameters be it 1 or 2, not forcing to send a null(forcing 2 constructor arguments is avoided)
