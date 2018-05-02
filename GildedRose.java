package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (int i = 0; i < items.length; i++) {
        	
        	Item currentItem = items[i];
        	
        	if (itemIsCommonItem(currentItem)) 
                updateCommonItem((CommonItem) currentItem);
        	
        	if(itemIsBackstagePasses(currentItem))
        		updateBackstagePasses((BackstagePasses) currentItem);
        	
        	if(itemIsAgedBrie(currentItem))
        		updateAgedBrie((AgedBrie) currentItem);
        	

        }
    }
    
    private void updateCommonItem(CommonItem item) {
    	decreaseItemQuality(item);
    	decreaseItemSellIn(item);
    	if(item.sellIn < 0)
    		decreaseItemQuality(item);
    }
    
    private void updateBackstagePasses(BackstagePasses item) {
    	increaseItemQuality(item);
        if (item.sellIn < 11) {
            increaseItemQuality(item);
        }

        if (item.sellIn < 6) {
            increaseItemQuality(item);
        }
        decreaseItemSellIn(item);
        if(item.sellIn < 0)
        	increaseItemQuality(item);
    }
    
    private void updateAgedBrie(AgedBrie item) {
    	increaseItemQuality(item);
        if(item.sellIn < 0)
        	increaseItemQuality(item);
    }
    
    private void updateSulfuras(Sulfuras item) {
    	increaseItemQuality(item);
        if(item.sellIn < 0)
        	increaseItemQuality(item);
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
