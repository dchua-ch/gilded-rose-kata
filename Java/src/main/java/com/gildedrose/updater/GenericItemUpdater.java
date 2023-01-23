package com.gildedrose.updater;

import com.gildedrose.Item;

public class GenericItemUpdater extends ItemUpdater{

    public GenericItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        if (item.quality <= MIN_QUALITY) {
            return;
        }
        else if(item.sellIn < 0) {
            decrementQuality(2);
        } else {
            decrementQuality(1);
        }
        
        
    }
    
}
