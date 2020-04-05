package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void test() {
//		Test 1: porn in url -- false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--porn.html",
				"http://www.javaworld.com");
		boolean isKidFriendlyEligible = weblink.isKidFriendly();
		
		assertFalse(isKidFriendlyEligible, "For porn in url -- isKidFriendly() must return false");
		
//		Test 2: porn in title -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger porn , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendly();
		
		assertFalse(isKidFriendlyEligible, "For porn in title -- isKidFriendly() must return false");
		
//		Test 3: adult in host -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--.html",
				"http://www.javaworldadult.com");
		isKidFriendlyEligible = weblink.isKidFriendly();
		
		assertFalse(isKidFriendlyEligible, "For adult in host -- isKidFriendly() must return false");
		
//		Test 4: adult in url, but not in host part -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--adult.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendly();
		
		assertTrue(isKidFriendlyEligible, "For adult in url bur not in host -- isKidFriendly() must return true");
		
//		Test 5: adult in title only -- true 
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger adult , Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendly();
		
		assertTrue(isKidFriendlyEligible, "For adult in title -- isKidFriendly() must return true");
	}

}
