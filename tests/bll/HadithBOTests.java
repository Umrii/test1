package bll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dal.HadithDAOStub;

class HadithBOTests {
	
	static HadithBO bo;
	static HadithDAOStub daoStub;

	@BeforeAll
	static void coldStart() {
		daoStub = new HadithDAOStub();
		bo = new HadithBO(daoStub);
	}
		
	@Test
	@DisplayName("Checking the function size after it returns")
	void testGetNarratorOfHadithToAGivenNarrator() {
		Assertions.assertEquals(bo.getNarratorOfHadithToAGivenNarrator("منصور").size(),1);		
	}
	
	@Test
	@DisplayName("Checking the function size after it returns")
	void testGetNarratorOfHadithFromAGivenNarrator() {
		Assertions.assertEquals(bo.getNarrateorOfHadithFromAGivenNarrator("أبي صالح").size(),1);		
	}
	
	
	@Test
	@DisplayName("Checking the function size when it returns")
	void testGetUniqueNarratorsInABook() {
		Assertions.assertEquals(bo.getUniqueNarratorsInABook("سنن النسائى الصغرى").size(),11);		
	}

	@Test
	@DisplayName("Checking the function size when it returns")
	void testGetAllNarratorsAtLevelInABook() {
		Assertions.assertEquals(bo.getAllNarratorsAtLevelInABook("سنن النسائى الصغرى",1).size(),5);		
	}

}