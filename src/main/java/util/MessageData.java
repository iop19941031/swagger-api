package util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MessageData")
public class MessageData {
    private String content;

    public MessageData(String content) {
        this.content = content;
    }

    @XmlElement(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
