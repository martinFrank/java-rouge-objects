package com.github.martinfrank.javarouge.objects;

import org.jooq.Configuration;

import java.io.Closeable;

public interface ConfigurationProvider extends Closeable {

    Configuration getConfiguration();

}
