import java.util.ArrayList;
import java.util.Scanner;

public class BoardDB {

	public static void main(String[] args) {
		ArticleDao articleDao = new ArticleDao();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if (cmd.equals("list")) {
				ArrayList<Article> articles = articleDao.getArticles();
				for (int i = 0; i < articles.size(); i++) {
					System.out.println(articles.get(i).getTitle());
				}
			} else if (cmd.equals("update")) {
				System.out.print("수정할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());

				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				articleDao.updateArticle(title, body, aid);
			} else if (cmd.equals("delete")) {
				System.out.print("삭제할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());
				articleDao.deleteArticle(aid);
			} else if (cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();

				articleDao.insertArticle(title, body);
			} else if (cmd.equals("read")) {
				System.out.print("상세보기할 게시물 번호 : ");
				int aid = Integer.parseInt(sc.nextLine());

				Article article = articleDao.getArticleById(aid);

				if (article == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					ArrayList<Reply> replies = articleDao.getRepliesByArticleId(article.getId());
					printArticle(article, replies);

					while (true) {
						System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
						int dcmd = Integer.parseInt(sc.nextLine());
						if (dcmd == 1) {
							System.out.print("내용을 입력해주세요 :");
							String body = sc.nextLine();
							articleDao.insertReply(article.getId(), body);
							ArrayList<Reply> replies2 = articleDao.getRepliesByArticleId(article.getId());
							printArticle(article, replies2);
						} else {
							break;
						}
					}
				}
			} else if (cmd.equals("signup")) {
				System.out.println("아이디 : ");
				String memberId = sc.nextLine();
				System.out.println("비밀번호 : ");
				String memberPw = sc.nextLine();
				System.out.println("닉네임 : ");
				String nickname = sc.nextLine();

				articleDao.insertMember(memberId, memberPw, nickname);

				System.out.println("회원가입 완료");

			} else if (cmd.equals("signin")) {

				System.out.println("아이디 : ");
				String memberId = sc.nextLine();
				System.out.println("비밀번호 : ");
				String memberPw = sc.nextLine();

				ArrayList<Member> members = new ArrayList<>();

				Member loginedmember = articleDao.loginedMember(memberId, memberPw);

				if (member != loginedmember) {
					System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
				} else {
					System.out.println(memberId + "님 환영합니다.");
				}

			}
		}
	}

	public static void printArticle(Article article, ArrayList<Reply> replies) {
		System.out.println("번호 : " + article.getId());
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getBody());
		System.out.println("==== 댓글 ====");

		for (int i = 0; i < replies.size(); i++) {
			System.out.println("내용 : " + replies.get(i).getBody());
			System.out.println("작성자 : " + replies.get(i).getWriter());
			System.out.println("=============================");
		}

	}
}
