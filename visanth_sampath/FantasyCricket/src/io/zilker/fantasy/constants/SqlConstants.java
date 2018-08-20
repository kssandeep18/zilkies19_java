package io.zilker.fantasy.constants;

public class SqlConstants {
	public static final String LOGIN_SELECT = "SELECT * FROM users WHERE user_name= ? AND password = ?";
	public static final String SIGNUP_INSERT = "INSERT INTO users (user_name,email,password) VALUES (?,?,?)";
	public static final String MATCH_INSERT = "INSERT INTO matches_scheduled (team1,team2,scheduled_date,start_time,end_time,match_credits) VALUES (?,?,?,?,?,?)";
	public static final String MATCH_STATUS_INSERT = "INSERT INTO match_status (match_id,is_active,is_upcomming) values(?,1,1)";
	public static final String SELECT_LAST_INSERTED_ID = "SELECT * FROM matches_scheduled ORDER BY match_id DESC;";
	public static final String SELECT_ACTIVE_MATCHES = "SELECT * FROM matches_scheduled INNER JOIN match_status WHERE match_status.is_active = 1 AND matches_scheduled.match_id = match_status.match_id";
	public static final String UPDATE_ACTIVE_MATCH = "UPDATE match_status SET is_active= 0 WHERE match_id = ?";
	public static final String INSERT_INTO_PLAYER = "INSERT INTO player (player_name,type,rating) VALUES (?,?,?)";
	public static final String INSERT_INTO_TEAM = "INSERT INTO team (team_name) VALUES (?)";
	public static final String SELECT_TEAM_TABLE = "SELECT * FROM team WHERE team_name = ? ";
	public static final String INSERT_INTO_TEAM_AND_PLAYER = "INSERT INTO players_in_team (team_id,player_id) VALUES (?,?)";
	public static final String SELECT_LAST_PLAYER = "SELECT * FROM player order by player_id  desc";
	public static final String SELECT_PLAYERS = "SELECT * FROM player";
	public static final String UPDATE_PLAYER_RATING = "UPDATE player SET rating = ? WHERE player_id = ?";
	public static final String SELECT_ROLE = "SELECT * FROM player WHERE player_id = ? ";
	public static final String SELECT_MATCH = "SELECT * FROM matches_scheduled WHERE match_id = ?";
	public static final String SELECT_TEAM = "SELECT * FROM player WHERE player_id IN(SELECT player_id FROM players_in_team WHERE team_id IN(SELECT team_id FROM team WHERE team_name= ? ))";
	public static final String PLAYERS_PICKED_INSERT = "INSERT INTO players_picked (user_id,match_id,player_id,credits) VALUES(?,?,?,?)";
	public static final String PLAYER_SELECTED_TEAM = "SELECT * FROM player WHERE player_id IN (SELECT player_id FROM players_picked WHERE user_id = ? AND match_id = ?);";
	public static final String CHAT_MESSAGES = "SELECT * FROM chat INNER JOIN users WHERE chat.user_id = users.user_id";
	public static final String CHAT_INSERT = "INSERT INTO chat (user_id,message) VALUES(?,?)";
	public static final String SELECT_FROM_PLAYERS_PICKED = "SELECT * FROM players_picked WHERE user_id = ? and match_id = ?";
	public static final String DELETE_EXISTING = "DELETE FROM players_picked WHERE user_id = ? AND match_id = ? ";
	public static final String SELECT_UPCOMMING_MATCHES = "SELECT * FROM matches_scheduled INNER JOIN match_status WHERE match_status.is_active = 0 AND is_upcomming =1 AND matches_scheduled.match_id = match_status.match_id";
	public static final String INSERT_INTO_PLAYING_TEAM = "INSERT INTO playing_team (match_id,player_id,points)VALUES (?,?,?)";
	public static final String DISABLE_UPCOMMING = "UPDATE match_status SET is_upcomming = 0 where match_id = ?";
	public static final String DISPLAY_COMPLETED_MATCHES = "SELECT * FROM matches_scheduled INNER JOIN match_status WHERE match_status.is_upcomming = 0 AND matches_scheduled.match_id = match_status.match_id";
	public static final String SCORE_CALCULATE = "SELECT * FROM players_picked INNER JOIN playing_team where players_picked.player_id = playing_team.player_id and user_id =? and players_picked.match_id = ?";
	public static final String CHECK_RESULT_TABLE = "SELECT * FROM result_board WHERE user_id = ? and match_id = ?";
	public static final String SELECT_PARTICULAR_MATCH_USERS = "SELECT DISTINCT(user_id) FROM players_picked where match_id = ?";
	public static final String PARTICULAR_USER_TOTAL_POINTS = "SELECT SUM(points) as total FROM players_picked INNER JOIN playing_team where players_picked.player_id = playing_team.player_id and user_id =? and players_picked.match_id = ? ";
	public static final String INSERT_INTO_RESULT_BOARD = "INSERT INTO result_board (user_id,match_id,match_points) VALUES (?,?,?)";
	public static final String SELECT_RESULT_TABLE = "SELECT * FROM result_board INNER JOIN users WHERE users.user_id = result_board.user_id AND match_id =? ";
	public static final String GET_TOP_PICKS = "SELECT player_id,count(player_id) AS k FROM players_picked a WHERE EXISTS (SELECT * FROM players_picked WHERE player_id = a.player_id AND match_id = ? )GROUP BY player_id ORDER BY k DESC";
	public static final String INSERT_INTO_MOSTLY_PICKED_PLAYERS = "INSERT INTO most_picked_players (player_id,match_id) VALUES (?,?)";
	public static final String SELECT_MOST_PICKED = "SELECT * FROM most_picked_players INNER JOIN player WHERE most_picked_players.player_id = player.player_id AND match_id =? ";
	public static final String SELECT_PARTICULAR_RESULT_TABLE = "SELECT * FROM result_board INNER JOIN users WHERE users.user_id = result_board.user_id AND result_board.user_id = ?";
	public static final String SELECT_UPCOMING_MATCHES = "SELECT * FROM matches_scheduled INNER JOIN match_status WHERE matches_scheduled.match_id = match_status.match_id AND is_active = 1;";
}
