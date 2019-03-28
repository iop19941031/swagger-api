package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MessageData")
public class MessageData {

  private int id;
  private String content;
  private String time;

  @XmlElement(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @XmlElement(name = "content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getTime() {
    return time;
  }

  @XmlElement(name = "time")
  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "MessageData{" +
        "id=" + id +
        ", content='" + content + '\'' +
        ", time='" + time + '\'' +
        '}';
  }

  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();
    MessageData d = new MessageData();
    d.setId(2);
    d.setContent("2222222222");
    try {
      String s = mapper.writeValueAsString(d);
      System.out.println(s);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
