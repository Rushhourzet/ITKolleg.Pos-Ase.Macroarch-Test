package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.components;

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
