package com.trbdk3.RecipeCooker;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import javax.xml.bind.*;


@Mod(modid = "trbdk3-RecipeCooker", version = "1.3" )
public class RecipeCooker {

	// This is a config folder reference used elsewhere
	File folder;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		String expandMe = event.getModConfigurationDirectory().getAbsolutePath()+"/trbdk3/recipes";
		folder = new File(expandMe);
	}    
	        
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		File[] listOfFiles = folder.listFiles();
		RegisterRecipe allRecipe = new RegisterRecipe();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(".xml")) {
					System.out.println(file.toString());   		    		  
				allRecipe.Register(file);
			} 	
		}    		
	}
}	
