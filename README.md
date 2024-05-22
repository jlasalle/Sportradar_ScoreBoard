# Sportradar_ScoreBoard
Recruitment test for the position of Engineering Team Lead at Sportradar (by Jonathan Lasalle)

In a "real-life" context, the scope of the tests would have to be extended to handle all the special cases, such as:
- trying to create a game with a null name
- deleting a game that is not in the ScoreBoard
- modifying the score of a game that is not in the ScoreBoard
- having the same team on the scoreboard twice
- ...

It is also necessary to define the rules for modifying scores (what is authorised and what is not):
- negative scores?
- decreasing scores?
- only increasing scores by increments of 1 ? Or more ?

For each of these cases, it is then necessary to specify the expected behaviour (not present in the specification provided).