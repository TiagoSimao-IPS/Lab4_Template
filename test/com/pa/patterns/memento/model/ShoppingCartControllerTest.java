package com.pa.patterns.memento.model;

import org.junit.jupiter.api.*;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartControllerTest {
    private ShoppingCartController ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new ShoppingCartController();
    }

    @Test
    void addProduct() {
        assertEquals(0, ctrl.getProducts().size());
        ctrl.addProduct("Test product", 42.0);
        assertEquals(1, ctrl.getProducts().size());
    }

    @Test
    void reset() {
        ctrl.addProduct("Test product1", 42.0);
        ctrl.addProduct("Test product2", 27.0);
        ctrl.addProduct("Test product3", 38.0);
        ctrl.reset();

        assertEquals(0, ctrl.getProducts().size());
    }

    @Test
    void removeProduct() {
        ctrl.addProduct("Test product1", 17.0);
        ctrl.addProduct("Test product2", 29.0);
        ctrl.addProduct("Test product3", 34.0);
        ctrl.removeProduct("Test product1");

        System.out.println(ctrl.showAll());
        assertEquals(2, ctrl.getProducts().size());
    }

    @Test
    void undo() throws NoMementoException {
        ctrl.addProduct("Test product1", 19.0);
        ctrl.addProduct("Test product2", 24.0);
        ctrl.undo();

        System.out.println(ctrl.showAll());
        assertEquals(1, ctrl.getProducts().size());
    }

    @Test
    void getProducts() {
        ctrl.addProduct("Test product1", 28.0);
        ctrl.addProduct("Test product2", 36.0);

        Collection<Product> products = ctrl.getProducts();

        assertEquals(products, ctrl.getProducts());
    }

    @Test
    void showAll() {
        ctrl.addProduct("Test product1", 35.0);

        assertEquals("[Test product1 (35.0)]\n" +
                             "Total price:35.0", ctrl.showAll());
    }
}