package com.terraformersmc.cinderscapes.surfacebuilders;

import com.terraformersmc.biolith.api.surface.BiolithSurfaceBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.BlockColumn;

public class LuminousGroveSurfaceBuilder extends BiolithSurfaceBuilder {
	private final BlockState topMaterial;
	private final BlockState midMaterial;
	private final BlockState lowMaterial;

    public LuminousGroveSurfaceBuilder(BlockState topMaterial, BlockState midMaterial, BlockState lowMaterial) {
        this.topMaterial = topMaterial;
        this.midMaterial = midMaterial;
        this.lowMaterial = lowMaterial;
    }

    @Override
    public void generate(BiomeAccess biomeAccess, BlockColumn column, Random rand, Chunk chunk, Biome biome, int x, int z, int vHeight, int seaLevel) {
        BlockPos pos = new BlockPos(x, -128, z);
        boolean inAir = false;

        // Set in-biome netherrack
        // TODO: It would be nicer to make this start below the ceiling bedrock.
        for (int y = chunk.getTopYInclusive(); y >= seaLevel - 1; --y) {
            BlockState state = column.getState(y);
            if (state.isAir()) {
                inAir = true;
            } else {
                if (inAir && state.isOf(lowMaterial.getBlock()) && super.filterBiome(biomeAccess.getBiome(pos.withY(y)))) {
                    column.setState(y, rand.nextFloat() < 0.99f ? topMaterial : midMaterial);
                }
                inAir = false;
            }
        }
    }

    @Override
    public boolean filterBiome(RegistryEntry<Biome> biome) {
        return biome.isIn(BiomeTags.IS_NETHER);
    }
}
