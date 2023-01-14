package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /**
     *
     */
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    /**
     *
     */
    private static final String AGED_BRIE = "Aged Brie";
    /**
     *
     */
    private static final String FOO = "foo";

    @Test
    void baseUpdateTest() {
        // For items whose sell by date hasn't passed

        final int initialSellIn = 1;
        final int initialQuality = 20;

        //Arrange
        Item[] items = new Item[] { new Item(FOO, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);

        //Act
        app.updateQuality();

        //Assert
        assertEquals(FOO, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality - 1,app.items[0].quality);
    }


    @Test
    void passedSellByDateTest() {

        final int initialSellIn = 0;
        final int initialQuality = 20;

        Item[] items = new Item[] { new Item(FOO, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(FOO, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality - 2,app.items[0].quality);
    }

    @Test
    void nonNegativeQualityTest() {

        final int initialSellIn = 1;
        final int initialQuality = 0;

        Item[] items = new Item[] { new Item(FOO, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(FOO, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality,app.items[0].quality);
    }

    @Test
    void agedBrieTest() {
        final int initialSellIn = 1;
        final int initialQuality = 10;

        Item[] items = new Item[] { new Item(AGED_BRIE, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality + 1,app.items[0].quality);
    }

    
    @Test
    void agedBriePassedSellByTest() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        Item[] items = new Item[] { new Item(AGED_BRIE, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality + 2,app.items[0].quality);
    }

    @Test
    void qualityNotAboveFiftyTest() {
        final int initialSellIn = 1;
        final int initialQuality = 50;

        Item[] items = new Item[] { new Item(AGED_BRIE, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(initialSellIn - 1, app.items[0].sellIn);
        assertEquals(initialQuality,app.items[0].quality);
    }

    @Test
    void sulfurasTest() {
        final int initialSellIn = 1;
        final int initialQuality = 80;

        // The existing code doesn't seem to ensure that SULFURAS will always have a quality of 80
        Item[] items = new Item[] { new Item(SULFURAS, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(SULFURAS, app.items[0].name);
        assertEquals(initialSellIn, app.items[0].sellIn);
        assertEquals(80,app.items[0].quality);
    }

    @Test
    void sulfurasPassedSellByTest() {
        final int initialSellIn = 0;
        final int initialQuality = 80;

        Item[] items = new Item[] { new Item(SULFURAS, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(SULFURAS, app.items[0].name);
        assertEquals(initialSellIn, app.items[0].sellIn);
        assertEquals(80,app.items[0].quality);
    }

}
