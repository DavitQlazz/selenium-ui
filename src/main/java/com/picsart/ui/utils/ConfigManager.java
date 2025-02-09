package com.picsart.ui.utils;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface ConfigManager extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("base.url")
    @DefaultValue("https://picsart.com")
    String baseUrl();

    @Key("timeout")
    @DefaultValue("30")
    int longTimeout();

    @Key("short.timeout")
    @DefaultValue("5")
    int shortTimeout();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();
}
