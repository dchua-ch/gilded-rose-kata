package com.gildedrose.updater;

import com.gildedrose.Item;

class AgedBrieUpdater extends ItemUpdater{

    AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn--;
        if(item.sellIn < 0) {
            incrementQuality(2); 
        }
        else {
            incrementQuality(1);
        }
    }
}
