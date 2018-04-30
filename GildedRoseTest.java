package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {
	
	Item[] items;
	GildedRose app;
	
	
	public void createsItemsAndGildedRose(Item item) {
		items = new Item[] { item };
        app = new GildedRose(items);
	}

    @Test
    public void getCommonItemName() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 1));
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    public void getCommonItemSellIn() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 1));
        assertEquals(1, app.items[0].sellIn);
    }
    
    @Test
    public void getCommonItemQuality() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 1));
        assertEquals(1, app.items[0].sellIn);
    }  
    
    @Test
    public void afterUpdateCommonItemSellInDecreases() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 1));
    	app.update();
        assertEquals(0, app.items[0].sellIn);
    }  
    
    @Test
    public void afterUpdateCommonItemQualityDecreases() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 1));
    	app.update();
        assertEquals(0, app.items[0].quality);
    }  
    
    @Test
    public void commonItemQualityNeverNegative() {
    	createsItemsAndGildedRose(new CommonItem("foo", 1, 0));
    	app.update();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void ifSellInPassesCommonItemQualityDecreasesTwice() {
    	createsItemsAndGildedRose(new CommonItem("foo", 0, 10));
    	app.update();
        assertEquals(8, app.items[0].quality);
    }  
    
    @Test
    public void agedBrieQualityIncreases() {
    	createsItemsAndGildedRose(new AgedBrie("Aged Brie", 2, 0));
    	app.update();
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    public void qualityOfItemNeverBiggerThan50() {
    	createsItemsAndGildedRose(new AgedBrie("Aged Brie", 1, 50));
    	app.update();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void sulfurasSellInNeverDecrease() {
    	createsItemsAndGildedRose(new Sulfuras("Sulfuras, Hand of Ragnaros", 1, 80));
    	app.update();
        assertEquals(1, app.items[0].sellIn);
    }
    
    @Test
    public void sulfurasQualtyNeverDecrease() {
    	createsItemsAndGildedRose(new Sulfuras("Sulfuras, Hand of Ragnaros", 1, 80));
    	app.update();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    public void backstagePassesQualityIncreaseBy1IfSellInGreaterThan10() {
    	createsItemsAndGildedRose(new BackstagePasses
    			("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    	app.update();
        assertEquals(21, app.items[0].quality);
    }
    
    @Test
    public void backstagePassesQualityIncreaseBy2IfSellInMinorOrEqualThan10() {
    	createsItemsAndGildedRose(new BackstagePasses
    			("Backstage passes to a TAFKAL80ETC concert", 10, 20));
    	app.update();
        assertEquals(22, app.items[0].quality);
    } 
    
    @Test
    public void backstagePassesQualityIncreaseBy3IfSellInMinorOrEqualThan5() {
    	createsItemsAndGildedRose(new BackstagePasses
    			("Backstage passes to a TAFKAL80ETC concert", 5, 20));
    	app.update();
        assertEquals(23, app.items[0].quality);
    }
    
    
    
      
}