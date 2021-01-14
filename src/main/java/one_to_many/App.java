package one_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();


        Cart cart = new Cart();
        cart.setName("custom cart");

        Item item = new Item();
        item.setQuantity(100);
        item.setCart(cart);

        Item item2 = new Item();
        item2.setQuantity(200);
        item2.setCart(cart);

        Set<Item> items = new HashSet<>();
        items.add(item);
        items.add(item2);

        cart.setItems(items);

        // save to DB
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        transaction.commit();

        // read from DB
        Cart cartDB = (Cart) session.get(Cart.class, 1);
        System.out.println(cartDB + "---->" + cartDB.getItems());

        Item itemDB = (Item) session.get(Item.class, 2);
        System.out.println(itemDB + "---->" + itemDB.getCart());




    }
}
