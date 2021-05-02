package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.components;

public enum OrderStatus {
    Error,

    //OrderApplication
    Received,

    //OrderDomain
    Validating,
    Processing,

    //Printing
    PrintQueue,
    Printing,

    //Finished
    ReadyForPickup
}