package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;

class BookTest {

	@Test
	void test() {
//		Test 1
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		
		boolean isKidFriendlyEligible = book.isKidFriendly();
		assertFalse(isKidFriendlyEligible,"For Philosophy genre - isKidFriendly() should return false");
		
//		Test 2
		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		
		isKidFriendlyEligible = book.isKidFriendly();
		assertFalse(isKidFriendlyEligible,"For Self_Help genre - isKidFriendly() should return false");
		
	}

}
