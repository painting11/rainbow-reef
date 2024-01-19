package net.thevaliantsquidward.rainbowreef.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thevaliantsquidward.rainbowreef.RainbowReef;
import net.thevaliantsquidward.rainbowreef.block.custom.BubblerBlock;
import net.thevaliantsquidward.rainbowreef.block.custom.MudBurrowBlock;
import net.thevaliantsquidward.rainbowreef.block.custom.FakeBubbleBlock;
import net.thevaliantsquidward.rainbowreef.block.custom.PufferLanternBlock;
import net.thevaliantsquidward.rainbowreef.item.ModItems;

import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            RainbowReef.MOD_ID);

    public static final RegistryObject<Block> CORALSTONE = registerBlock("coralstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL_BLOCK).strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORALSTONE_BRICKS = registerBlock("coralstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL_BLOCK).strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> POLISHED_CORALSTONE = registerBlock("polished_coralstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL_BLOCK).strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CHISELED_CORALSTONE = registerBlock("chiseled_coralstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEAD_BUBBLE_CORAL_BLOCK).strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BUBBLER = registerBlock("bubbler",
            () -> new BubblerBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> FAKE_BUBBLES = registerBlock("fake_bubbles",
            () -> new FakeBubbleBlock(BlockBehaviour.Properties.copy(Blocks.BUBBLE_COLUMN).mapColor(MapColor.WATER).replaceable().noCollission().noLootTable().pushReaction(PushReaction.DESTROY).liquid().sound(SoundType.EMPTY)));

    public static final RegistryObject<Block> MUD_BURROW = registerBlock("mud_burrow",
            () -> new MudBurrowBlock(BlockBehaviour.Properties.copy(Blocks.MUD).mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.MUD)));

    public static final RegistryObject<Block> SAND_BURROW = registerBlock("sand_burrow",
            () -> new MudBurrowBlock(BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.SAND).sound(SoundType.SAND)));

    public static final RegistryObject<Block> STONE_BURROW = registerBlock("stone_burrow",
            () -> new MudBurrowBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).sound(SoundType.STONE)));


    public static final RegistryObject<Block> GREEN_GLASS_CHAIN = registerBlock("base_glass_chaingreen",
            () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN).forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> BLUE_PUFFER_LANTERN = registerBlock("blue_puffer_lantern",
            () -> new PufferLanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).strength(1.0F, 0.0F).sound(SoundType.WOOL).lightLevel((p_152677_) -> {
                return 15;
            }).noOcclusion().pushReaction(PushReaction.DESTROY)));



    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
    private static <T extends Block> Supplier<T> create(String key, Supplier<T> block, Function<Supplier<T>, Item> item) {
        Supplier<T> entry = create(key, block);
        ModItems.ITEMS.register(key, () -> item.apply(entry));
        return entry;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> Supplier<T> create(String key, Supplier<T> block, CreativeModeTab tab) {
        return create(key, block, entry -> new BlockItem(entry.get(), new Item.Properties()));
    }



    private static <T extends Block> Supplier<T> create(String key, Supplier<T> block) {
        return BLOCKS.register(key, block);
    }
}
