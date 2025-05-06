package Exercises.Pages;

import Exercises.Base;
import Exercises.Book;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BooksPage extends Base {
    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(className = "rt-noData")
    private WebElement noData;
    @FindBy(xpath = "//div[@class='rt-tbody']/div")
    private List<WebElement> booksList;
    Book[] books;


    @Step
    public void searchBook(String bookName) {
        this.searchBox.clear();
        this.searchBox.sendKeys(bookName);

    }



    public int booksSize() {
        return driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div/div/img")).size();
    }

    public List<WebElement> bookList() {
        return driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
    }

    @Step
    public void fillBooks() {
        List<WebElement> list = bookList();
        books=new Book[booksSize()];
        for (int i = 0; i < booksSize(); i++) {
            books[i]=new Book(bookList().get(i).findElement(By.tagName("a")).getText(),
                    bookList().get(i).findElement(By.xpath(".//div/div[3]")).getText(),
                    bookList().get(i).findElement(By.xpath(".//div/div[4]")).getText()
                    );
        }
    }

    @Step
    public boolean isNoData() {
        return noData.isDisplayed();
    }

    @Step
    public void printBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book No " + i + " " + books[i].toString());
        }
    }

}
