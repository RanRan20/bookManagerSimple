/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import UI.login;
import book.book;
import book.bookController;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class test {
    

    
    bookController bcontroller = new bookController();
    
    //first test
public void testSaveBook_Success() {
    
    book book = new book(1,"El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", 25.50);
    boolean result = bcontroller.saveBook(book);

    assertTrue(result);
    assertNotNull(book.getId());

}

@Test
public void testSaveBook_Failure_EmptyFields() {
    
    book book = new book(1,"", "nose", "Fantasía", 20.0);

    boolean result = bcontroller.saveBook(book);

   
    assertFalse(result);
}



//test 2

@Test
public void testDeleteBook_Success() {
    int bookId = 1;
    boolean result = bcontroller.deleteBook(bookId);

    assertTrue(result);
}

@Test
public void testDeleteBook_Failure_NoBookSelected() {
    int bookId = -1;   
    boolean result =bcontroller.deleteBook(bookId);

    assertFalse(result);
}


//test 3


public void testUpdateBook_Success() {
    book book = new book(1, "Libro sdf", "nose", "scify", 15.0);
    book.setName("Libro Actualizado");
    book.setAuthor("Autor Nuevo");
    book.setPrice(18.0);

    
    boolean result = bcontroller.updateBook(book);

 
    assertTrue(result);
}

@Test
public void testUpdateBook_Failure_InvalidData() {
  
    book book = new book(1, "asdqwe", "Autor lseo", "romance", 15.0);

    book.setName("");  
    boolean result = bcontroller.updateBook(book);

  
    assertFalse(result);
}



//test 4


@Test
public void testSearchBooks_Success() {
    List<book> books = bcontroller.searchBooks("Libro de Prueba", null, null);
    assertFalse(books.isEmpty());
}

@Test
public void testSearchBooks_Failure_NotFound() {
    List<book> books = bcontroller.searchBooks("Libro Inexistente", null, null);

    assertTrue(books.isEmpty());
}


//test 5

@Test
    public void testLogin_Success() {
        login loginUI = new login();

        loginUI.jUserField.setText("user");  
        loginUI.JpasswordField.setText("user4321");

        loginUI.jButtonEnter.doClick();

        assertTrue(true);  
    }

    @Test
    public void testLogin_Failure_Incorrect() {
        login loginUI = new login();

        loginUI.jUserField.setText("usuario1");  
        loginUI.JpasswordField.setText("sxD");

        loginUI.jButtonEnter.doClick();

        assertTrue(true);  
    }

    @Test
    public void testLogin_Failure_EmptyFields() {
        login loginUI = new login();

        loginUI.jUserField.setText("");  
        loginUI.JpasswordField.setText("");  

        loginUI.jButtonEnter.doClick();

        assertTrue(true);  
    }
}