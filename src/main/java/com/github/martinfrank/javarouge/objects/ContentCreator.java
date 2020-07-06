package com.github.martinfrank.javarouge.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContentCreator {


    private static final String ITEM_TYPE = "src/main/resources/sql/ItemType.sql";
    private static final String MONSTER = "src/main/resources/sql/Monster.sql";
    private static final String SKILL = "src/main/resources/sql/Skill.sql";
    private static final String STAT = "src/main/resources/sql/Stat.sql";

    public static void main(String[] args) {
        try (H2ConfigurationProvider configurationProvider = new H2ConfigurationProvider()) {
            List<String> dbContent = getContent();
            Statement stmt = configurationProvider.getConnection().createStatement();
            for (String sql : dbContent) {
                stmt.executeUpdate(sql);
                System.out.println("execute sql: " + sql);
            }
            stmt.close();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getContent() throws IOException {
        String[] files = {ITEM_TYPE, MONSTER, SKILL, STAT};
        List<String> statements = new ArrayList<>();
        for (String file : files) {
            List<String> lines = Files.readAllLines(new File(file).toPath());
            statements.addAll(lines.stream().filter(l -> l.trim().length() > 0 && l.trim().charAt(0) != '#').collect(Collectors.toList()));
        }
        return statements;
    }

}
