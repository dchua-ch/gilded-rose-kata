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


    void baseTest( 
                String itemName,
                int initialSellIn, 
                int finalSellIn,
                int initialQuality,  
                int finalQuality) {
        
        Item[] items = new Item[] { new Item(itemName, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();

        assertEquals(itemName, app.items[0].name);
        assertEquals(finalSellIn, app.items[0].sellIn);
        assertEquals(finalQuality,app.items[0].quality);
    }

    @Test
    void baseUpdateTest() {
        final int initialSellIn = 1;
        final int initialQuality = 20;

        baseTest(FOO,
                 initialSellIn,
                 initialSellIn-1,
                 initialQuality,
                 initialQuality-1);
    }


    @Test
    void passedSellByDateTest() {
        final int initialSellIn = 0;
        final int initialQuality = 20;

        baseTest(FOO,
                 initialSellIn,
                 initialSellIn-1,
                 initialQuality,
                 initialQuality-2);
    }

    @Test
    void nonNegativeQualityTest() {
        final int initialSellIn = 1;
        final int initialQuality = 0;
        baseTest(FOO,
                 initialSellIn,
                 initialSellIn-1,
                 initialQuality,
                 initialQuality);
    }

    @Test
    void agedBrieTest() {
        final int initialSellIn = 1;
        final int initialQuality = 10;

        baseTest(AGED_BRIE,
                 initialSellIn,
                 initialSellIn-1,
                 initialQuality,
                 initialQuality+1);
    }

    
    @Test
    void agedBriePassedSellByTest() {
        final int initialSellIn = 0;
        final int initialQuality = 10;

        baseTest(AGED_BRIE,
                 initialSellIn,
                 initialSellIn-1,
                 initialQuality,
                 initialQuality+2);
    }

    @Test
    void qualityNotAboveFiftyTest() {
        final int initialSellIn = 1;
        final int initialQuality = 50;

        baseTest(AGED_BRIE,
                initialSellIn,
                initialSellIn-1,
                initialQuality,
                initialQuality);
    }

    @Test
    void sulfurasTest() {
        final int initialSellIn = 1;
        final int initialQuality = 80;

         // The existing code doesn't seem to ensure that SULFURAS will always have a quality of 80
        baseTest(SULFURAS,
                initialSellIn,
                initialSellIn,
                initialQuality,
                initialQuality);
    }

    @Test
    void sulfurasPassedSellByTest() {
        final int initialSellIn = 0;
        final int initialQuality = 80;

        baseTest(SULFURAS,
                initialSellIn,
                initialSellIn,
                initialQuality,
                initialQuality);
    }

}
