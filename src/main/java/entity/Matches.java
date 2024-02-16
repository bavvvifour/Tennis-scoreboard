package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import score.MatchScoreModel;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Players Player1;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Players Player2;

    @ManyToOne()
    @JoinColumn()
    private Players Winner;

    @Transient
    private MatchScoreModel matchScore;

    public Matches(Players player1, Players player2) {
        Player1 = player1;
        Player2 = player2;
        this.matchScore = new MatchScoreModel();
    }
}
