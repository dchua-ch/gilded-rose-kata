package com.gildedrose.updater;

import com.gildedrose.Item;

class BackstagePassUpdater extends ItemUpdater{

    BackstagePassUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn--;
        if (item.sellIn < 10 && item.sellIn >= 5) {
            incrementQuality(2);  
        }

        else if (item.sellIn < 5 && item.sellIn >= 0) {
            incrementQuality(3); 
        }

        else if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;
        }

        else {
            incrementQuality(1); 
        }
        
    }
    
}
