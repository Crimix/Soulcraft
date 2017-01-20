package com.black_dog20.sc.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class SCWorldGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionType())
        {
        case NETHER:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case OVERWORLD:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case THE_END:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
		
	}
	
	private void generateSurface(World world, Random random, int i, int j)
	{
		for(int k = 0; k < 5; k++)//5 = maximum veins per chunk
		{
			int randomPosX = i + random.nextInt(16);
			int randomPosY = random.nextInt(128);//29 = spawns up to height
			int randomPosZ = j + random.nextInt(16);
			
			(new WorldGenMinable(Blocks.COAL_BLOCK.getDefaultState(), 6,  BlockMatcher.forBlock(Blocks.STONE))).generate(world, random, new BlockPos(randomPosX, randomPosY, randomPosZ));
		}
	}

	private void generateNether(World world, Random random, int i, int j)
	{
	}

	private void generateEnd(World world, Random random, int i, int j)
	{
	}
}
