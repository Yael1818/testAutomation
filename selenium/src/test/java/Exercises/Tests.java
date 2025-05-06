package Exercises;

import Exercises.Pages.BooksPage;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Listeners(listeners.class)
public class Tests extends Base {

    @Test(description = "login")
    @Description("Checks that logging in with valid user details is successful")
    public void test01_login() {
        loginPage.loginAction(Utils.getTagValue("username"), Utils.getTagValue("password"));
    }

    @Test(description = "move to store")
    @Description("Going to the bookstore")
    public void test02_moveToStore() {
        profilPage.moveToStore();
    }

    @Test(description = "print books")
    @Description("Print books found in the store")
    public void test03_printBooks() {
        booksPage.fillBooks();
        booksPage.printBooks();
    }

    @Test(description = "Search result")
    @Description("Looking for a book in the store")
    public void test04_searchBook() {
        booksPage.searchBook("git Pocket");
        assertEquals(booksPage.booksSize(), 1);

    }

    @Test(description = "Search result")
    @Description("Looking for a book in the store")
    public void test05_searchBook() {
        booksPage.searchBook("VeriSoft");
        assertEquals(booksPage.booksSize(), 0);
        assertTrue(booksPage.isNoData());

    }




}
