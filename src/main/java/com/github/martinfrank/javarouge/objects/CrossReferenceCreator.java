package com.github.martinfrank.javarouge.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrossReferenceCreator {


    private static final String STATS = "src/main/resources/sql/Stats.sql";
    private static final String SKILLS = "src/main/resources/sql/Skills.sql";
    private static final String START_EQUIPMENT = "src/main/resources/sql/StartEquipment.sql";
    private static final String DROPS = "src/main/resources/sql/Drops.sql";
    private static final String INTRINSIC = "src/main/resources/sql/IntrinsicEquipment.sql";
    private static final String EQUIPMENT_SLOTS = "src/main/resources/sql/EquipmentSlots.sql";

    private static final String STAT_MODIFIER = "src/main/resources/sql/StatModifier.sql";
    private static final String SKILL_MODIFIER = "src/main/resources/sql/SkillModifier.sql";
    private static final String SUITABLE_SLOTS = "src/main/resources/sql/SuitableSlots.sql";
    private static final String APPLICABLE_SKILL = "src/main/resources/sql/ApplicableSkill.sql";

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
        String[] files = {STATS, SKILLS, START_EQUIPMENT, DROPS, INTRINSIC, EQUIPMENT_SLOTS, STAT_MODIFIER, SKILL_MODIFIER, SUITABLE_SLOTS, APPLICABLE_SKILL};
        List<String> statements = new ArrayList<>();
        for (String file : files) {
            List<String> lines = Files.readAllLines(new File(file).toPath());
            statements.addAll(lines.stream().filter(l -> l.trim().length() > 0 && l.trim().charAt(0) != '#').collect(Collectors.toList()));
        }
        return statements;
    }

}
