package com.euphony.flora_fantasy.common.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.NotNull;

public class DurabilityShapelessRecipe extends ShapelessRecipe {
    final ItemStack result;

    public DurabilityShapelessRecipe(String string, CraftingBookCategory craftingBookCategory, ItemStack itemStack, NonNullList<Ingredient> nonNullList) {
        super(string, craftingBookCategory, itemStack, nonNullList);
        this.result = itemStack;
    }

    public @NotNull NonNullList<ItemStack> getRemainingItems(CraftingInput arg) {
        NonNullList<ItemStack> nonnulllist = super.getRemainingItems(arg);

        for(int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack item = arg.getItem(i);
            if(item.has(DataComponents.DAMAGE)) {
                ItemStack copy = item.copy();
                copy.setDamageValue(item.getDamageValue() + 1);
                nonnulllist.set(i, copy);
            }
        }

        return nonnulllist;
    }

    public static class Serializer implements RecipeSerializer<DurabilityShapelessRecipe> {
        private static final MapCodec<DurabilityShapelessRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Codec.STRING.optionalFieldOf("group", "").forGetter(ShapelessRecipe::getGroup), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((shapelessRecipe) -> shapelessRecipe.category()), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((shapelessRecipe) -> shapelessRecipe.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((list) -> {
            Ingredient[] ingredients = list.stream().filter((ingredient) -> !ingredient.isEmpty()).toArray((i) -> new Ingredient[i]);
            if (ingredients.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return ingredients.length > 9 ? DataResult.error(() -> "Too many ingredients for shapeless recipe") : DataResult.success(NonNullList.of(Ingredient.EMPTY, ingredients));
            }
        }, DataResult::success).forGetter((shapelessRecipe) -> shapelessRecipe.getIngredients())).apply(instance, DurabilityShapelessRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, DurabilityShapelessRecipe> STREAM_CODEC = StreamCodec.of(DurabilityShapelessRecipe.Serializer::toNetwork, DurabilityShapelessRecipe.Serializer::fromNetwork);

        public @NotNull MapCodec<DurabilityShapelessRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, DurabilityShapelessRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static DurabilityShapelessRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            String string = registryFriendlyByteBuf.readUtf();
            CraftingBookCategory craftingBookCategory = registryFriendlyByteBuf.readEnum(CraftingBookCategory.class);
            int i = registryFriendlyByteBuf.readVarInt();
            NonNullList<Ingredient> nonNullList = NonNullList.withSize(i, Ingredient.EMPTY);
            nonNullList.replaceAll((ingredient) -> Ingredient.CONTENTS_STREAM_CODEC.decode(registryFriendlyByteBuf));
            ItemStack itemStack = ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
            return new DurabilityShapelessRecipe(string, craftingBookCategory, itemStack, nonNullList);
        }

        private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, DurabilityShapelessRecipe shapelessRecipe) {
            registryFriendlyByteBuf.writeUtf(shapelessRecipe.getGroup());
            registryFriendlyByteBuf.writeEnum(shapelessRecipe.category());
            registryFriendlyByteBuf.writeVarInt(shapelessRecipe.getIngredients().size());

            for(Ingredient ingredient : shapelessRecipe.getIngredients()) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(registryFriendlyByteBuf, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, shapelessRecipe.result);
        }
    }
}
