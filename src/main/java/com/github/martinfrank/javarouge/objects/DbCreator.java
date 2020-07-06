package com.github.martinfrank.javarouge.objects;

import java.io.File;

public class DbCreator {

    public static void main(String[] args) {
        File h2dbFile = new File("objects.mv.db");
        if (h2dbFile.exists()) {
            System.out.println("exists");
            h2dbFile.delete();
        }
        SchemaCreator.main(null);
        ContentCreator.main(null);
        CrossReferenceCreator.main(null);
    }
}
