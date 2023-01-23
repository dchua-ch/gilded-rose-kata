package com.gildedrose;

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
            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].sellIn < 10 && items[i].sellIn >= 5) {
                    incrementQuality(items[i],2);  
                }

                else if (items[i].sellIn < 5 && items[i].sellIn >= 0) {
                    incrementQuality(items[i],3); 
                }

                else if (items[i].sellIn < 0) {
                    items[i].quality = MIN_QUALITY;
                }

                else {
                    incrementQuality(items[i],1); 
                }
            }

            else if (items[i].name.equals(AGED_BRIE)) {
                if(items[i].sellIn < 0) {
                    incrementQuality(items[i],2); 
                }
                else {
                    incrementQuality(items[i],1);
                }
            }

            else if (items[i].name.equals(SULFURAS)) {
                break;
            }

            else {
                if(items[i].sellIn < 0) {
                    decrementQuality(items[i], 2);
                } else {
                    decrementQuality(items[i], 1);
                }
            }
        }
    }
}