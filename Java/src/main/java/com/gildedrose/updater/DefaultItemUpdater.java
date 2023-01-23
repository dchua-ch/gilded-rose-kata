package com.gildedrose.updater;

import com.gildedrose.Item;

public class DefaultItemUpdater extends ItemUpdater{

    public DefaultItemUpdater(Item item) {
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
