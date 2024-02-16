package service;

import entity.Matches;

import javax.swing.text.MaskFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OngoingMatchesService {
    private static final Map<UUID, Matches> matchesMap = new HashMap<>();

    public void addNewMatch(UUID uuid, Matches match) {
        matchesMap.put(uuid, match);
    }

    public static Matches getCurrentMatch(String stringUUID) {
        UUID uuid = UUID.fromString(stringUUID);
        return matchesMap.get(uuid);
    }

    public static void deleteCurMatch(String stringUUID) {
        UUID uuid = UUID.fromString(stringUUID);
        matchesMap.remove(uuid);
    }
}
