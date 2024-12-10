package article;

import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articles;
  private int lastId;

  public ArticleRepository() {
    articles = new java.util.ArrayList<>();
    lastId = 0;

    makeTestData();
  }

  void makeTestData(){
    IntStream.rangeClosed(1,100)
        .forEach(i -> write("제목" + i, "내용" + i));
  }

  public int write(String subject, String content) {
    int id = ++lastId;

    Article article = new Article(id, subject, content);

    articles.add(article);

      return id;
    }

    public List<Article> getSortedArticles(String orderBy) {
      List<Article> SortedArticles = articles;

      if (orderBy.equals("idAsc")) {
        return articles;
      }

      if (orderBy.equals("idDesc")) {
        SortedArticles = Util.reverseList(articles);
      }

    return SortedArticles;
  }

  public List<Article> getArticles(String searchKeyword, String orderBy){
  List<Article> filteredArticles = getSortedArticles(orderBy);

  if(!searchKeyword.trim().isEmpty()){
    filteredArticles = new ArrayList<>();

    for (Article article : articles){
      boolean matched = article.getSubject().contains(searchKeyword) || article.getContent().contains(searchKeyword);

      if(matched) filteredArticles.add(article);
    }
  }

  return filteredArticles;
  }

  public void modify(int id, String subject, String content) {
    Article article = findById(id);

    if(article != null) {
      article.setSubject(subject);
      article.setContent(content);
    }
  }

  public void delete(int id) {
    Article article = findById(id);

    if (article != null) {
      articles.remove(article);
    }
  }

  public Article findById(int id){
    return articles.stream()
        .filter(article -> article.getId() == id)
        .findFirst()
        .orElse(null);
  }
}


