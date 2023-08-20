package com.example.littlelemon;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/littlelemon/MenuItemDao;", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/littlelemon/MenuItemRoom;", "insertAll", "", "menuItems", "", "([Lcom/example/littlelemon/MenuItemRoom;)V", "isEmpty", "", "app_debug"})
@androidx.room.Dao
public abstract interface MenuItemDao {
    
    @androidx.room.Query(value = "SELECT * FROM MenuItemRoom")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.littlelemon.MenuItemRoom>> getAll();
    
    @androidx.room.Insert
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    com.example.littlelemon.MenuItemRoom... menuItems);
    
    @androidx.room.Query(value = "SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    public abstract boolean isEmpty();
}