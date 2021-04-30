package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.components;

import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.bookdomain.domain.abstraction.Product;

public class LineItem {
    private int list_index;
    private int quantity;
    private long product_id;

    public LineItem(int list_index, int quantity, long p) {
        this.list_index = list_index;
        this.quantity = quantity;
        this.product_id = p;
    }

    public long getList_index() {
        return list_index;
    }

    public void setList_index(int list_index) {
        this.list_index = list_index;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getP() {
        return product_id;
    }

    public void setP(long product_id) {
        this.product_id = product_id;
    }
}
