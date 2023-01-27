package com.gildedrose.updater;

import com.gildedrose.Item;

public class ItemUpdaterFactory {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final String CONJURED = "Conjured";

    public ItemUpdater createItemUpdater(Item item) {

        switch (item.name) {
            case BACKSTAGE_PASSES:
                return new BackstagePassUpdater(item);
            case AGED_BRIE:
                return new AgedBrieUpdater(item);
            case SULFURAS:
                return new SulfurasUpdater(item);
            case CONJURED:
                return new ConjuredItemUpdater(item);
            default:
                return new DefaultItemUpdater(item);
        }
    }
}
