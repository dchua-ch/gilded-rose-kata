package com.gildedrose.updater;

import com.gildedrose.Item;

class SulfurasUpdater extends ItemUpdater{

    SulfurasUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
      // Sulfuras is legendary and never has to be sold
      // its quality never decreases
    }
    
}
