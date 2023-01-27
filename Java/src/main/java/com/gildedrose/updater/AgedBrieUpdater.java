package com.gildedrose.updater;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemUpdater{

    public AgedBrieUpdater(Item item) {
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
