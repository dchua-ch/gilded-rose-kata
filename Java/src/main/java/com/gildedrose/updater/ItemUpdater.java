package com.gildedrose.updater;

import com.gildedrose.Item;

public abstract class ItemUpdater {

    protected static final int MAX_QUALITY = 50;

    protected static final int MIN_QUALITY = 0;

    protected final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public abstract void updateItem();

    protected void incrementQuality(int amount) {
        for (int i = 0; i < amount; i++) {
            item.quality++;
            if (item.quality > MAX_QUALITY) {
                item.quality--;
                return;
            }
        }
    }

    protected void decrementQuality(int amount) {
        for(int i = 0; i < amount; i++) {
            item.quality--;
            if (item.quality < MIN_QUALITY) {
                item.quality++;
                return;
            }
        }
    }
    
}
