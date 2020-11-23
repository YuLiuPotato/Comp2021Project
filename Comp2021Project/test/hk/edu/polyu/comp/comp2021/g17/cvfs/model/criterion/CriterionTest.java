package hk.edu.polyu.comp.comp2021.g17.cvfs.model.criterion;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.file.*;


class CriterionTest {
	
	Document testDoc1;
	Document testDoc2;
	Document testDoc3;
	Document testDoc4;
	Directory testDir1;
	Criterion criName;
	Criterion criType;
	Criterion criSize;
	Criterion isDocument;
	Criterion binCri1;
	Criterion binCri2;
	
	Criterion negCri1, negCri2, negCri3;
	
	CriterionTest() {
		try {
			testDoc1 = new Document("testDoc1", DocumentType.txt, "A text file");
			testDoc2 = new Document("testDoc2", DocumentType.java, "A java file");
			testDoc3 = new Document("testDoc3", DocumentType.html, "A html file");
			testDoc4 = new Document("testDoc4", DocumentType.css, "A css file");
			testDir1 = new Directory("testDir1", null);
			
			criName = Criterion.newSimpleCri("cn", "name", "contains", "testDoc1");
			criSize = Criterion.newSimpleCri("sc", "size", "LE", "100");
			criType = Criterion.newSimpleCri("ct", "type", "equals", "txt");
			isDocument = Criterion.genIsDocument();
			
			binCri1 = Criterion.newBinaryCri("bc", criName, criSize, "AND");
			binCri2 = Criterion.newBinaryCri("bc", criName, criSize, "OR");
			
			negCri1 = Criterion.newNegation("nn", criName);
			negCri2 = Criterion.newNegation("nn", negCri1);
			negCri3 = Criterion.newNegation("nn", binCri1); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	@Order(1)
	void simpleAssertTest() {
		try {
			assertEquals(true, criName.assertCri(testDoc1));
			System.out.println(criName.toString());
			assertEquals(true, criType.assertCri(testDoc1));
			System.out.println(criType.toString());
			assertEquals(true, criSize.assertCri(testDoc1));
			System.out.println(criSize.toString());
			assertEquals(false, isDocument.assertCri(testDir1));
			System.out.println(isDocument.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	@Order(2)
	void binAssertTest() {
		try {
			assertEquals(false, binCri1.assertCri(testDoc2));
			System.out.println(binCri1.toString());
			assertEquals(true, binCri2.assertCri(testDoc2));
			System.out.println(binCri2.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Order(3)
	void negAssertTest() {
		try {
			assertEquals(false, negCri1.assertCri(testDoc1));
			System.out.println(negCri1.toString());
			assertEquals(true, negCri2.assertCri(testDoc1));
			System.out.println(negCri2.toString());
			assertEquals(true, negCri3.assertCri(testDoc2));
			System.out.println(negCri3.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	void throwInvalidArgumentTest() {
		assertThrows(IllegalArgumentException.class, () -> Criterion.newSimpleCri("notAValidName","name","contains","ah"));
		assertThrows(IllegalArgumentException.class, () -> Criterion.newSimpleCri("aa","name","equals","ah"));
		assertThrows(IllegalArgumentException.class, () -> Criterion.newSimpleCri("aa","size","contains","ah"));
		assertThrows(IllegalArgumentException.class, () -> Criterion.newSimpleCri("aa","size","GE","notanumber"));
	}
	
	

}
