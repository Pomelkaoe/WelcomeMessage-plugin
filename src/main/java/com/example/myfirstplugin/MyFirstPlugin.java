package com.example.myfirstplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyFirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Регистрируем слушателя событий
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        // Загружаем конфигурацию
        saveDefaultConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Получаем сообщение из конфигурации
        String message = getConfig().getString("join-message", "Добро пожаловать на сервер!");
        // Отправляем сообщение игроку
        message = message.replace("%player%", event.getPlayer().getName()); // Заменяем %player% на имя игрока
        event.getPlayer().sendMessage(message);
    }
}
