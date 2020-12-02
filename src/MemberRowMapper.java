import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member getRow(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		String memberId = rs.getString("memberId");
		String memberPw = rs.getString("memberPw");
		String nickname = rs.getString("nickname");
		
		Member member = new Member();
		
		member.setId(id);
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		

	
		return member;
	}

}
