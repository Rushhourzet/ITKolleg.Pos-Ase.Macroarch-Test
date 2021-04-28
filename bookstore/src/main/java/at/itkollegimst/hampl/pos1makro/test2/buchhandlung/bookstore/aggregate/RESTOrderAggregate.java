package at.itkollegimst.hampl.pos1makro.test2.buchhandlung.bookstore.aggregate;


public class RESTOrderAggregate {
    private String bookName;
    private String userName;
    private String userMail;


    public RESTOrderAggregate(String bookName, String userName, String userMail)
        this.bookName = bookName;
        this.userName = userName;
        this.userMail = userMail;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

}
