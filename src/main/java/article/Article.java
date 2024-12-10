package article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @NoArgsConstructor
 @AllArgsConstructor
 @Data
 public class Article{
   private int id;
   private String subject;
   private String content;
}
