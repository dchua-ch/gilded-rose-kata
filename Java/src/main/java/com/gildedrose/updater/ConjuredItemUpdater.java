package com.gildedrose.updater;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends ItemUpdater{

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn--;
        if (item.sellIn < 0) {
            decrementQuality(4);
        }
        else {
            decrementQuality(2);
        }
    }
    
}
