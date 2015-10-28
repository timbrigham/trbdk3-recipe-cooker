package com.trbdk3.RecipeCooker;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.trbdk3.RecipeCooker.Recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterRecipe 
{
	public void init()
	{
	}
	public void Register( File file )
	{
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
		System.out.println( "----------------trbdk3----------------" );

		System.out.println("line a " + recipe.lineA);
		System.out.println("line b " + recipe.lineB);
		System.out.println("line c " + recipe.lineC);   		
		System.out.println("input items " + recipe.inputItems);
		System.out.println("input item Association " + recipe.inputAssociation);

		
		System.out.println( "----------------trbdk3----------------" );


		ItemStack Output = new ItemStack( GameRegistry.findItem("minecraft",recipe.output ), recipe.outputCount  );
		System.out.println( "output item stack" + Output );

		
		Item itemA;
		char assocA;
		Item itemB;
		char assocB;
		Item itemC;
		char assocC;
		Item itemD;
		char assocD;
		Item itemE;
		char assocE;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
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
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
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
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	assocB = recipe.assc(1);
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
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
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	assocB = recipe.assc(1);
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
	    	assocC = recipe.assc(2);
	    	itemD= GameRegistry.findItem("minecraft", recipe.inputItems.get(3) );
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
		case 5:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	assocB = recipe.assc(1);
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
	    	assocC = recipe.assc(2);
	    	itemD= GameRegistry.findItem("minecraft", recipe.inputItems.get(3) );
	    	assocD = recipe.assc(3);
	    	itemE= GameRegistry.findItem("minecraft", recipe.inputItems.get(4) );
	    	assocE = recipe.assc(4);
	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	recipe.lineC,
	    	    	assocA, itemA,
	    	    	assocB, itemB,
	    	    	assocC, itemC,        	    	
	    	    	assocD, itemD,        	    	
	    	    	assocE, itemE        	    	
					);
			break;
		
		
	}
		
	}
	private void grid2( Recipe recipe )
	{
		System.out.println( "----------------trbdk3----------------" );
		System.out.println("line a " + recipe.lineA);
		System.out.println("line b " + recipe.lineB);
		System.out.println("input items " + recipe.inputItems);
		System.out.println("input item Association " + recipe.inputAssociation);		
		System.out.println( "----------------trbdk3----------------" );


		ItemStack Output = new ItemStack( GameRegistry.findItem("minecraft",recipe.output ), recipe.outputCount  );
		System.out.println( "output item stack" + Output );

		
		Item itemA;
		char assocA;
		Item itemB;
		char assocB;
		Item itemC;
		char assocC;
		Item itemD;
		char assocD;
		Item itemE;
		char assocE;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	
	    	GameRegistry.addRecipe(
	    			Output ,
	    	    	recipe.lineA,
	    	    	recipe.lineB,
	    	    	assocA, itemA
					);
			break;
		case 2:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
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
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	assocB = recipe.assc(1);
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
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
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	assocA = recipe.assc(0);
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	assocB = recipe.assc(1);
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
	    	assocC = recipe.assc(2);
	    	itemD= GameRegistry.findItem("minecraft", recipe.inputItems.get(3) );
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
		//GameRegistry.addShapelessRecipe(new ItemStack(Blocks.bedrock), Items.diamond, Items.lava_bucket, new ItemStack(Blocks.wool, 1, 2));
		ItemStack Output = new ItemStack( GameRegistry.findItem("minecraft",recipe.output ), recipe.outputCount  );
		
		System.out.println( "----------------trbdk3----------------" );
		System.out.println("input items " + recipe.inputItems);
		System.out.println("input item Association " + recipe.inputAssociation);		
		System.out.println( "----------------trbdk3----------------" );
		System.out.println( "output item stack" + Output );

		
		Item itemA;
		Item itemB;
		Item itemC;
		Item itemD;
		Item itemE;
		
		switch ( recipe.inputItems.size() )
		{
		case 1:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	GameRegistry.addShapelessRecipe( Output, itemA );
			break;
		case 2:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB );
	    	break;
		case 3:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB, itemC );
	    	break;
		case 4:
	    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
	    	itemB = GameRegistry.findItem("minecraft", recipe.inputItems.get(1) );
	    	itemC = GameRegistry.findItem("minecraft", recipe.inputItems.get(2) );
	    	itemD= GameRegistry.findItem("minecraft", recipe.inputItems.get(3) );
	    	GameRegistry.addShapelessRecipe( Output, itemA, itemB, itemC, itemD );
			break;
		}
		
	}
	private void smelting( Recipe recipe )
	{
//		GameRegistry.findBlock(modId, name)
		
//		GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(Items.diamond, 2), 1F);		
		ItemStack Output = new ItemStack( GameRegistry.findItem("minecraft",recipe.output ), recipe.outputCount  );
		Item itemA;
    	itemA = GameRegistry.findItem("minecraft", recipe.inputItems.get(0) );
		System.out.println( "output item stack" + Output );
		GameRegistry.addSmelting(itemA, Output, 1F);		
	}
}

