package com.trbdk3.RecipeCooker;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.trbdk3.RecipeCooker.Recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

// ItemStack blackDye = new ItemStack(Item.dyePowder, 1, 0)


public class RegisterRecipe 
{
	private ItemStack GetItemStack( String parseName )
	{
		// Wrapper that returns an item stack of 1 
		return GetItemStack( parseName, 1 );
	}
	private ItemStack GetItemStack( String parseName, int count )
	{  
		// main 'get item stack' function.
		// This should be able to parse out any sub numbers (e.g 'dye.15' for bonemeal'
		
		System.out.println( "GetItemStack parseName   " + parseName );
		System.out.println( "GetItemStack count       " + count );
		System.out.println( "........................");

		
		if( parseName.contains(".") )
		{
			//System.out.println( "Contains a dot");
			//System.out.println( "parseName     " + parseName );
			String[] parts;
			parts = parseName.split("\\.");
			//System.out.println( parts );
			//System.out.println(parts.length);
			//System.out.println(parts[0]);
			int subtype = Integer.parseInt(parts[1]);
			System.out.println( "GetItemStack name        " + parts[0] );
			System.out.println( "GetItemStack count       " + subtype );
			return new ItemStack( GameRegistry.findItem("minecraft", parts[0]), count, subtype ) ;
		}
		else
		{
			return new ItemStack( GameRegistry.findItem("minecraft", parseName ), count ) ;			
		}

	}
	
	public void init()
	{
	}
	public void Register( File file )
	{ 
		// This is the main function for this class, used to register a recipe.
		Recipe recipe = new Recipe();
		try 
		{
			//File file = new File("/tmp/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Recipe.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			recipe = (Recipe) jaxbUnmarshaller.unmarshal(file);
			System.out.println(recipe.id);   					
		} catch (JAXBException e) {
			e.printStackTrace();
		}		
		
		
		switch ( recipe.id )
		{
		case "3x3":
			grid3( recipe );
			break;
		case "2x2":
			grid2( recipe );
			break;
		case "shapeless":
			shapeless( recipe );
			break;
		case "smelting":
			smelting( recipe );
			break;
		}
  }

	private void grid3( Recipe recipe )
	{	
		// Register a 3x3 grid recipe.
		// Supports up to 4 different ingredients. 
		ItemStack Output = GetItemStack(recipe.output, recipe.outputCount );
		System.out.println( "output item stack" + Output );
		ItemStack itemA;
		char assocA;
		ItemStack itemB;
		char assocB;
		ItemStack itemC;
		char assocC;
		ItemStack itemD;
		char assocD;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GetItemStack(recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	recipe.lineC,
	    	    	assocA, itemA
					);
			break;
		case 2:
	    	itemA = GetItemStack(recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack(recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);        		    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	recipe.lineC,
	    	    	assocA, itemA,
	    	    	assocB, itemB
					);
			break;
		case 3:
	    	itemA = GetItemStack( recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack( recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);
	    	itemC = GetItemStack( recipe.inputItems.get(2));
	    	assocC = recipe.assc(2);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	recipe.lineC,
	    	    	assocA, itemA,
	    	    	assocB, itemB,
	    	    	assocC, itemC        	    	
					);
			break;
		case 4:
	    	itemA = GetItemStack( recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack( recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);
	    	itemC = GetItemStack( recipe.inputItems.get(2));
	    	assocC = recipe.assc(2);
	    	itemD= GetItemStack( recipe.inputItems.get(3));
	    	assocD = recipe.assc(3);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	recipe.lineC,
	    	    	assocA, itemA,
	    	    	assocB, itemB,
	    	    	assocC, itemC,        	    	
	    	    	assocD, itemD        	    	
					);
			break;		
	}
		
	}
	private void grid2( Recipe recipe )
	{
		// Register a 2x2 grid recipe. 
		// Supports up to 4 different ingredients
		System.out.println( "grid2");
		System.out.println( "Output");
		ItemStack Output = GetItemStack( recipe.output, recipe.outputCount  );
		System.out.println( "/Output");
		ItemStack itemA;
		char assocA;
		ItemStack itemB;
		char assocB;
		ItemStack itemC;
		char assocC;
		ItemStack itemD;
		char assocD;
		ItemStack itemE;
		char assocE;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GetItemStack( recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	assocA, itemA
					);
			break;
		case 2:
	    	itemA = GetItemStack(recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack(recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	assocA, itemA,
	    	    	assocB, itemB
					);
			break;
		case 3:
	    	itemA = GetItemStack(recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack(recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);
	    	itemC = GetItemStack(recipe.inputItems.get(2));
	    	assocC = recipe.assc(2);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	assocA, itemA,
	    	    	assocB, itemB,
	    	    	assocC, itemC        	    	
					);
			break;
		case 4:
	    	itemA = GetItemStack(recipe.inputItems.get(0));
	    	assocA = recipe.assc(0);
	    	itemB = GetItemStack(recipe.inputItems.get(1));
	    	assocB = recipe.assc(1);
	    	itemC = GetItemStack(recipe.inputItems.get(2));
	    	assocC = recipe.assc(2);
	    	itemD=GetItemStack(recipe.inputItems.get(3));
	    	assocD = recipe.assc(3);	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	assocA, itemA,
	    	    	assocB, itemB,
	    	    	assocC, itemC,        	    	
	    	    	assocD, itemD        	    	
					);
			break;
		}
		
	}
	private void shapeless( Recipe recipe )
	{
		// register a shapless recipe.
		// Supports up to 4 ingredients
		ItemStack Output = GetItemStack( recipe.output, recipe.outputCount  );
		
		ItemStack itemA;
		ItemStack itemB;
		ItemStack itemC;
		ItemStack itemD;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GetItemStack( recipe.inputItems.get(0) );
	    	GameRegistry.addShapelessRecipe( Output, itemA );
			break;
		case 2:
	    	itemA = GetItemStack(recipe.inputItems.get(0) );
	    	itemB = GetItemStack(recipe.inputItems.get(1) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB );
	    	break;
		case 3:
	    	itemA = GetItemStack(recipe.inputItems.get(0) );
	    	itemB = GetItemStack(recipe.inputItems.get(1) );
	    	itemC = GetItemStack(recipe.inputItems.get(2) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB, itemC );
	    	break;
		case 4:
	    	itemA = GetItemStack(recipe.inputItems.get(0) );
	    	itemB = GetItemStack(recipe.inputItems.get(1) );
	    	itemC = GetItemStack(recipe.inputItems.get(2) );
	    	itemD= GetItemStack(recipe.inputItems.get(3) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB, itemC, itemD );
			break;
		}		
	}
	private void smelting( Recipe recipe )
	{
		ItemStack Output = GetItemStack( recipe.output, recipe.outputCount  );
		ItemStack itemA;
    	itemA = GetItemStack( recipe.inputItems.get(0) );
		GameRegistry.addSmelting(itemA, Output, 1F);		
	}
    
}

