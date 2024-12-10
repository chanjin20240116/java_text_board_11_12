package container;

import article.ArticleController;
import article.ArticleRepository;
import article.ArticleService;
import session.Session;
import member.MemberController;
import member.MemberRepository;
import member.MemberService;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}