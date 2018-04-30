package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (int i = 0; i < items.length; i++) {
        	
        	Item currentItem = items[i];
        	
            if (itemIsCommonOrSulfuras(currentItem)) {
                if (currentItem.quality > 0) {
                    if (itemIsCommonItem(currentItem)) {
                        currentItem.quality--;
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality++;

                    if (itemIsBackstagePasses(currentItem)) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.quality < 50) {
                                currentItem.quality++;
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (currentItem.quality < 50) {
                                currentItem.quality++;
                            }
                        }
                    }
                }
            }

            if (!itemIsSulfuras(currentItem)) {
                currentItem.sellIn--;
            }

            if (currentItem.sellIn < 0) {
                if (!itemIsAgedBrie(currentItem)) {
                    if (!itemIsBackstagePasses(currentItem)) {
                        if (currentItem.quality > 0) {
                            if (!itemIsSulfuras(currentItem)) {
                                currentItem.quality--;
                            }
                        }
                    } else {
                        currentItem.quality = currentItem.quality - currentItem.quality;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality++;
                    }
                }
            }
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

	private boolean itemIsCommonOrSulfuras(Item item) {
		return itemIsCommonItem(item)
		        || itemIsSulfuras(item);
	}
}
