/**
 * 
 */
package string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author stykky
 *
 */
public class StringMain {
	
	/*
	 * CONSTRUCTOR
	 */
	public StringMain() {}
	
	/*
	 * PUBLIC METHODS
	 */
	public void execute() {
		System.out.println();
		System.out.println("StringMain execution...");
		
		executeConcatenateStrings();
		executeBasics();
		executeCountVowels();
		executeCountDistinctVowels();
		executeConsonantsVowels();
		executeAreRotations();
		executeExtraCharacter();
		executeAlmostEqual();
		executeCountWords();
		executeValidatePassword();
		executePatternMatcher();
		
		System.out.println();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	private void executeConcatenateStrings() {
		List<String> list = new ArrayList<>();

		list.add( "santa" );
		list.add( "claus" );
		list.add( "is" );
		list.add( "arriving" );
		
		System.out.println( "The phrase is: " + concatenateStrings( list ) );
	}
	
	private String concatenateStrings( List<String> list ) {
		StringBuilder sb = new StringBuilder();
		
		list.stream().forEach(
				(s) -> {sb.append(s + " ");}
		);
		
		return sb.toString();
	}
	
	private void executeBasics() {
		String src1 = "geeks";
		String src2 = "for";
		String src3 = "geeks";
		String src4 = "GEEKS";
		
		System.out.println( "src1 is equals to src2: " + src1.equals(src2) );
		System.out.println( "src1 is equals to src3: " + src1.equals(src3) );
		System.out.println( "src2 is equals to src3: " + src2.equals(src3) );
		
		System.out.println( "length of src1: " + src1.length() );
		System.out.println( "length of src2: " + src2.length() );
		System.out.println( "length of src3: " + src3.length() );
		
		System.out.println(
				String.format( "src3 '%s' uppercase is: %s", src3, src3.toUpperCase())
		);
		System.out.println(
				String.format( "src4 '%s' lowercase is: %s", src4, src4.toLowerCase())
		);
	}
	
	private void executeCountVowels() {
		String src = "the fox is under a lazy dog";
		
		System.out.println(
				String.format("The string '%s' has %d vowels", src, countVowels(src))
		);
	}
	
	private int countVowels( String src ) {
		int vowelsNo = 0;
		
		for( int i = 0; i < src.length(); i++ ) {
			char c = src.charAt(i);
			
			if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ) {
				vowelsNo++;
			}
		}
		
		return vowelsNo;
	}
	
	private void executeCountDistinctVowels() {
		String src = "the table is red";
		
		System.out.println(
				String.format("The string '%s' has %d distinct vowels", src, countDistinctVowels(src))
		);
	}
	
	private int countDistinctVowels( String src ) {
		int distinctVowels = 0;
		
		if( src.contains("a") )
			distinctVowels++;
		if( src.contains("e") )
			distinctVowels++;
		if( src.contains("i") )
			distinctVowels++;
		if( src.contains("o") )
			distinctVowels++;
		if( src.contains("u") )
			distinctVowels++;
		
		return distinctVowels;
	}
	
	private void executeConsonantsVowels() {
		String src1 = "aerial";
		String src2 = "geek";
		String src3 = "river";
		
		System.out.println(
				String.format("The string '%s' has more vowerls than consonants: %s", src1, moreVowelsThanConsonants(src1))
		);
		System.out.println(
				String.format("The string '%s' has more vowerls than consonants: %s", src2, moreVowelsThanConsonants(src2))
		);
		System.out.println(
				String.format("The string '%s' has more vowerls than consonants: %s", src3, moreVowelsThanConsonants(src3))
		);
	}
	
	private String moreVowelsThanConsonants( String src ) {
		int consonantsNo = 0;
		int vowelsNo = 0;
		
		for( int i = 0; i < src.length(); i++ ) {
			char c = src.charAt(i);
			
			if( c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u' ) {
				vowelsNo++;
			}
			else {
				consonantsNo++;
			}
		}
		
		if( vowelsNo > consonantsNo ) {
			return "yes";
		}
		else if( vowelsNo == consonantsNo ) {
			return "same";
		}
		else {
			return "no";
		}
	}
	
	private void executeAreRotations() {
		String src1 = "geeksforgeeks";
		String src2 = "forgeeksgeeks";
		
		System.out.println(
				String.format("Strings '%s' and '%s' are rotations: %b", src1, src2, areRotations(src1, src2))
		);
	}
	
	private boolean areRotations( String src1, String src2 ) {
		if( src1.length() != src2.length() )
            return false;
            
        if( src1.equals(src2) )
            return true;
        
        for( int i = 1; i < src1.length(); i++ ) {
            String s1sub1 = src1.substring( 0, i );
            String s1sub2 = src1.substring( i );
            
            if( src2.contains(s1sub1) && src2.contains(s1sub2) ) {
                return true;
            }
        }
		
		return false;
	}
	
	private void executeExtraCharacter() {
		String src1 = "abba";
		String src2 = "abbxa";
		
		System.out.println(
				String.format("The extra character for '%s' and '%s' is: %c", src1, src2, extraCharacter(src1, src2))
		);
	}
	
	private Character extraCharacter( String src1, String src2 ) {
		if( src1.equals(src2) )
	        return null;
	        
	    StringBuffer sb1 = new StringBuffer(src1);
	    StringBuffer sb2 = new StringBuffer(src2);
	    
	    if( src1.length() > src2.length() ) {
	        for( int i = 0; i < src2.length(); i++ ) {
	        	int index = sb1.indexOf(src2.charAt(i)+"");
	        	
	            if( index >= 0 ) {
	            	sb1.deleteCharAt(index);
	            }
	        }

	        return sb1.charAt(0);
	    } else {
	        for( int i = 0; i < src1.length(); i++ ) {
	        	int index = sb2.indexOf(src1.charAt(i)+"");
	        	
	            if( index >= 0 ) {
	            	sb2.deleteCharAt(index);
	            }
	        }
	        
	        return sb2.charAt(0);
	    }
	}
	
	private void executeAlmostEqual() {
		String src1 = "suryansh";
		String src2 = "suryanshzzawesome";
		
		System.out.println(
				String.format("The strings '%s' and '%s' are almost equal for %d chars", src1, src2, almostEqual(src1, src2))
		);
	}
	
	private Integer almostEqual( String src1, String src2 ) {
		int[] string1 = new int[26];
		int[] string2 = new int[26];
	       
		char[] all_char = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	       
		int value;
		//	for string 1
		for( int i = 0 ; i < 26; i++ ) {
			if( src1.indexOf(all_char[i]) != -1 ) {
				value = frequency( src1, all_char[i] );
				string1[ i ] = value;
			}
			else {
				string1[i]=0;
			}
		}
		//	for string 2
		for( int j = 0; j < 26; j++ ) {
			if( src2.indexOf(all_char[j]) != -1 ) {
				value = frequency( src2 , all_char[j] );
				string2[j]=value;
			}
			else {
				string2[j]=0;
			}
		}
	       
	    // final calculation of the number of char to be deleted
	    int result = 0;
	    for( int k = 0; k < 26; k++ ) {
	    	while( string1[k] != string2[k] ) {
	    		if( string1[k] > string2[k] ) {
	    			string1[k]--;
	    			result++;
	    		}
	    		else {
	    			string2[k]--;
	    			result++;
	    		}
	    	}
	    }
	       
	    return result;
	}
	
	private Integer frequency( String s, Character a ) {
		int temp = 0;
		
		for( int i = 0; i < s.length(); i++ ) {
			if( s.charAt(i) == a ) {
				temp++;
			}
		}
		
		return temp;
	}
	
	private void executeCountWords() {
		String src = "the cat is above the table";
		
		System.out.println(
				String.format( "The words in '%s' are %d", src, countWords(src) )
		);
	}
	
	private Integer countWords( String src ) {
		StringTokenizer st = new StringTokenizer(src.trim(), " ");
		
		return st.countTokens();
	}

	private void executeValidatePassword() {
		String password = "abcdABCD1234@";
		
		System.out.println(
				String.format("The password '%s' is valid: %b", password, validatePassword(password))
		);
	}
	
	private boolean validatePassword( String password ) {
		if( password.length() < 10 )
            return false;
        
        boolean isValidNumeric = false;
        boolean isValidLowercase = false;
        boolean isValidUppercase = false;
        boolean isValidSpecial = false;
        
        for( int i = 0; i < password.length(); i++ ) {
            char c = password.charAt(i);
            
            if( '0' <= c && c <= '9' ) {
                isValidNumeric = true;
            }
            if( 'a' <= c && c <= 'z' ) {
                isValidLowercase = true;
            }
            if( 'A' <= c && c <= 'Z' ) {
                isValidUppercase = true;
            }
            if( c == '@' || c == '#' || c == '$' || c == '-' || c == '*' ) {
                isValidSpecial = true;
            }
        }
        
        return isValidNumeric && isValidLowercase && isValidUppercase && isValidSpecial;
	}
	
	private void executePatternMatcher() {
		String src1 = "xxxyyy";
		String src2 = "xxxyyyy";
		
		System.out.println(
				String.format( "The string '%s' is a valid pattern matcher: %b", src1, validatePatternMatcher(src1) )
		);
		System.out.println(
				String.format( "The string '%s' is a valid pattern matcher: %b", src2, validatePatternMatcher(src2) )
		);
	}
	
	private boolean validatePatternMatcher( String src ) {
		int n = 0;
        boolean wasPreviousY = false;
        
        for(int i = 0; i < src.length(); i++) {
            if( n < 0 ) {
                return false;
            }
            
            if( src.charAt(i) == 'x' ) {
                if( wasPreviousY && n > 0 ) {
                    return false;
                }
                
                wasPreviousY = false;
                n++;
            }
            
            if( src.charAt(i) == 'y' ) {
                wasPreviousY = true;
                n--;
            }
        }
        
        return n == 0;
	}
	
}
