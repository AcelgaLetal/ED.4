package ule.edi.SimpleList;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SingleLinkedListImplTests {

	

	private SingleLinkedListImpl<String> lS;
	private SingleLinkedListImpl<String> lSABC;
	

	@Before
	public void setUp() {
		this.lS = new SingleLinkedListImpl<String>();
		
		
		this.lSABC = new SingleLinkedListImpl<String>("A", "B", "C", "D");
	}
	
   @Test
   public void constructorElemens(){
	   lS=new SingleLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("[A, B, C, D]", lS.toString());
	   Assert.assertEquals(4, lS.size());
	   lS.addAtPos("X", 3);
	   Assert.assertEquals("[A, B, X, C, D]", lS.toString());
	   lS.addAtPos("Z", 4);
	   Assert.assertEquals("[A, B, X, Z, C, D]", lS.toString());
	   Assert.assertEquals(2, lS.indexOf("B"));
	   Assert.assertEquals(4, lS.indexOf("Z"));
   }

   @Test
   public void addAtPos(){
	   
	   lS.addAtPos("A", 1);
	   Assert.assertEquals("[A]", lS.toString());
	   lS.addAtPos("C", 1);
	   Assert.assertEquals("[C, A]", lS.toString());
	   lS.addAtPos("B", 2);
	   Assert.assertEquals("[C, B, A]", lS.toString());
	   lS.addAtPos("D", 5);
	   Assert.assertEquals("[C, B, A, D]", lS.toString());
   }
   
   @Test
   public void addNTimes(){
	   
	   lS.addNTimes("A", 3);
	   Assert.assertEquals("[A, A, A]", lS.toString());
	   lS.addNTimes("B", 2);
	   Assert.assertEquals("[A, A, A, B, B]", lS.toString());
	   
   }
// TEST DE SUBLIST
	@Test
	public void tesSubListEnListaVacia() {
	
		Assert.assertEquals(-1, lS.isSubList(lSABC));		
	}

		@Test
		public void tesSubListConSubListaVacia() {
			Assert.assertEquals(1, lSABC.isSubList(lS));		
		}
		
		
		@Test
		public void subListVarios() {
			lS = new SingleLinkedListImpl<String>("A", "B", "C", "D", "E");
			Assert.assertEquals(1, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("Z", "X", "A", "B", "C", "D", "E");
			Assert.assertEquals(3, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("A", "X", "A", "B", "C");
			Assert.assertEquals(-1, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("A", "B", "C");
			Assert.assertEquals(-1, lS.isSubList(lSABC));	
		}
	
	@Test
	public void exceptionIndexOf()
	{
		lS.indexOf("B");
	}
	
	@Test
	public void exception2IndexOf()
	{
		lS.addFirst("V");
		lS.addLast("A");
		lS.addLast("C");
		lS.addLast("D");
		lS.addFirst("Z");
		Assert.assertEquals("[Z, V, A, C, D]", lS.toString());
		lS.indexOf("B");
	}
	
	@Test 
	public void testRemoveLast() throws Exception
	{
		lS.addLast("A");
		Assert.assertEquals("A", lS.removeLast());
		Assert.assertEquals("[]", lS.toString());
		lS.addLast("A");
		Assert.assertEquals("[A]", lS.toString());
		lS.addLast("B");
		Assert.assertEquals("[A, B]", lS.toString());
		Assert.assertEquals("B", lS.removeLast());
		Assert.assertEquals("[A]", lS.toString());
		lS.addLast("B");
		lS.addLast("C");
		Assert.assertEquals("[A, B, C]", lS.toString());
		Assert.assertEquals("C", lS.removeLast());
		Assert.assertEquals("[A, B]", lS.toString());
		lS.addLast("Z");
		lS.addLast("L");
		lS.addLast("X");
		lS.addLast("V");
		Assert.assertEquals("[A, B, Z, L, X, V]", lS.toString());
		Assert.assertEquals("V", lS.removeLast());
		Assert.assertEquals("[A, B, Z, L, X]", lS.toString());
		Assert.assertEquals("A", lS.removeLast("A"));
		Assert.assertEquals("[B, Z, L, X]", lS.toString());
		Assert.assertEquals("Z", lS.removeLast("Z"));
		Assert.assertEquals("[B, L, X]", lS.toString());
		Assert.assertEquals("X", lS.removeLast("X"));
		Assert.assertEquals("[B, L]", lS.toString());
		lS.addLast("Z");
		lS.addLast("X");
		lS.addLast("V");
		Assert.assertEquals("[B, L, Z, X, V]", lS.toString());
		Assert.assertEquals("X", lS.removeLast("X"));
		Assert.assertEquals("[B, L, Z, V]", lS.toString());
	}
	
	@Test 
	public void testReverse()
	{
		lS.addLast("Z");
		lS.addLast("L");
		lS.addLast("X");
		lS.addLast("V");
		Assert.assertEquals("[Z, L, X, V]", lS.toString());
		lS.reverse();
		Assert.assertEquals("[V, X, L, Z]", lS.toString());
	}

}
