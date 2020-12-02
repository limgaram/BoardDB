
public class Member {
	private int id;
	private String memberId;
	private String memberPw;
	private String nickname;
	private String regDate;
	
	public Member() {
		
	}
	
	
	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memeberId) {
		memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		memberPw = memberPw;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Member(int id, String memberId, String memberPw, String regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.nickname = nickname;
		this.regDate = regDate;
	}
	
	
	

}
