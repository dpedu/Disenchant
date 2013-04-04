package me.dpedu.disenchant;

import java.util.Iterator;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Disenchant extends JavaPlugin implements Listener {
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents( this, this );
	}
	@EventHandler
	public void onEnchantRightclick( InventoryClickEvent e )
	{
		
		// Check that we want to remove enchants
		if ( !e.getInventory().getName().equalsIgnoreCase( "Enchant" ) ) return;
		if ( !e.getSlotType().name().equalsIgnoreCase( "crafting" ) ) return;
		if ( !e.isRightClick() ) return;
		if ( e.getCurrentItem().getType().getId() == 0 ) return;
		
		// Remove the old enchants
		ItemStack item = e.getCurrentItem();
		Map<Enchantment, Integer> enchants = item.getEnchantments();
		Iterator<Enchantment> enchantIterator = enchants.keySet().iterator();
		while( enchantIterator.hasNext() ) item.removeEnchantment( enchantIterator.next() );
	}
}
