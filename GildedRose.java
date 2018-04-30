package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (int i = 0; i < items.length; i++) {
        	
        	Item currentItem = items[i];
        	
            if (itemIsCommonItem(currentItem)) {
                decreaseItemQuality(currentItem);
            } else if (itemIsBackstagePasses(currentItem)) {
            	increaseItemQuality(currentItem);
                if (currentItem.sellIn < 11) {
                    increaseItemQuality(currentItem);
                }

                if (currentItem.sellIn < 6) {
                    increaseItemQuality(currentItem);
                }
            } else {
            	increaseItemQuality(currentItem);
            }
            	
            
            decreaseItemSellIn(currentItem);
            

            if (currentItem.sellIn < 0) {
                if (itemIsCommonItem(currentItem)) {
                    decreaseItemQuality(currentItem);                                                                         
                } else {
                    increaseItemQuality(currentItem);
                }
            }
        }
    }

	private void decreaseItemSellIn(Item currentItem) {
		if(!itemIsSulfuras(currentItem))
			currentItem.sellIn--;
	}

	private void increaseItemQuality(Item currentItem) {
		if (currentItem.quality < 50) {
		    currentItem.quality++;
		}
	}

	private void decreaseItemQuality(Item currentItem) {
		if (currentItem.quality > 0) {
		        currentItem.quality--;              
		}
	}

	private boolean itemIsAgedBrie(Item item) {
		return (item instanceof AgedBrie);
	}

	private boolean itemIsSulfuras(Item item) {
		return (item instanceof Sulfuras);
	}

	private boolean itemIsBackstagePasses(Item item) {
		return (item instanceof BackstagePasses);
	}

	private boolean itemIsCommonItem(Item item) {
		return (item instanceof CommonItem);
	}

}
