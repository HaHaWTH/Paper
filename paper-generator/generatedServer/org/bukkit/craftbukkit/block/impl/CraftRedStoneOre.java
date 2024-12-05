package org.bukkit.craftbukkit.block.impl;

import io.papermc.paper.generated.GeneratedFrom;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.bukkit.block.data.Lightable;
import org.bukkit.craftbukkit.block.data.CraftBlockData;

@GeneratedFrom("1.21.3")
public class CraftRedStoneOre extends CraftBlockData implements Lightable {
    private static final BooleanProperty LIT = RedStoneOreBlock.LIT;

    public CraftRedStoneOre(BlockState state) {
        super(state);
    }

    @Override
    public boolean isLit() {
        return this.get(LIT);
    }

    @Override
    public void setLit(final boolean lit) {
        this.set(LIT, lit);
    }
}