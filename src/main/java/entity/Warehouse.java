package entity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Warehouse {
    private List<Author> authorList;

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "authorList=" + authorList +
                '}';
    }
}
