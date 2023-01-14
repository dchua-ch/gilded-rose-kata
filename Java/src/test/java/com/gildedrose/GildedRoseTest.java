package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
   
    private static final String AGED_BRIE = "Aged Brie";

    private static final String FOO = "foo";

    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";


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
    void passedSellByDateTestNonNegativeQualityTest() {
        final int initialSellIn = 0;
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
    void agedBrieQualityNotAboveFiftyTest() {
        final int initialSellIn = 1;
        final int initialQuality = 50;

        baseTest(AGED_BRIE,
                initialSellIn,
                initialSellIn-1,
                initialQuality,
                initialQuality);
    }

    @Test
    void agedBriePassedSellByQualityNotAboveFiftyTest() {
        final int initialSellIn = 0;
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
        // Must initialize sellIn to -1 as it won't be decremented for SULFURAS
        final int initialSellIn = -1;
        final int initialQuality = 80;

        baseTest(SULFURAS,
                initialSellIn,
                initialSellIn,
                initialQuality,
                initialQuality);
    }

    @Test
    void backstagePassMoreThan10DaysTest() {
        final int initialSellIn = 11;
        final int initialQuality = 20;
        // If sell in more than 10 days, quality increments by 1
        baseTest(BACKSTAGE_PASS,
                initialSellIn,
                initialSellIn - 1,
                initialQuality,
                initialQuality + 1);
    }

    @Test
    void backstagePassMoreThan10DaysQualityNotAbove50Test() {
        final int initialSellIn = 11;
     
        baseTest(BACKSTAGE_PASS, 
        initialSellIn,
        initialSellIn - 1,
        50,
        50);

    }

    @Test
    void backstagePass10DaysOrLessTest() {
        final int initialQuality = 20;
        for(int initialSellIn = 6; initialSellIn <= 10 ; initialSellIn++) {
            baseTest(BACKSTAGE_PASS, 
                    initialSellIn,
                    initialSellIn - 1,
                    initialQuality,
                    initialQuality + 2);
        }
    }

    @Test
    void backstagePass10DaysOrLessQualityNotAbove50Test() {
        for(int initialSellIn = 6; initialSellIn <= 10 ; initialSellIn++) {
            baseTest(BACKSTAGE_PASS, 
                    initialSellIn,
                    initialSellIn - 1,
                    49,
                    50);
        }
    }

    @Test
    void backstagePass5DaysOrLessTest() {
        final int initialQuality = 20;
        for(int initialSellIn = 1; initialSellIn <= 5 ; initialSellIn++) {
            baseTest(BACKSTAGE_PASS, 
                    initialSellIn,
                    initialSellIn - 1,
                    initialQuality,
                    initialQuality + 3);
        }
    }

    @Test
    void backstagePass5DaysOrLessQualityNotAbove50Test() {
        for(int initialSellIn = 1; initialSellIn <= 5 ; initialSellIn++) {
            baseTest(BACKSTAGE_PASS, 
            initialSellIn,
            initialSellIn - 1,
            48,
            50);
        }
    }


    @Test
    void backstagePassAfterConcertTest() {
        final int initialSellIn = 0;
        final int initialQuality = 20;
        baseTest(BACKSTAGE_PASS, 
                initialSellIn,
                initialSellIn - 1,
                initialQuality,
                0);
    }

    @Test
    void testToString() {
        final int initialSellIn = 0;
        final int initialQuality = 20;

        Item item = new Item(FOO,initialSellIn,initialQuality);

        assertEquals(FOO + ", " + String.valueOf(initialSellIn) + ", " + String.valueOf(initialQuality),
                item.toString());
    }



}
