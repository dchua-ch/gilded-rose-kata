package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void baseUpdateTest() {
        // For items whose sell by date hasn't passed

        final int initialSellIn = 1;
        final int initialQuality = 20;

        //Arrange
        Item[] items = new Item[] { new Item("foo", initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);

        //Act
        app.updateQuality();

        //Assert
        assertEquals("foo", app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality - 1,app.items[0].quality);
    }


    @Test
    void passedSellByDateTest() {

        final int initialSellIn = 0;
        final int initialQuality = 20;

        Item[] items = new Item[] { new Item("foo", initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality - 2,app.items[0].quality);
    }

    @Test
    void nonNegativeQualityTest() {

        final int initialSellIn = 1;
        final int initialQuality = 0;

        Item[] items = new Item[] { new Item("foo", initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality,app.items[0].quality);

    }

}
