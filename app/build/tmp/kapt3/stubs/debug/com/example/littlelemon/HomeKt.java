package com.example.littlelemon;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007\u001a&\u0010\t\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u001a&\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0013\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"CategorySection", "", "category", "Landroidx/compose/runtime/MutableState;", "", "HeroSection", "menuItems", "", "Lcom/example/littlelemon/MenuItemRoom;", "Home", "navController", "Landroidx/navigation/NavController;", "MenuItemsList", "items", "getCategoryBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "categoryName", "(Landroidx/compose/runtime/MutableState;Ljava/lang/String;)J", "getCategoryTextColor", "setCategoryValue", "app_debug"})
public final class HomeKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void Home(@org.jetbrains.annotations.Nullable
    androidx.navigation.NavController navController, @org.jetbrains.annotations.Nullable
    java.util.List<com.example.littlelemon.MenuItemRoom> menuItems) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CategorySection(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> category) {
    }
    
    private static final long getCategoryTextColor(androidx.compose.runtime.MutableState<java.lang.String> category, java.lang.String categoryName) {
        return 0L;
    }
    
    private static final long getCategoryBackgroundColor(androidx.compose.runtime.MutableState<java.lang.String> category, java.lang.String categoryName) {
        return 0L;
    }
    
    private static final void setCategoryValue(androidx.compose.runtime.MutableState<java.lang.String> category, java.lang.String categoryName) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void HeroSection(@org.jetbrains.annotations.Nullable
    java.util.List<com.example.littlelemon.MenuItemRoom> menuItems) {
    }
    
    @kotlin.OptIn(markerClass = {com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi.class})
    @androidx.compose.runtime.Composable
    public static final void MenuItemsList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.littlelemon.MenuItemRoom> items) {
    }
}