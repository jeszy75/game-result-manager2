package game.result;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameResult {

    @NonNull private String player1Name;
    @NonNull private String player2Name;
    @NonNull private String winnerName;
    private int moves;
    @NonNull private ZonedDateTime startDateTime;

}
