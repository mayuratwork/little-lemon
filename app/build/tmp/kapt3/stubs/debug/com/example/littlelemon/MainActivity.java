package com.example.littlelemon;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0016\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/littlelemon/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "database", "Lcom/example/littlelemon/AppDatabase;", "getDatabase", "()Lcom/example/littlelemon/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "httpClient", "Lio/ktor/client/HttpClient;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "menuItemUrl", "", "fetchMenu", "", "Lcom/example/littlelemon/MenuItemNetwork;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveMenuToDatabase", "menuItemsNetwork", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String menuItemUrl = "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json";
    public android.content.Context mContext;
    @org.jetbrains.annotations.NotNull
    private final io.ktor.client.HttpClient httpClient = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    private final com.example.littlelemon.AppDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.Object fetchMenu(kotlin.coroutines.Continuation<? super java.util.List<com.example.littlelemon.MenuItemNetwork>> $completion) {
        return null;
    }
    
    private final void saveMenuToDatabase(java.util.List<com.example.littlelemon.MenuItemNetwork> menuItemsNetwork) {
    }
}