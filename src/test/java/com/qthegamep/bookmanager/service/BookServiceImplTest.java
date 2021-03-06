package com.qthegamep.bookmanager.service;

import com.qthegamep.bookmanager.dao.BookDAO;
import com.qthegamep.bookmanager.dao.BookDAOImpl;
import com.qthegamep.bookmanager.entity.Book;
import com.qthegamep.bookmanager.testhelper.rule.Rules;
import com.qthegamep.bookmanager.util.SessionUtil;

import lombok.val;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @ClassRule
    public static ExternalResource summaryRule = Rules.SUMMARY_RULE;

    @Rule
    public Stopwatch stopwatchRule = Rules.STOPWATCH_RULE;
    @Rule
    public ExternalResource resetDatabaseRule = Rules.RESET_DATABASE_RULE;

    private BookService bookService;
    private BookService bookServiceWithMock;

    private BookDAO bookDAO;
    @Mock
    private BookDAO bookDAOMock;

    private Book firstBook;
    private Book secondBook;

    private List<Book> books;

    @Before
    public void setUp() {
        bookService = new BookServiceImpl();
        bookServiceWithMock = new BookServiceImpl();

        bookDAO = new BookDAOImpl();

        ((BookServiceImpl) bookService).setBookDAO(bookDAO);
        ((BookServiceImpl) bookServiceWithMock).setBookDAO(bookDAOMock);

        firstBook = new Book();

        firstBook.setId(1);
        firstBook.setName("test firstBook");
        firstBook.setAuthor("test firstAuthor");
        firstBook.setPrintYear(2000);
        firstBook.setRead(false);

        secondBook = new Book();

        secondBook.setId(2);
        secondBook.setName("test secondBook");
        secondBook.setAuthor("test secondAuthor");
        secondBook.setPrintYear(2010);
        secondBook.setRead(true);

        books = List.of(firstBook, secondBook);
    }

    @After
    public void tearDown() throws SQLException {
        SessionUtil.closeConnection();
    }

    @Test
    public void shouldCreateObjectWithNoArgsConstructor() {
        assertThat(bookService).isNotNull();
        assertThat(bookServiceWithMock).isNotNull();
    }

    @Test
    public void shouldImplementsBookServiceInterface() {
        assertThat(bookService).isInstanceOf(BookService.class);
        assertThat(bookServiceWithMock).isInstanceOf(BookService.class);
    }

    @Test
    public void shouldBeEmptyDatabaseBeforeEachTest() throws SQLException {
        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isNotNull().isEmpty();
    }

    @Test
    public void shouldGetAndSetBookDAO() {
        val newBookDAO = new BookDAOImpl();

        ((BookServiceImpl) bookService).setBookDAO(newBookDAO);

        assertThat(((BookServiceImpl) bookService).getBookDAO()).isNotNull().isEqualTo(newBookDAO);
    }

    @Test
    public void shouldAddBookCorrectly() throws SQLException {
        bookService.add(firstBook);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallAddMethodCorrectly() throws SQLException {
        bookServiceWithMock.add(firstBook);

        verify(bookDAOMock, times(1)).add(firstBook);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldAddAllBooksCorrectly() throws SQLException {
        bookService.addAll(books);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isNotEmpty().isEqualTo(books);
    }

    @Test
    public void shouldCallAddAllMethodCorrectly() throws SQLException {
        bookServiceWithMock.addAll(books);

        verify(bookDAOMock, times(1)).addAll(books);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetByIdBookCorrectly() throws SQLException {
        bookDAO.add(firstBook);

        val book = bookService.getById(1);

        assertThat(book).isEqualTo(firstBook);
    }

    @Test
    public void shouldCallGetByIdMethodCorrectly() throws SQLException {
        bookServiceWithMock.getById(1);

        verify(bookDAOMock, times(1)).getById(1);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetByNameBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        val allBooks = bookService.getByName("test firstBook");

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallGetByNameMethodCorrectly() throws SQLException {
        bookServiceWithMock.getByName("test firstBook");

        verify(bookDAOMock, times(1)).getByName("test firstBook");

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetByAuthorBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        val allBooks = bookService.getByAuthor("test firstAuthor");

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallGetByAuthorMethodCorrectly() throws SQLException {
        bookServiceWithMock.getByAuthor("test firstAuthor");

        verify(bookDAOMock, times(1)).getByAuthor("test firstAuthor");

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetByPrintYearBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        val allBooks = bookService.getByPrintYear(2000);

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallGetByPrintYearMethodCorrectly() throws SQLException {
        bookServiceWithMock.getByPrintYear(2000);

        verify(bookDAOMock, times(1)).getByPrintYear(2000);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetByIsReadBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        val allBooks = bookService.getByIsRead(false);

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallGetByIsReadMethodCorrectly() throws SQLException {
        bookServiceWithMock.getByIsRead(false);

        verify(bookDAOMock, times(1)).getByIsRead(false);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldGetAllBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        val allBooks = bookService.getAll();

        assertThat(allBooks).isNotEmpty().isEqualTo(books);
    }

    @Test
    public void shouldCallGetAllMethodCorrectly() throws SQLException {
        bookServiceWithMock.getAll();

        verify(bookDAOMock, times(1)).getAll();

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldUpdateBookCorrectly() throws SQLException {
        bookDAO.add(firstBook);

        firstBook.setPrintYear(9999);

        bookService.update(firstBook);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isNotEmpty().contains(firstBook);
    }

    @Test
    public void shouldCallUpdateMethodCorrectly() throws SQLException {
        bookServiceWithMock.update(firstBook);

        verify(bookDAOMock, times(1)).update(firstBook);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldUpdateAllBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        firstBook.setPrintYear(9999);
        secondBook.setPrintYear(8888);

        bookService.updateAll(books);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isNotEmpty().isEqualTo(books);
    }

    @Test
    public void shouldCallUpdateAllMethodCorrectly() throws SQLException {
        bookServiceWithMock.updateAll(books);

        verify(bookDAOMock, times(1)).updateAll(books);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldRemoveBookCorrectly() throws SQLException {
        bookDAO.add(firstBook);

        bookService.remove(firstBook);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isEmpty();
    }

    @Test
    public void shouldCallRemoveMethodCorrectly() throws SQLException {
        bookServiceWithMock.remove(firstBook);

        verify(bookDAOMock, times(1)).remove(firstBook);

        verifyNoMoreInteractions(bookDAOMock);
    }

    @Test
    public void shouldRemoveAllBooksCorrectly() throws SQLException {
        bookDAO.addAll(books);

        bookService.removeAll(books);

        val allBooks = bookDAO.getAll();

        assertThat(allBooks).isEmpty();
    }

    @Test
    public void shouldCallRemoveAllMethodCorrectly() throws SQLException {
        bookServiceWithMock.removeAll(books);

        verify(bookDAOMock, times(1)).removeAll(books);

        verifyNoMoreInteractions(bookDAOMock);
    }
}
