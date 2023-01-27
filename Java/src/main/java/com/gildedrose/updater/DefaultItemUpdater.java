package com.gildedrose.updater;

import com.gildedrose.Item;

class DefaultItemUpdater extends ItemUpdater{

    DefaultItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn--;
        if(item.sellIn < 0) {
            decrementQuality(2);
        } else {
            decrementQuality(1);
        }
        
        
    }
    
}
