# KGildieAPI
API do pluginu na gildie :)

---
####Przykładowe użycie:

```java
public void onEnable(){
    KGildieAPI.getGuildByName("tag").get();
}
```

Tagi nad głową
```java
public void onEnable(){
    KGildieAPI.setVisible(context -> {
        context.setPrefix(ChatColor.GREEN + "[" + context.getNamedGuildPlayer().getGuild().getTag() + "] ");
        if (context.getNamedGuildPlayer().isOwner()) {
            context.setSuffix("**");
        }
    }, VisibleType.OWN);
}
```

Eventy:
```java
    @EventHandler
    public void onGuildCreated(GuildCreatedEvent event) {
        Guild g = event.getGuild();
        String tag = g.getTag();
        ...
    }
```

