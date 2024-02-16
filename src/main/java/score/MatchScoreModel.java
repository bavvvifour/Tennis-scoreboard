package score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchScoreModel {
    private int[] points;
    private int[] games;
    private int[] sets;

    public MatchScoreModel() {
        this.points = new int[] {0, 0};
        this.games = new int[] {0, 0};
        this.sets = new int[] {0, 0};
    }
}
