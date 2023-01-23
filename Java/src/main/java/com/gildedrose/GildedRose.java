package com.gildedrose;

import javax.swing.text.AbstractDocument.BranchElement;

class GildedRose {

    private static final int MAX_QUALITY = 50;

    private static final int MIN_QUALITY = 0;

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void incrementQuality(Item item, int amount) {
        for (int i = 0; i < amount; i++) {
            item.quality++;
            if (item.quality > MAX_QUALITY) {
                item.quality--;
                return;
            }
        }
    }

    private void decrementQuality(Item item, int amount) {
        for(int i = 0; i < amount; i++) {
            item.quality--;
            if (item.quality < MIN_QUALITY) {
                item.quality++;
                return;
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!item.name.equals(SULFURAS)) {
                item.sellIn--;
            }
            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn < 10 && item.sellIn >= 5) {
                    incrementQuality(item,2);  
                }

                else if (item.sellIn < 5 && item.sellIn >= 0) {
                    incrementQuality(item,3); 
                }

                else if (item.sellIn < 0) {
                    item.quality = MIN_QUALITY;
                }

                else {
                    incrementQuality(item,1); 
                }
            }

            else if (item.name.equals(AGED_BRIE)) {
                if(item.sellIn < 0) {
                    incrementQuality(item,2); 
                }
                else {
                    incrementQuality(item,1);
                }
            }

            else if (item.name.equals(SULFURAS)) {
                break;
            }

            else {
                if(item.sellIn < 0) {
                    decrementQuality(item, 2);
                } else {
                    decrementQuality(item, 1);
                }
            }
        }
    }
}