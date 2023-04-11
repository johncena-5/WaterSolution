package Script;

import org.testng.annotations.Test;

public class Str {

	@Test
		public void java() {
		String s = "Dhoni is good player";
		String name = "sachin";
		String word = "";
		String full = s.replaceFirst("Dhoni", name);
		
		//System.out.println(full);
		
		String [] w = s.split(" ");
		for(int i=0; i<w.length;i++) {
			
			if(w[i].equalsIgnoreCase("is")) {
				word = word+name+" ";
			}else {
				
				word = word+w[i]+" ";
			}		
		}
		System.out.println(word);
		
	}
}
