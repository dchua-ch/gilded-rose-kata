package com.gildedrose;

class GildedRose {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].name.equals(BACKSTAGE_PASSES)) {
                if(items[i].quality >= 50) {
                    break;
                }
                else if (items[i].sellIn < 10 && items[i].sellIn >= 5) {
                    items[i].quality += 2;   
                }

                else if (items[i].sellIn < 5 && items[i].sellIn >= 0) {
                    items[i].quality += 3;
                }

                else if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }

                else {
                    items[i].quality++;
                }

                if (items[i].quality > 50) {
                    items[i].quality = 50;
                }
            }

            else if (items[i].name.equals(AGED_BRIE)) {
                if(items[i].quality >= 50) {
                    break;
                }
                else if(items[i].sellIn < 0) {
                    items[i].quality += 2;
                }
                else {
                    items[i].quality++;
                }
            }

            else if (items[i].name.equals(SULFURAS)) {
                break;
            }

            else {
                if (items[i].quality <= 0) {
                    break;
                }
                else if(items[i].sellIn < 0) {
                    items[i].quality -= 2;
                } else {
                    items[i].quality = items[i].quality - 1;
                }
            }
        }
    }
}