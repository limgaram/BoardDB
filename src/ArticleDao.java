import java.util.ArrayList;

public class ArticleDao {

	private DBUtil2 db = new DBUtil2();

	public ArrayList<Article> getArticles() {
		String sql = "select * from article";
		return db.getRows(sql, new ArticleRowMapper());
	}

	public int updateArticle(String title, String body, int aid) {
		String sql = "update article set title = ?, body = ? where id = ?";
		return db.updateQuery(sql, title, body, aid);
	}

	public int deleteArticle(int aid) {
		String sql = "delete from article where id = ?";
		return db.updateQuery(sql, aid);
	}

	public int insertArticle(String title, String body) {
		String sql = "insert into article set title = ?, body = ?, nickname = '익명', regDate = NOW(), hit = 0";
		return db.updateQuery(sql, title, body);
	}

	public Article getArticleById(int aid) {
		String sql = "select * from article where id = ?";
		return db.getRow(sql, new ArticleRowMapper(), aid);
	}

	public int insertReply(int aid, String body) {
		String sql = "insert into reply set aid = ?, body = ?, writer = '익명', regDate = NOW()";
		return db.updateQuery(sql, aid, body);
	}

	public ArrayList<Reply> getRepliesByArticleId(int id) {
		String sql = "select * from reply where aid = ?";
		return db.getRows(sql, new ReplyRowMapper(), id);
	}

	public int insertMember(String memberId, String memberPw, String nickname) {
		String sql = "insert into member set memberId = ?, memberPw =?, nickname = ?, regDate = NOW()";
		return db.updateQuery(sql, new MemberRowMapper(), memberId, memberPw, nickname);
	}

//	public ArrayList<Member> getMembers(int id) {
//		String sql = "select * from member where id = ?";
//		return db.getRows(sql, new MemberRowMapper(), id);
//	}

	public ArrayList<Member> loginedMember(String memberId, String memberPw){
		String sql = "select * from member where memberId = ?, memberPw = ?";
		return db.getRows(sql, new MemberRowMapper(), memberId, memberPw);
	}
}
